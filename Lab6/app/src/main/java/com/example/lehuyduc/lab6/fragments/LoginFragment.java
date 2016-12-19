package com.example.lehuyduc.lab6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lehuyduc.lab6.R;
import com.example.lehuyduc.lab6.eventbus_events.ToastEvent;
import com.example.lehuyduc.lab6.models.User;
import com.example.lehuyduc.lab6.networking.RetrofitContext;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.toString();
    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.bt_register)
    Button btRegister;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Subscribe
    public void onEvent(ToastEvent toastEvent) {
        Log.d(TAG, "onEvent " + toastEvent.getContent());
        Toast.makeText(this.getContext(), toastEvent.getContent(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_login)
    public void onLoginClick(View view) {
        Log.d(TAG, "onLoginClick");
        User user = new User(etUsername.getText().toString(), etPassword.getText().toString());
        RetrofitContext.login(user);
    }

    @OnClick(R.id.bt_register)
    public void onRegisterClick(View view) {
        Log.d(TAG, "onRegisterClick");
        User user = new User(etUsername.getText().toString(), etPassword.getText().toString());
        RetrofitContext.register(user);
    }
}
