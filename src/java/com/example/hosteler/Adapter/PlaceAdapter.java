package com.example.hosteler.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hosteler.Model.PlaceModel;
import com.example.hosteler.PlaceActivity;
import com.example.hosteler.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<PlaceModel> placeModelList;

    public PlaceAdapter(List<PlaceModel> placeModelList) {
        this.placeModelList = placeModelList;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_loaction,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder viewHolder, int position) {
        String image = placeModelList.get(position).getPlaceImageLink();
        String name = placeModelList.get(position).getPlaceName();
        viewHolder.setPlaceIcon(image);
        viewHolder.setPlaceName(name,position);

    }

    @Override
    public int getItemCount() {
        return placeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ShapeableImageView placeIcon;
        private TextView placeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeIcon = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);

        }

        public void setPlaceIcon(String placeUrl) {
            if(!placeUrl.equals("null")) {
                Glide.with(itemView.getContext()).load(placeUrl).apply(new RequestOptions().placeholder(R.drawable.side_nav_bar)).into(placeIcon);
            }
        }
        public void setPlaceName(String name, final int position) {
            placeName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position != 0){
                        Intent categoryIntent = new Intent(itemView.getContext(), PlaceActivity.class);
                        categoryIntent.putExtra("Place",name);
                        itemView.getContext().startActivity(categoryIntent);
                    }
                }
            });
        }

    }
}
