package com.summerschool.learningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    RecyclerView eventList;
    Button addEventBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        addEventBtn = findViewById(R.id.add_event_button);

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventListActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });


        String messageFromPreviousActivity =
                getIntent().getStringExtra("ActvityType");
        Toast.makeText(this, messageFromPreviousActivity, Toast.LENGTH_SHORT).show();


        ArrayList<Event> events = new ArrayList<Event>();

        events.add(new Event("title 1", "bicicleta", 2));
        events.add(new Event("title 2", "bicicleta", 2));
        events.add(new Event("title 3", "bicicleta", 2));
        events.add(new Event("title 4", "bicicleta", 2));
        events.add(new Event("title 5", "bicicleta", 2));
        events.add(new Event("title 6", "bicicleta", 2));
        events.add(new Event("title 7", "bicicleta", 2));

        String newEventTitle = getIntent().getStringExtra("title_key");
        String newEventType = getIntent().getStringExtra("type_key");
        int newEventnumber = getIntent().getIntExtra("type_key", 0);

        if(newEventTitle!= null && newEventType!= null) {
            Event newEvent = new Event(newEventTitle, newEventType,newEventnumber );

            events.add(newEvent);
        }


        eventList = findViewById(R.id.event_list);

        eventList.setLayoutManager(new LinearLayoutManager(this));
        eventList.setHasFixedSize(true);
        eventList.setAdapter(new EventAdapter(events));

    }
}
