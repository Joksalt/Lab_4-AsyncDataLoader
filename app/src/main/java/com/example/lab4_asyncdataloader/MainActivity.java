package com.example.lab4_asyncdataloader;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4_asyncdataloader.utilities.AsyncDataLoader;
import com.example.lab4_asyncdataloader.utilities.Constants;

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
        this.tvOutput.setText(getText(R.string.loading_data));
        getDataByAsyncTask();
    }

    public void getDataByAsyncTask(){
        new AsyncDataLoader() {
            @Override
            public void onPostExecute(String result) {
                tvOutput.setText(getString(R.string.data_loaded) + result);
            }
            }.execute(Constants.ECBEUROPA_API_URL);
    }
}