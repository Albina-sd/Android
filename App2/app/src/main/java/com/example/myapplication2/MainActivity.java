package com.example.myapplication2;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends SimpleFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SettingsFragment sf = new SettingsFragment();
        sf.getText(this);
    }

    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //действия с меню
        switch (item.getItemId()) {
            case R.id.actionSettings:
                showMessage(R.string.settings);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, SettingsFragment.newInstance())
                        .addToBackStack(SettingsFragment.class.getName())
                        .commit();

                break;
            case R.id.actionSearch:
                showMessage(R.string.search);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, SearchFragment.newInstance())
                        .hide(SettingsFragment.newInstance())
                        .addToBackStack(SettingsFragment.class.getName())
                        .commit();

                break;
            case R.id.actionExit:
                showMessage(R.string.exit);
                this.finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}