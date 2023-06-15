package com.example.hosteler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hosteler.Adapter.RewardsAdapter;
import com.example.hosteler.Model.RewardsModel;

import java.util.ArrayList;
import java.util.List;


public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardsRecyclerView = view.findViewById(R.id.my_rewards_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardsModel> rewardsModelList = new ArrayList<>();
        rewardsModelList.add(new RewardsModel("CashBack","till 2nd,June 2023","GET 20% CASHBACK on any hostel above Rs.9,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through Paytm","till 8nd,June 2023","GET 30% CASHBACK on any hostel above Rs.12,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through PhonePay","till 15nd,June 2023","GET 15% CASHBACK on any hostel above Rs.10,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through UPI","till 25nd,June 2023","GET 20% CASHBACK on any hostel above Rs.9,000/-"));
        rewardsModelList.add(new RewardsModel("CashBack","till 2nd,August 2023","GET 20% CASHBACK on any hostel above Rs.9,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through Paytm","till 15nd,August 2023","GET 25% CASHBACK on any hostel above Rs.10,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through PhonePay","till 20nd,August 2023","GET 10% CASHBACK on any hostel above Rs.9,000/-"));
        rewardsModelList.add(new RewardsModel("CashBack","till 2nd,December 2023","GET 20% CASHBACK on any hostel above Rs.10,000/-"));
        rewardsModelList.add(new RewardsModel("Pay through UPI","till 15nd,December 2023","GET 20% CASHBACK on any hostel above Rs.9,000/-"));

        RewardsAdapter rewardsAdapter = new RewardsAdapter(rewardsModelList);
        rewardsRecyclerView.setAdapter(rewardsAdapter);
        rewardsAdapter.notifyDataSetChanged();
        return view;
    }
}