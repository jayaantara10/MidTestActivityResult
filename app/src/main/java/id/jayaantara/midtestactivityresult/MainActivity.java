package id.jayaantara.midtestactivityresult;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Inisialisasi Variabel
    Button btn_get_image;
    ImageView imgv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Penetapan variabel
        btn_get_image = (Button) findViewById(R.id.btn_get_image);
        imgv_image = (ImageView) findViewById(R.id.imgv_image);

        // Inisialisai Activity Result Launcher
        ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        //Pengkondisian untuk mengecek apakah data tidak kosong
                        if (result != null) {
                            //set data image view
                            imgv_image.setImageURI(result);
                        }
                    }
                }
        );

        btn_get_image.setOnClickListener(v -> resultLauncher.launch("image/*"));
    }
}