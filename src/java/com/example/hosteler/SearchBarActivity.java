package com.example.hosteler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hosteler.Model.SearchItemModel;
import com.example.hosteler.Adapter.SearchItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchBarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchItemAdapter searchItemAdapter;
    private List<SearchItemModel> searchItemModelList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchItemModelList = new ArrayList<>();

        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));
        searchItemModelList.add(new SearchItemModel("KCC Hostel",R.mipmap.hostel_image_kcc));
        searchItemModelList.add(new SearchItemModel("BND Hostel",R.mipmap.hostel_image));

        searchItemAdapter = new SearchItemAdapter(searchItemModelList);
        recyclerView.setAdapter(searchItemAdapter);
    }

    private void filterList(String text) {
        List<SearchItemModel> filteredList = new ArrayList<>();
        for(SearchItemModel searchItemModel: searchItemModelList){
            if(searchItemModel.getItemName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(searchItemModel);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else {
            searchItemAdapter.setFilteredList(filteredList);
        }

    }
}