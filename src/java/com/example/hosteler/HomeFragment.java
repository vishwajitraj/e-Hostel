package com.example.hosteler;

import static com.example.hosteler.DBqueries.bestPickedModelArrayList;
import static com.example.hosteler.DBqueries.loadCategories;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hosteler.Adapter.BestPickedAdapter;
import com.example.hosteler.Adapter.CategoryAdapter;
import com.example.hosteler.Adapter.ItemListAdapter;
import com.example.hosteler.Adapter.PlaceAdapter;
import com.example.hosteler.Model.BestPickedModel;
import com.example.hosteler.Model.CategoryModel;
import com.example.hosteler.Model.ItemListModel;
import com.example.hosteler.Model.PlaceModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    // for categoryAdapter & categoryModel
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    // End for categoryAdapter & categoryModel

    // for placeAdapter & placeModel
    private RecyclerView placeRecyclerView;
    private PlaceAdapter placeAdapter;
    // End for placeAdapter & placeModel

    // For BestPickedAdapter & BestPickedModel
    private BestPickedAdapter bestPickedAdapter;
    private RecyclerView bestPickedRecyclerView;
    // End For BestPickedAdapter & BestPickedModel

    private ItemListAdapter itemListAdapter;
    private RecyclerView itemListRecyclerView;
    private List<PlaceModel> placeModelList;
    private List<ItemListModel> nearbyArrayList;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

// For CategoryAdapter & CategoryModel
        categoryRecyclerView = view.findViewById(R.id.product_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(R.drawable.icon_home,"Home"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_hosteler,"1 Seater Hostel"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_single_seater,"2 Seater Hostel"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_triple_seater,"3 Seater Hostel"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_triple_seater,"4 Seater Hostel"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_single_seater,"1 Seater PG"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_double_seater,"2 seater PG"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_room,"Rooms"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_house,"House"));


        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
// End for CategoryAdapter & CategoryMethod

// For PlaceAdapter & PlaceMethod
        placeRecyclerView = view.findViewById(R.id.place_recycler_view);
        LinearLayoutManager layoutManagerForPlace = new LinearLayoutManager(getActivity());
        layoutManagerForPlace.setOrientation(LinearLayoutManager.HORIZONTAL);
        placeRecyclerView.setLayoutManager(layoutManagerForPlace);

        placeModelList = new ArrayList<PlaceModel>();
        placeAdapter = new PlaceAdapter(placeModelList);
        placeRecyclerView.setAdapter(placeAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("LOCATION_IMAGE").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                placeModelList.add(new PlaceModel(documentSnapshot.get("imageLink").toString() ,documentSnapshot.get("locationName").toString()));
                            }
                            placeAdapter.notifyDataSetChanged();
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });


// End for placeAdapter & placeModel


// For BestPickedAdapter & BestPickedModel
        bestPickedRecyclerView = view.findViewById(R.id.bestpicked_product_list_recycler_view);
        LinearLayoutManager layoutManagerForBestPicked = new LinearLayoutManager(getActivity());
        layoutManagerForBestPicked.setOrientation(LinearLayoutManager.HORIZONTAL);
        bestPickedRecyclerView.setLayoutManager(layoutManagerForBestPicked);

        bestPickedAdapter = new BestPickedAdapter(bestPickedModelArrayList);
        bestPickedRecyclerView.setAdapter(bestPickedAdapter);
        if(bestPickedModelArrayList.size() == 0){
            loadCategories(bestPickedAdapter,getContext());
        }else{
            bestPickedAdapter.notifyDataSetChanged();
        }

// End For BestPickedAdapter & BestPickedModel

        itemListRecyclerView = view.findViewById(R.id.grid_item_layout_show);
        //Grid View Item List
        nearbyArrayList = new ArrayList<>();
        itemListAdapter = new ItemListAdapter(nearbyArrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        itemListRecyclerView.setLayoutManager(gridLayoutManager);
        itemListRecyclerView.setAdapter(itemListAdapter);

//        firebaseFirestore.collection("BEST_PICK_HOSTEL").orderBy("index").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful()){
//                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
//                                nearbyArrayList.add(new ItemListModel(documentSnapshot.get("imageLink").toString(),documentSnapshot.get("name").toString(),documentSnapshot.get("location").toString(),
//                                        documentSnapshot.get("currentPrice").toString(),documentSnapshot.get("totalPrice").toString(),
//                                        documentSnapshot.get("discount").toString(),documentSnapshot.get("rating").toString(),documentSnapshot.get("totalRating").toString()));
//                            }
//                            itemListAdapter.notifyDataSetChanged();
//                        }else{
//                            String error = task.getException().getMessage();
//                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        firebaseFirestore.collection("Categories").document(
                        "Home").collection("nearbyHostel").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                long numberOfHostel = (long)documentSnapshot.get("numberOfHostel");
                                for(long x = 1; x < numberOfHostel + 1; x++){
                                    nearbyArrayList.add(new ItemListModel(
                                            documentSnapshot.get("imageLink"+x).toString(),
                                            documentSnapshot.get("name"+x).toString(),
                                            documentSnapshot.get("location"+x).toString(),
                                            "₹"+documentSnapshot.get("currentPrice"+x).toString(),
                                            "₹"+documentSnapshot.get("totalPrice"+x).toString(),
                                            documentSnapshot.get("discount"+x).toString()+" OFF",
                                            documentSnapshot.get("ratingPoint"+x).toString(),
                                            "("+documentSnapshot.get("totalRating"+x).toString()+")"));
                                }
                            }
                            itemListAdapter.notifyDataSetChanged();
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // End Grid

        return view;
    }
}