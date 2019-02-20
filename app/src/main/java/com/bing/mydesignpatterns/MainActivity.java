package com.bing.mydesignpatterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageLoader imageLoader;

//    private String url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=65183942,997310997&fm=26&gp=0.jpg";
    private String url = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1652054578,1031905773&fm=26&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image1);
        imageLoader = new ImageLoader();
        imageLoader.setImageCache(new DiskCache());
    }

    public void displayImage(View view) {


        imageLoader.displayImage(url,imageView);

    }
}
