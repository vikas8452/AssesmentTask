package com.vikas.assesmenttask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

       Bill_Detail bill_detail = new Bill_Detail("25380", "Maid","Aaamir ","Fri","May","2017","10:45 AM","12","Office","Fan Light & Switch Repair","Pending","Bagh No3 Azad Nagar Kanpur Road Lucknow 226023, 226023, India","Job not yet assigned","Rs.5-Rs.20 per hour","10","0","0"," "," "," ");
       FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference().child("Bills").child("bill25380");
        databaseReference.setValue(bill_detail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Bill_list.class));

            }
        });
    }
}
