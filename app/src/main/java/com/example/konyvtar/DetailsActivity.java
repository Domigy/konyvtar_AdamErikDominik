package com.example.konyvtar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detials);


        TextView textViewTitle = findViewById(R.id.tvDetailTitle);
        TextView tvDetailAuthor = findViewById(R.id.tvDetailAuthor);
        TextView tvDetailPage = findViewById(R.id.tvDetailPage);
        TextView tvDetailYear = findViewById(R.id.tvDetailYear);

        Button btnBack = findViewById(R.id.btnBack);
        Random r = new Random();

        String title = getIntent().getStringExtra("Title");
        String author = getIntent().getStringExtra("Author");
        int year = getIntent().getIntExtra("Year", r.nextInt());

        int page = getIntent().getIntExtra("Page", 0);

        textViewTitle.setText(title);
        tvDetailAuthor.setText(author);
        tvDetailYear.setText("Year: "+ year);
        tvDetailPage.setText("Page: " + page);

        btnBack.setOnClickListener(v -> finish());
    }
}
