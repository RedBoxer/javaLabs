package com.JavaLabs.mobileimagesorter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import ImageSorter.*;

public class MainActivity extends AppCompatActivity {
    private ImageSorter imgSort = new ImageSorter();
    private ArrayList<Image> images = new ArrayList<>();
    private RecyclerView imageWall;
    private ImageAdapter imgAdapter;
    private Bitmap temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

    }

    public void onLoadClick(View view){
        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");
        startActivityForResult(gallery, 32);
    }

    private void initRecyclerView() {
        imageWall = findViewById(R.id.imageList);
        imageWall.setLayoutManager(new LinearLayoutManager(this));
        imgAdapter = new ImageAdapter();
        imageWall.setAdapter(imgAdapter);
    }

    private Runnable loadItems = new Runnable(){
        @Override
        public void run() {
            imgAdapter.clearItems();
            imgAdapter.setItems(images);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 32 && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            try {
                temp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                Thread loader = new Thread(loadImg);
                loader.start();
            }catch(Exception e){

            }
        }
    }

    Runnable loadImg = new Runnable() {
        @Override
        public void run() {
            images.add(new Image(temp));
            runOnUiThread(loadItems);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        imgSort.setImages(images);
        switch (id) {
            case R.id.avgRedSort:
                images = imgSort.sortByRed();
                loadItems.run();
                return true;
            case R.id.avgBlueSort:
                images = imgSort.sortByBlue();
                loadItems.run();
                return true;
            case R.id.avgGreenSort:
                images = imgSort.sortByGreen();
                loadItems.run();
                return true;
            case R.id.avgBrightnessSort:
                images = imgSort.sortByBrightness();
                loadItems.run();
                return true;
            case R.id.sizeSort:
                images = imgSort.sortBySize();
                loadItems.run();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
