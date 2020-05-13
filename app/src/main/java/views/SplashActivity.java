package views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.IntroScreen;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //menjalankan splash activity dalam beberapa detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // yang terjadi
                Intent intent = new Intent(SplashActivity.this, IntroScreen.class);
                startActivity(intent);
                finish();


            }
        }, 3000);




    }
}
