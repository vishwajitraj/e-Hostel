package com.example.hosteler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hosteler.Adapter.WishlistAdapter;
import com.example.hosteler.Model.WishlistModel;

import java.util.ArrayList;
import java.util.List;


public class MyWishListFragment extends Fragment {


    public MyWishListFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wish_list, container, false);
        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image_kcc,"KCC Hostel",1,"3",146,"Rs.9999/-","Rs.20000/-","All method available"));
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image,"RPH Hostel",2,"4",440,"Rs.8999/-","Rs.20000/-","All method available"));
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image_kcc,"BND Hostel",1,"3",320,"Rs.10099/-","Rs.20000/-","All method available"));
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image,"ABC Hostel",3,"5",260,"Rs.19999/-","Rs.20000/-","All method available"));
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image_kcc,"XYZ Hostel",1,"2",320,"Rs.7999/-","Rs.20000/-","All method available"));
        wishlistModelList.add(new WishlistModel(R.mipmap.hostel_image,"Apna Hostel",5,"5",880,"Rs.6999/-","Rs.20000/-","All method available"));
        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;

    }
}