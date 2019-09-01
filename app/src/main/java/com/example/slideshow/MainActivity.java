package com.example.slideshow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher mImageSwitcher;

    int[] mImageResources = {
            R.drawable.slide00,
            R.drawable.slide01,
            R.drawable.slide02,
            R.drawable.slide03,
            R.drawable.slide04,
            R.drawable.slide05,
            R.drawable.slide06,
            R.drawable.slide07,
            R.drawable.slide08,
            R.drawable.slide09,
    };

    int mPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //イメージビュー生成工場
                ImageView imageView = new ImageView(MainActivity.this);
                return imageView;
            }
        });

        mImageSwitcher.setImageResource(R.drawable.slide00);

        Button prevButton = (Button) findViewById(R.id.prevButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition(-1);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition(1);
            }
        });

    }

    private void movePosition(int move){
        mPosition = mPosition + move;
        if(mPosition >= mImageResources.length){
            mPosition = 0;
        }else  if(mPosition < 0){
            mPosition = mImageResources.length - 1;
        }
        mImageSwitcher.setImageResource(mImageResources[mPosition]);

    }
}
