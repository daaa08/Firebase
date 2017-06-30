package com.example.da08.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef, myRef2;

    TextView textView, textView2;
    EditText editText, editText2;
    Button btnPost, btnPost2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        btnPost = (Button)findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                myRef.setValue(text);
            }
        });

        textView2 = (TextView)findViewById(R.id.textView2);
        editText2 = (EditText)findViewById(R.id.editText2);
        btnPost2 = (Button)findViewById(R.id.btnPost2);
        btnPost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = editText2.getText().toString();
                myRef2.setValue(text2);
            }
        });


        myRef = database.getReference("message2");
        myRef.setValue("Hello, World!");

        myRef2 = database.getReference("message3");
        myRef2.setValue("Hello, World!");

        initData();
        initData2();
    }

    private void initData(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                textView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void initData2(){
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                textView2.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
