package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.Repo.Repo;

import java.io.InputStream;

import javax.annotation.Nullable;

public class NewItemActivity extends AppCompatActivity {

    private Bitmap currentBitmap;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView = findViewById(R.id.newItemImageView);

        setContentView(R.layout.activity_new_item_view);
    }

    public void save(View view){
        EditText titleEdit = findViewById(R.id.newTodoTitle);
        EditText textEdit = findViewById(R.id.newTodoText);

        Repo.r().addItem(new ToDoItem(titleEdit.getText().toString(), textEdit.getText().toString()), currentBitmap);
        finish();
    }

    public void galleryBtnPressed(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    public void cameraBtnPressen(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageView = findViewById(R.id.newItemImageView);
        if(requestCode == 1){
            backFromGallery(data);
        }
        if(requestCode == 2){
            backFromCamera(data);
        }
    }

    private void backFromGallery(@Nullable Intent data){
        assert data != null;
        Uri imageUri = data.getData();
        try {
            InputStream is = getContentResolver().openInputStream(imageUri);
            currentBitmap = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(currentBitmap);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void backFromCamera(@Nullable Intent data){
        try {
            assert data != null;
            System.out.println("here!");
            currentBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(currentBitmap);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}