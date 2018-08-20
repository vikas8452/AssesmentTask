package com.vikas.assesmenttask;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SearchView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Bill_list extends AppCompatActivity {

    GridView gridView;
    DatabaseReference databaseReference;
    private ArrayList<Bill_Detail> bill_details= new ArrayList<>();
    private AdapterOfBillList adapter;
    private SearchView ssv;
    private String searchstring="";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Orders");

        gridView = findViewById(R.id.gridvf);
        ssv = findViewById(R.id.vsearch);

        databaseReference = FirebaseDatabase.getInstance().getReference("Bills");
        databaseReference.keepSynced(true);

        adapter=new AdapterOfBillList(Bill_list.this,retrieve(databaseReference));
        gridView.setAdapter(adapter);

        ssv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchstring = newText.toUpperCase();
                gridView.invalidate();
                bill_details.clear();
                adapter = null;
                adapter=new AdapterOfBillList(Bill_list.this,retrieve(databaseReference));
                gridView.setAdapter(adapter);
                return false;
            }
        });

    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        //for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Log.d("ds","Hell");
            try {
                Bill_Detail spacecraft = dataSnapshot.getValue(Bill_Detail.class);
                Log.d("sds","Hellooo");
                assert spacecraft != null;
                if(spacecraft.getBillno().contains(searchstring))
                    bill_details.add(spacecraft);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Log.d("ds_exception",e+"");
            }
        }
    }

    private List<Bill_Detail> retrieve(DatabaseReference db) {

        Log.d("sdsd","Entered in the listener");

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("sdsd","Calling Fetch data");
              //  bill_details.clear();
                fetchData(dataSnapshot);
                adapter.notifyDataSetChanged();
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                bill_details.clear();
                gridView.invalidateViews();
                //fetchData(dataSnapshot);
                adapter=new AdapterOfBillList(Bill_list.this,retrieve(databaseReference));
                gridView.setAdapter(adapter);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return  bill_details;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }
}
