package com.example.moviestonight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                String movies= OMDBWebServiceClient.searchMovieByTitle("Batman Begins", "2e2a2e53");
                textView.setText(movies);
                Toast.makeText(getApplicationContext(),"mmmm:"+movies,Toast.LENGTH_SHORT).show();
            }
        });
    }
}