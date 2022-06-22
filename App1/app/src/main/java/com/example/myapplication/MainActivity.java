package com.example.myapplication;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mCheckText;
    private Button mCheckButton;

    private View.OnClickListener OnCheckButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isNotEmpty()){
                Intent startProfileIntent =
                        new Intent(MainActivity.this, SecondActivity.class);
                startProfileIntent.putExtra(SecondActivity.TEXT_KEY, mCheckText.getText().toString());
                startActivity(startProfileIntent);

                // тост
                showMessage(mCheckText.getText().toString());
            }
        }
    };

    private boolean isNotEmpty(){
        return !TextUtils.isEmpty(mCheckText.getText());
    }

    private void showMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckText = findViewById(R.id.etText);
        mCheckButton = findViewById(R.id.bCheckText);

        mCheckButton.setOnClickListener(OnCheckButtonClickListener);
    }
}