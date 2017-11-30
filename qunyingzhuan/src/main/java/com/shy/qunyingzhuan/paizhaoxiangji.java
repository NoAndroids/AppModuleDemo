package com.shy.qunyingzhuan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.text.BidiFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class paizhaoxiangji extends AppCompatActivity {
    private Uri imageuri;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paizhaoxiangji);
        iv= (ImageView) findViewById(R.id.iv);
        File outputimage=new File(getExternalCacheDir(),"xxximage.jpg");
        try {

            if (outputimage.exists()){
                outputimage.delete();
            }
            outputimage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT>=24){
            imageuri= FileProvider.getUriForFile(this,"com.shy.qunyingzhuan.paizhaoxiangji.provider",outputimage);

        }else {
            imageuri=Uri.fromFile(outputimage);
        }
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageuri);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            try {
                Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageuri));
                iv.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
