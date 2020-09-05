package com.kgw.moelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DETAIL = "extra_detail";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvGenre = findViewById(R.id.tv_genre);
        TextView tvRelease = findViewById(R.id.tv_release);
        TextView tvTitleSynopsis = findViewById(R.id.textSynopsis);
        TextView tvSynopsis = findViewById(R.id.tv_synopsis);
        ImageView imgPoster = findViewById(R.id.poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_DETAIL);

        assert movie != null;
        Toast.makeText(this,movie.getName(),Toast.LENGTH_SHORT).show();
        tvName.setText(movie.getName());
        tvGenre.setText(movie.getGenre());
        tvRelease.setText(getString(R.string.release_year) + " : " + movie.getReleaseYear());
        tvTitleSynopsis.setText(getString(R.string.synopsis));
        tvSynopsis.setText(movie.getSynopsis());
        imgPoster.setImageResource(movie.getPoster());

    }
}
