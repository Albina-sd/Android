package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String TEXT_KEY = "TEXT_KEY";

    private TextView mTextView;
    private Button mButton;


    private View.OnClickListener OnSearchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent startProfileIntent =
                    new Intent(SecondActivity.this, BrowserActivity.class);
            Bundle bundle = getIntent().getExtras();
            String str = bundle.getString(TEXT_KEY);
            startProfileIntent.putExtra(BrowserActivity.WEB_KEY, str);
            startActivity(startProfileIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mButton = findViewById(R.id.bSecondActivity);
        mTextView = findViewById(R.id.tvTextFromMain);

        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT_KEY));

        mButton.setOnClickListener(OnSearchButtonClickListener);
    }


}