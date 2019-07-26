package com.summerschool.learningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    RecyclerView eventList;
    FloatingActionButton addEventBtn;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<Event> events;
    EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        events = new ArrayList<Event>();
        adapter = new EventAdapter(events);

        addEventBtn = findViewById(R.id.add_event_button);

       addEventBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(EventListActivity.this, AddEventActivity.class);
                startActivity(intent);
       }
       });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Alex_Bratu");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Event event = postSnapshot.getValue(Event.class);
                    events.add(event);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
        eventList.setAdapter(adapter);

    }
}
