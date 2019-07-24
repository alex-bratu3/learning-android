package com.summerschool.learningandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;
    public EventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_layout, viewGroup, false);

        EventViewHolder eventViewHolder = new EventViewHolder(listItem);

        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int position) {
        eventViewHolder.title.setText(eventList.get(position).title);
        eventViewHolder.type.setText(eventList.get(position).type);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{

        TextView title, type;

        public EventViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            type = itemView.findViewById(R.id.item_count_people);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentToDetailview = new Intent(title.getContext(),
                            DetailViewActivity.class);
                    intentToDetailview.putExtra("Title", title.getText().toString());
                    title.getContext().startActivity(intentToDetailview);
                }
            });

        }
    }
}
