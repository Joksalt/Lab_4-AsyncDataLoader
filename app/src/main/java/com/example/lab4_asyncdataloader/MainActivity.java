package com.example.lab4_asyncdataloader;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvOutput;
    private Button btnLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvOutput = findViewById(R.id.tvOutput);
        this.btnLoadData = findViewById(R.id.btnLoadData);

        btnLoadData.setOnClickListener(v -> btnClickLoadData());
    }

    private void btnClickLoadData(){
        tvOutput.setText("hello world");
    }
}