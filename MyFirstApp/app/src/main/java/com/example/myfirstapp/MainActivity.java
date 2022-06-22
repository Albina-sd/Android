package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.LauncherActivity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnClick;
    private TextView mText;
    public static final int GROUP_ID = Menu.NONE;
    public static final int MENU_ITEM_ID = 42;
    public static final int ORDER = Menu.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String newString = getString(R.string.new_text); // final т.к. исп. callback

        // проверка версии т.к. getColor(R.color.red) для API выше 23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getColor(R.color.red);
        }

        // метод из библиотеки поддержки
        // используем this т.к. класс Activity является потомком Context
        ContextCompat.getColor(this, R.color.red);

        // для работы с элементами из xml разметки
        mBtnClick = findViewById(R.id.btn_click);
        mText = findViewById(R.id.tv_text);

        // для определения нажатия метод onClick - callback
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(newString);
            }
        });

        // Bundle - обертка над массивом данных исп. для передачи, сохраниения и считывания данных
        // так же для передачи в другое активити после сериализации
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "SAD");

        // добавление контекстного меню
        registerForContextMenu(mText); // включение контекстного меню (в onResume())
        unregisterForContextMenu(mText); // выключение контекстного меню (в onPause())
    }

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                // вывод сообщения
                Toast.makeText(MainActivity.this, "Settings clicked",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.search:
                // вывод сообщения
                Toast.makeText(MainActivity.this, "Search clicked",
                        Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // редактирование в runtime
    /*
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        if (!isUserAuthorized()){
            menu.removeItem(R.id.logout);
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }
    */

    // контекстное меню
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v, ContextMenu.ContextMenuInfo menuInfo){
        if(v.getId() == R.id.tv_text) {
            menu.add(GROUP_ID, MENU_ITEM_ID, ORDER, "Context menu");
        }else {
            super.onCreateContextMenu(menu,v,menuInfo);
        }
    }

}