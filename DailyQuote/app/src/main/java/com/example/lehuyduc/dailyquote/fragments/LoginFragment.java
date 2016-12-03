package com.example.lehuyduc.dailyquote.fragments;


import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lehuyduc.dailyquote.FragmentEvent;
import com.example.lehuyduc.dailyquote.R;
import com.example.lehuyduc.dailyquote.managers.Preferences;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.bt_save)
    Button btSave;

    @BindView(R.id.et_username)
    EditText etUsername;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.bt_save)
    public void onSaveClick(View view) {
        String username = etUsername.getText().toString();

        Preferences.getInstance().putUserName(username);

        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(),
                false
        ));

        Log.d("LoginFragment", "Posted");
    }
}
