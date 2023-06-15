package com.example.hosteler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hosteler.Adapter.MyOrderAdapter;
import com.example.hosteler.Model.MyOrderItemModel;

import java.util.ArrayList;
import java.util.List;


public class MyBookingFragment extends Fragment {


    public MyBookingFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrderRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_booking, container,false);
        myOrderRecyclerView = view.findViewById(R.id.my_booking_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.hostel_image, 2, "ABC Hostel", "Check-Out on Thr, 30 Mar 2023"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.hostel_image_kcc, 3, "KCC Hostel", "Check-Out on Fri, 31 Mar 2023"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.hostel_image, 1, "RPH Hostel", "Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.hostel_image_kcc, 4, "BND Hostel", "Check-Out on Fri, 31 Mar 2023"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }
}