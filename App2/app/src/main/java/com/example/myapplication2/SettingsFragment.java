package com.example.myapplication2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import android.app.Fragment;

public class SettingsFragment extends Fragment {
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    public static final String PREF = "google";
    private SharedPreferences sharedPrefs;

    private RadioGroup radioGroup;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    // метод для сохранения текста в файл настроек
    public void saveText(String str, Context context) {
        sharedPrefs = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        // получаем доступ к файлу
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_RADIOBUTTON_INDEX, str);
        editor.commit();
    }

    // метод для получения текста из SharedPreferences по ключу
    public String getText(Context context) {
        sharedPrefs = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sharedPrefs.getString(KEY_RADIOBUTTON_INDEX, "");
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_settings, container, false);


        radioGroup = view.findViewById(R.id.rb_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_google:
                        //showMessage(R.string.google);
                        saveText("http://www.google.com/search?q=", getActivity());
                        break;
                    case R.id.rb_yandex:
                        //showMessage(R.string.yandex);
                        saveText("https://yandex.ru/search/?text=", getActivity());
                        break;
                    case R.id.rb_bing:
                        //showMessage(R.string.bing);
                        saveText("http://www.bing.com/search?q=", getActivity());
                        break;

                    default:
                        break;
                }
            }
        });

        return view;
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
}
