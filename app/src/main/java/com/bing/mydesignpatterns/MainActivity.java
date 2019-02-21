package com.bing.mydesignpatterns;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bing.mydesignpatterns.builder.Builder;
import com.bing.mydesignpatterns.builder.Computer;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageLoader imageLoader;

//    private String url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=65183942,997310997&fm=26&gp=0.jpg";
    private String url = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1652054578,1031905773&fm=26&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            String[] pers = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if(checkSelfPermission(pers[0]) == PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(pers[1]) == PackageManager.PERMISSION_DENIED){
                requestPermissions(pers,200);
            }
        }


        imageView = findViewById(R.id.image1);
        imageLoader = ImageLoader.getInstance();
        imageLoader.setImageCache(new DiskCache());
    }

    public void displayImage(View view) {

//        imageLoader.displayImage(url,imageView);

        Computer computer = new Computer();
        Builder builder = new Builder().setmBoard("我是主板");
        computer.setBuilder(builder);
        Log.e("displayImage", "displayImage: "+computer.toString());

    }
}
