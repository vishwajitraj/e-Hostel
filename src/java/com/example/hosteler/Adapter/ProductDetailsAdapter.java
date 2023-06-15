package com.example.hosteler.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hosteler.ProductDescriptionFragment;
import com.example.hosteler.ProductRulesRegulationFragment;
import com.example.hosteler.ProductFacilityFragment;

public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTab;

    public ProductDetailsAdapter(FragmentManager fm, int totalTab) {
        super(fm);
        this.totalTab = totalTab;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProductFacilityFragment productFacilityFragment = new ProductFacilityFragment();
                return productFacilityFragment;
            case 1:
                ProductRulesRegulationFragment productRulesRegulationFragment = new ProductRulesRegulationFragment();
                return productRulesRegulationFragment;
            case 2:
                ProductDescriptionFragment productDescriptionFragment3 = new ProductDescriptionFragment();
                return productDescriptionFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTab;
    }
}
