package com.example.hosteler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private ItemListAdapter itemListAdapter;
    private List<ItemListModel> itemList;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView = findViewById(R.id.product_recycler_view);

        //Grid View Item List
        itemList = new ArrayList<>();
        itemListAdapter = new ItemListAdapter(itemList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        categoryRecyclerView.setLayoutManager(gridLayoutManager);
        categoryRecyclerView.setAdapter(itemListAdapter);



        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("BEST_PICK_HOSTEL").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                itemList.add(new ItemListModel(documentSnapshot.get("imageLink").toString(),documentSnapshot.get("name").toString(),documentSnapshot.get("location").toString(),
                                        documentSnapshot.get("currentPrice").toString(),documentSnapshot.get("totalPrice").toString(),
                                        documentSnapshot.get("discount").toString(),documentSnapshot.get("rating").toString(),documentSnapshot.get("totalRating").toString()));

                            }
                            itemListAdapter.notifyDataSetChanged();
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(getBaseContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // End Grid
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.serch_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id ==R.id.main_search_icon) {
            //search
            return true;
        } else if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}