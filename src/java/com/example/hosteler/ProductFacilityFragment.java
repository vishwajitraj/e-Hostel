package com.example.hosteler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hosteler.Adapter.ProductFacilityAdapter;
import com.example.hosteler.Model.ProductFacilityModel;

import java.util.ArrayList;
import java.util.List;


public class ProductFacilityFragment extends Fragment {



    public ProductFacilityFragment() {
        // Required empty public constructor
    }


    private RecyclerView productSpecificationRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_facility, container, false);
        productSpecificationRecyclerView = view.findViewById(R.id.product_specification_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductFacilityModel> productFacilityModelList = new ArrayList<>();
        productFacilityModelList.add(new ProductFacilityModel("1","Homely Mess"));
        productFacilityModelList.add(new ProductFacilityModel("2","AC"));
        productFacilityModelList.add(new ProductFacilityModel("3","Free Wi-Fi"));
        productFacilityModelList.add(new ProductFacilityModel("4","Parking facility"));
        productFacilityModelList.add(new ProductFacilityModel("5","Power backup"));
        productFacilityModelList.add(new ProductFacilityModel("6","UPI/Card payment"));
        productFacilityModelList.add(new ProductFacilityModel("7","CCTV camera"));
        productFacilityModelList.add(new ProductFacilityModel("8","Attached Bathroom"));
        productFacilityModelList.add(new ProductFacilityModel("9","Fresh filtered drinking water with the available of cold"));
        productFacilityModelList.add(new ProductFacilityModel("10","Drinking water in summers, Geysers in winters"));
        productFacilityModelList.add(new ProductFacilityModel("11","Entertainment facility like T.V., News Paper, Indoor Games."));
        productFacilityModelList.add(new ProductFacilityModel("12","First aid facility"));
        productFacilityModelList.add(new ProductFacilityModel("13","24-hour security"));

        ProductFacilityAdapter productFacilityAdapter = new ProductFacilityAdapter(productFacilityModelList);
        productSpecificationRecyclerView.setAdapter(productFacilityAdapter);
        productFacilityAdapter.notifyDataSetChanged();
        return view;
    }
}