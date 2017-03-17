package com.example.junaid.sqlitedatabasedemoexample;
/**
 * Shared Preferences for toolbar color setting
 * how to use sharedpreference api to store and retrieve a color
 * that later will be used for coloring android toolbar and android statusbar.
 *see youtube
 * https://www.youtube.com/watch?v=SPVxVl7nkcc
 */

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SharedPreferenceColorChengeActivity extends AppCompatActivity implements View.OnClickListener {
    //
    private Toolbar toolbar;
    private Button btnRedcolor;
    private Button btnGreencolor;
    private Button btnYellowcolor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_color_chenge);

        // find id

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnRedcolor = (Button) findViewById(R.id.btnRedcolor);
        btnGreencolor = (Button) findViewById(R.id.btnGreencolor);
        btnYellowcolor = (Button) findViewById(R.id.btnYellowcolor);

        // set click listener
        btnRedcolor.setOnClickListener(this);
        btnGreencolor.setOnClickListener(this);
        btnYellowcolor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRedcolor:
                toolbar.setBackgroundColor(getResources().getColor(R.color.toolRed));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.toolRed));
                }
                storeColor(getResources().getColor(R.color.toolRed));
                break;

            case R.id.btnGreencolor:
                toolbar.setBackgroundColor(getResources().getColor(R.color.toolGreen));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.toolGreen));
                }
                storeColor(getResources().getColor(R.color.toolGreen));
                break;

            case R.id.btnYellowcolor:
                toolbar.setBackgroundColor(getResources().getColor(R.color.toolYellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.toolYellow));
                }
                storeColor(getResources().getColor(R.color.toolYellow));
                break;
        }
    }
    public void storeColor(int color){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();

    }

    public int getColor(){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        // for color selecting & define
        int selectColor = mSharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return selectColor;

    }
}
