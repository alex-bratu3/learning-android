package com.summerschool.learningandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailViewActivity extends AppCompatActivity {

    TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        textViewTitle = findViewById(R.id.titleTv);

        String title = getIntent().getStringExtra("Title");
        textViewTitle.setText(title);


    }
}
