package com.example.roomofmemory;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PhotoOrDiary extends AppCompatActivity {

    ImageButton addPhotoVideo;
    ImageButton addDiary;
    TextView txt_date;
    String date;

    Uri uri;
    ImageView imageView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.tool_home:
                Intent intent = new Intent(PhotoOrDiary.this, RoomsActivity.class);
                intent.putExtra("flag",1);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_or_diary);

        Intent intent = getIntent();
        date = intent.getStringExtra("date");

        addPhotoVideo = (ImageButton)findViewById(R.id.addPhotoVideo);
        addDiary = (ImageButton) findViewById(R.id.addDiary);

        imageView = (ImageView)findViewById(R.id.galleryImgView);

        txt_date = findViewById(R.id.textView6);
        txt_date.setText(date);

        // Toolbar를 액티비티의 App Bar로 지정
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

//        ActionBar ab = getSupportActionBar();
//        ab.setTitle("Message");

        addPhotoVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectPhoto.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        addDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteDiary.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

    }

}