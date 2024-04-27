package com.example.lab4_asyncdataloader;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4_asyncdataloader.utilities.AsyncDataLoader;
import com.example.lab4_asyncdataloader.utilities.Constants;

public class MainActivity extends AppCompatActivity {
    private TextView tvOutput;
    private Button btnLoadData;
    private ListView lvCurrencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvOutput = findViewById(R.id.tvOutput);
        this.btnLoadData = findViewById(R.id.btnLoadData);
        this.lvCurrencyList = findViewById(R.id.lvCurrencyList);

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

                populateListViewWithResult(result);

                tvOutput.setText(getString(R.string.data_loaded) + result);
            }
            }.execute(Constants.ECBEUROPA_API_URL);
    }

    private void populateListViewWithResult(String result){
        String[] lines = result.split(System.lineSeparator());

        ArrayAdapter<String> currencyListAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                lines
        );

        MainActivity.this.lvCurrencyList.setAdapter(currencyListAdapter);
    }
}