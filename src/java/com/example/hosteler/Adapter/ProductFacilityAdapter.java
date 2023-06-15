package com.example.hosteler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hosteler.Model.ProductFacilityModel;
import com.example.hosteler.R;

import java.util.List;

public class ProductFacilityAdapter extends RecyclerView.Adapter<ProductFacilityAdapter.ViewHolder> {

    private List<ProductFacilityModel> productFacilityModelList;

    public ProductFacilityAdapter(List<ProductFacilityModel> productFacilityModelList) {
        this.productFacilityModelList = productFacilityModelList;
    }

    @NonNull
    @Override
    public ProductFacilityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specfication_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFacilityAdapter.ViewHolder viewHolder, int position) {

        String featureNumber = productFacilityModelList.get(position).getFeatureNumber();
        String featureDetail = productFacilityModelList.get(position).getFeatureName();
        viewHolder.setFeatures(featureNumber,featureDetail);

    }

    @Override
    public int getItemCount() {
        return productFacilityModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView featureCount;
        private TextView featureName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureCount = itemView.findViewById(R.id.feature_serial_number);
            featureName = itemView.findViewById(R.id.feature_text);
        }
        private void setFeatures(String featureSerialNumber, String featureDetails){
            featureCount.setText(featureSerialNumber);
            featureName.setText(featureDetails);
        }
    }
}
