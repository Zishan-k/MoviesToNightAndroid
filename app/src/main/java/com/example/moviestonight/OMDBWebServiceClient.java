package com.example.moviestonight;

import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OMDBWebServiceClient {

    public static final String SEARCH_URL= "http://www.omdbapi.com/?s=TITLE&apikey=KEY";

    public static String searchMovieByTitle(String title, String key){
        String requestURL = SEARCH_URL.replaceAll("TITLE", title).replaceAll("KEY", key);
        return sendGetRequest(requestURL);
    }

    public static String sendGetRequest(String requestURL){
        StringBuilder response = new StringBuilder();
        try{
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json; charset = UTF-8" );

            connection.getResponseMessage();

            //read byte by byte
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //append line by line
            String line;
            while((line = bufferedReader.readLine()) != null){
                response.append(line);
            }
            bufferedReader.close();
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
