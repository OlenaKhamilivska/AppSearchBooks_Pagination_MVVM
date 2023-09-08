package com.example.paginationexamplejavacorrect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paginationexamplejavacorrect.R;

public class MainActivity extends AppCompatActivity {

    private Button openAppBtn;
    private EditText search_ET;

    public static final String search_tag = "searchTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openAppBtn = findViewById(R.id.openAppBtn);
        search_ET = findViewById(R.id.search_ET);


        openAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchStr = search_ET.getText().toString();
                if (searchStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Search box is empty", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BooksListActivity.class);
                    intent.putExtra(search_tag, searchStr);
                    startActivity(intent);
                }
            }
        });
    }
}