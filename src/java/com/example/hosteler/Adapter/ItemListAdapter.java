package com.example.hosteler.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hosteler.Model.BestPickedModel;
import com.example.hosteler.Model.ItemListModel;
import com.example.hosteler.ProductDetailActivity;
import com.example.hosteler.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.itemViewHolder> {

    List<ItemListModel> nearbyArrayList;

    public ItemListAdapter(List<ItemListModel> nearbyArrayList) {
        this.nearbyArrayList = nearbyArrayList;
    }

    @NonNull
    @Override
    public ItemListAdapter.itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productDetailsIntent = new Intent(viewGroup.getContext(), ProductDetailActivity.class);
                viewGroup.getContext().startActivity(productDetailsIntent);
            }
        });
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.itemViewHolder viewHolder, int position) {

        String image = nearbyArrayList.get(position).getImageView();
        String name = nearbyArrayList.get(position).getItemName();
        String location = nearbyArrayList.get(position).getItemLocation();
        String currentPrice = nearbyArrayList.get(position).getItemCurrentPrice();
        String totalPrice = nearbyArrayList.get(position).getItemTotalPrice();
        String discount = nearbyArrayList.get(position).getItemDiscount();
        String rating = nearbyArrayList.get(position).getRating();
        String totalRating = nearbyArrayList.get(position).getTotalRating();
        viewHolder.setImageView(image);
        viewHolder.setItemName(name);
        viewHolder.setItemLocation(location);
        viewHolder.setItemCurrentPrice(currentPrice);
        viewHolder.setItemTotalPrice(totalPrice);
        viewHolder.setItemDiscount(discount);
        viewHolder.setRating(rating);
        viewHolder.setTotalRating(totalRating);

    }

    @Override
    public int getItemCount() {
        return nearbyArrayList.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView itemName, itemLocation, itemCurrentPrice, itemTotalPrice, itemDiscount,rating, totalRating;


        public itemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.item_image_bestpicked);
            itemName = itemView.findViewById(R.id.product_title);
            itemLocation = itemView.findViewById(R.id.item_location_bestpicked);
            itemCurrentPrice = itemView.findViewById(R.id.product_price);
            itemTotalPrice = itemView.findViewById(R.id.cutted_price);
            itemDiscount = itemView.findViewById(R.id.tv_product_discount);
            rating = itemView.findViewById(R.id.rating);
            totalRating = itemView.findViewById(R.id.total_ratings);

        }
        public void setImageView(String imageUrl){
            Glide.with(itemView.getContext()).load(imageUrl).apply(new RequestOptions().placeholder(R.drawable.side_nav_bar)).into(imageView);
        }
        public void setItemName(String name){
            itemName.setText(name);
        }
        public void setItemLocation(String location){
            itemLocation.setText(location);
        }
        public void setItemCurrentPrice(String currentPrice){
            itemCurrentPrice.setText(currentPrice);
        }
        public void setItemTotalPrice(String totalPrice){
            itemTotalPrice.setText(totalPrice);
        }
        public void setItemDiscount(String discount){
            itemDiscount.setText(discount);
        }
        public void setRating(String ratingNo){
            rating.setText(ratingNo);
        }
        public void setTotalRating(String totalRatingNo){
            totalRating.setText(totalRatingNo);
        }
    }

}
