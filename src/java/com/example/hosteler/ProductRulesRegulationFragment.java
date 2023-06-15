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

public class ProductRulesRegulationFragment extends Fragment {


    public ProductRulesRegulationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productRulesRegulationRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_rules_regulation, container, false);
        productRulesRegulationRecyclerView = view.findViewById(R.id.product_rules_regulation_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productRulesRegulationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductFacilityModel> productRulesRegulationList = new ArrayList<>();
        productRulesRegulationList.add(new ProductFacilityModel("1","Homely Mess"));


        ProductFacilityAdapter productFacilityAdapter = new ProductFacilityAdapter(productRulesRegulationList);
        productRulesRegulationRecyclerView.setAdapter(productFacilityAdapter);
        productFacilityAdapter.notifyDataSetChanged();
        return view;
    }
}