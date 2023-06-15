package com.example.hosteler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosteler.Model.RewardsModel;
import com.example.hosteler.R;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.Viewholder> {

    private List<RewardsModel> rewardsModelList;

    public RewardsAdapter(List<RewardsModel> rewardsModelList) {
        this.rewardsModelList = rewardsModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String title = rewardsModelList.get(position).getTitle();
        String date = rewardsModelList.get(position).getExpiryDate();
        String body = rewardsModelList.get(position).getCouponBody();
        viewholder.setData(title,date,body);

    }

    @Override
    public int getItemCount() {
        return rewardsModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView couponTitle;
        private TextView couponExpiryDate;
        private TextView couponBody;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            couponTitle = itemView.findViewById(R.id.coupon_title);
            couponExpiryDate = itemView.findViewById(R.id.coupon_valid);
            couponBody = itemView.findViewById(R.id.coupon_body);
        }

        private void setData(String title, String date, String body){
            couponTitle.setText(title);
            couponExpiryDate.setText(date);
            couponBody.setText(body);
        }
    }
}
