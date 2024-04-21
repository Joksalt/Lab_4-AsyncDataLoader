package com.example.lab4_asyncdataloader.utilities;

import android.os.AsyncTask;

import java.io.IOException;

public class AsyncDataLoader extends AsyncTask<String, Void, String> {
    protected String doInBackground(String... params){
        try{
            return ApiDataReader.getValuesFromApi();
        } catch (IOException e) {
            return String.format("Some error occurred => %s", e.getMessage());
        }
    }

    @Override
    public void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}
