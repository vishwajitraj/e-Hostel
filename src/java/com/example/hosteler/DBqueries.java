package com.example.hosteler;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.hosteler.Adapter.BestPickedAdapter;
import com.example.hosteler.Adapter.ItemListAdapter;
import com.example.hosteler.Model.BestPickedModel;
import com.example.hosteler.Model.ItemListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DBqueries {

    public static FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    public static List<BestPickedModel> bestPickedModelArrayList = new ArrayList<>();


    // For BestPickedAdapter & BestPickedModel
    public static void loadCategories(final BestPickedAdapter bestPickedAdapter, Context context){

        firebaseFirestore.collection("Categories").document(
                        "Home").collection("Bestpicked").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                long numberOfHostel = (long)documentSnapshot.get("numberOfHostel");
                                for(long x = 1; x < numberOfHostel + 1; x++){
                                    bestPickedModelArrayList.add(new BestPickedModel(
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
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(context,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    // End For BestPickedAdapter & BestPickedModel


}
