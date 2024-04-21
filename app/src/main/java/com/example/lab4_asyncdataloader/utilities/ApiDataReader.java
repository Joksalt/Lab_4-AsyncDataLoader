package com.example.lab4_asyncdataloader.utilities;

import static com.example.lab4_asyncdataloader.utilities.Constants.ECBEUROPA_API_URL;

import com.example.lab4_asyncdataloader.parsers.DataParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiDataReader {

    public static String getValuesFromApi() throws IOException {
        InputStream apiResponseStream = null;
        String result = "";

        try{
            apiResponseStream = downloadUrlContent(ECBEUROPA_API_URL);
            result = DataParser.getCurrencyRatesBaseUsd(apiResponseStream);
        }
        finally {
            if (apiResponseStream != null) {
                apiResponseStream.close();
            }
        }

        return result;
    }

    private static InputStream downloadUrlContent(String urlString) throws IOException{
        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();
        return connection.getInputStream();
    }
}
