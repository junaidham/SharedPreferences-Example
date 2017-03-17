package com.example.junaid.sharedpreferences;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SharedPreferences extends AppCompatActivity implements View.OnClickListener {

    private EditText passName;
    private Button btnSave;
    private Button btnClear;
    private Button btnRetrived;

    // use SharedPreferences
    android.content.SharedPreferences sf;
    public  static  final String preference= "pref";
    public  static  final String saveIt= "saveKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        //find id
         btnSave = (Button) findViewById(R.id.button1Shared1);
         btnClear = (Button) findViewById(R.id.button2Shared1);
         btnRetrived = (Button) findViewById(R.id.button3Shared1);
         passName = (EditText) findViewById(R.id.editShared1);
        //
        sf = getSharedPreferences(preference, Context.MODE_PRIVATE);

        if (sf.contains(saveIt)){
            passName.setText(sf.getString(saveIt, " "));
        }

        // set click Listener
        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnRetrived.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button1Shared1:
                String store = passName.getText().toString();
                android.content.SharedPreferences.Editor editor = sf.edit();  //edit value in SharedPreferences
                editor.putString(saveIt,store);
                editor.commit();   // conform to save
                break;

            case R.id.button2Shared1:
                passName = (EditText) findViewById(R.id.editShared1);
                passName.setText("");
                break;

            case R.id.button3Shared1:
               // passName = (EditText) findViewById(R.id.editShared1);
                sf = getSharedPreferences(preference, Context.MODE_PRIVATE);
                if (sf.contains(saveIt)){
                    passName.setText(sf.getString(saveIt, " "));
                }



        }

    }
}
