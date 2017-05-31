package com.example.stephen.myrestaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import com.example.stephen.myrestaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.MyRestaurantsTextView) TextView myRestaurantsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface PacificoFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        myRestaurantsTextView.setTypeface(PacificoFont);

        mFindRestaurantsButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
//            Log.d("MainActivity", location);
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
