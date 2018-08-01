package com.animusdevs.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view) ListView mSimpleListView;

    private List<String> mListArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding view with butter knife
        ButterKnife.bind(this);

        //Preparing dummy data
        mListArray=new ArrayList<>();
        prepareDataForListView();

        //Setup array adapter
        ArrayAdapter<String> mDataAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mListArray);
        mSimpleListView.setAdapter(mDataAdapter);


        //Setup an on click listener for list items
        mSimpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPosition, long id) {
                showToast(adapterView.getItemAtPosition(itemPosition).toString());
            }
        });


    }


    private void showToast(String itemData){
        Toast.makeText(MainActivity.this,itemData + " Clicked.",Toast.LENGTH_SHORT).show();

    }


    private void prepareDataForListView(){
        for(int i=0;i<100;i++){
            mListArray.add("List Item "+i);
        }
    }
}
