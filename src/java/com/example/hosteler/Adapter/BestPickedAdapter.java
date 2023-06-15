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
import com.example.hosteler.ProductDetailActivity;
import com.example.hosteler.R;

import java.util.List;


public class BestPickedAdapter extends RecyclerView.Adapter<BestPickedAdapter.ViewHolder>{

    private List<BestPickedModel> bestPickedModelList;

    public BestPickedAdapter(List<BestPickedModel> bestPickedModelList) {
        this.bestPickedModelList = bestPickedModelList;
    }

    @NonNull
    @Override
    public BestPickedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestPickedAdapter.ViewHolder viewHolder, int position) {
        String image = bestPickedModelList.get(position).getImageView();
        String name = bestPickedModelList.get(position).getItemName();
        String location = bestPickedModelList.get(position).getItemLocation();
        String currentPrice = bestPickedModelList.get(position).getItemCurrentPrice();
        String totalPrice = bestPickedModelList.get(position).getItemTotalPrice();
        String discount = bestPickedModelList.get(position).getItemDiscount();
        String rating = bestPickedModelList.get(position).getRating();
        String totalRating = bestPickedModelList.get(position).getTotalRating();
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
        return bestPickedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView itemName, itemLocation, itemCurrentPrice, itemTotalPrice, itemDiscount, rating, totalRating;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.item_image_bestpicked);
            itemName = itemView.findViewById(R.id.product_title);
            itemLocation = itemView.findViewById(R.id.item_location_bestpicked);
            itemCurrentPrice = itemView.findViewById(R.id.product_price);
            itemTotalPrice = itemView.findViewById(R.id.cutted_price);
            itemDiscount = itemView.findViewById(R.id.tv_product_discount);
            rating = itemView.findViewById(R.id.rating);
            totalRating = itemView.findViewById(R.id.total_ratings);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
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
