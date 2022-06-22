package com.example.myapplication2;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchFragment extends Fragment {
    private TextView mTextView;
    private Button mButton;


    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private View.OnClickListener OnSearchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                SettingsFragment sf = new SettingsFragment();
                String brow = sf.getText(getActivity());
                String request = URLEncoder.encode(mTextView.getText().toString(), "UTF-8");
                Uri uri = Uri.parse(brow + request);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } catch (UnsupportedEncodingException e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_search, container, false);

        mButton = view.findViewById(R.id.b_search);
        mTextView = view.findViewById(R.id.et_search);

        mButton.setOnClickListener(OnSearchButtonClickListener);

        return view;
    }

}
