package com.summerschool.learningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEventActivity extends AppCompatActivity {

    EditText title, type, number;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        title = findViewById(R.id.add_event_title);
        type = findViewById(R.id.add_event_type);
        number = findViewById(R.id.number);

        addBtn = findViewById(R.id.add_event_button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleValue = title.getText().toString();
                String typeValue = type.getText().toString();
                int numberOfPeople = Integer.parseInt(number.getText().toString());

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Alex_Bratu");

                Event event = new Event(titleValue, typeValue, numberOfPeople);

                myRef.child(System.currentTimeMillis() + "").setValue(event);

                Intent intent = new Intent(AddEventActivity.this, EventListActivity.class);
//                intent.putExtra("title_key", titleValue);
//                intent.putExtra("type_key", typeValue);
//                intent.putExtra("number_key", numberOfPeople);

                startActivity(intent);
            }
        });
    }
}
