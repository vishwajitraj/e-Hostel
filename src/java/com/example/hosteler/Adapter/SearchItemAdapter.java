package com.example.hosteler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosteler.Model.SearchItemModel;
import com.example.hosteler.R;

import java.util.List;

public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.ViewHolder> {

    private List<SearchItemModel> searchItemModelList;

    public SearchItemAdapter(List<SearchItemModel> searchItemModelList) {
        this.searchItemModelList = searchItemModelList;
    }

    public void setFilteredList(List<SearchItemModel> filteredList){
        this.searchItemModelList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemAdapter.ViewHolder holder, int position) {
        SearchItemModel searchItemModel = searchItemModelList.get(position);
        holder.itemNameTv.setText(searchItemModel.getItemName());
        holder.itemImageView.setImageResource(searchItemModel.getItemImage());

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_one));

    }

    @Override
    public int getItemCount() {
        if(searchItemModelList == null){
            return 0;
        }else{
            return searchItemModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemNameTv;
        private ImageView itemImageView;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.eachCardView);
            itemImageView = itemView.findViewById(R.id.each_item_imageView);
            itemNameTv = itemView.findViewById(R.id.each_item_name);
        }
    }
}
