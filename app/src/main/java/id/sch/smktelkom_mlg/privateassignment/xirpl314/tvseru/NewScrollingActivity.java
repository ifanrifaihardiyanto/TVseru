package id.sch.smktelkom_mlg.privateassignment.xirpl314.tvseru;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewScrollingActivity extends AppCompatActivity {
    public String url = "https://image.tmdb.org/t/p/w500";
    String id,img,desc,gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        id = intent.getStringExtra("movie_title");
        img = intent.getStringExtra("poster_path");
        desc = intent.getStringExtra("description");
        setTitle(id);
        gambar = url+img;
        ImageView detail = (ImageView) findViewById(R.id.imageViewDetail);
        TextView description = (TextView) findViewById(R.id.textViewDescription);
        Glide.with(this).load(gambar)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(detail);
        description.setText(desc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
