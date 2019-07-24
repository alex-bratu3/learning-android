package com.summerschool.learningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                Intent intent = new Intent(AddEventActivity.this, EventListActivity.class);
                intent.putExtra("title_key", titleValue);
                intent.putExtra("type_key", typeValue);
                intent.putExtra("number_key", numberOfPeople);

                startActivity(intent);
            }
        });
    }
}
