package com.silion.lockpatterndemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements LockPatternView.OnPatternChangeListener {
    private LockPatternView mLockPatternView;
    private TextView mTitilTextView;
    private Button mSavePwButton;

    private SharedPreferences mPreferences;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLockPatternView = (LockPatternView) findViewById(R.id.lockPatternView);
        mLockPatternView.setOnPatternChangeListener(this);
        mTitilTextView = (TextView) findViewById(R.id.title);
        mSavePwButton = (Button) findViewById(R.id.savePassword);
        mSavePwButton.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        mPreferences = getSharedPreferences("lockPatternDemo",MODE_PRIVATE);
        mPassword = mPreferences.getString("password", null);
        if (mPassword == null || mPassword.length() < 4) {
            mTitilTextView.setText(getResources().getString(R.string.new_password));
        } else {
            mTitilTextView.setText(getResources().getString(R.string.input_password));
        }
        super.onResume();
    }

    @Override
    public void onPatternChange(final String pattern) {
        if (mPassword == null || mPassword.length() < 4) {
            if (pattern == null) {
                Toast.makeText(this, getString(R.string.password_too_short), Toast.LENGTH_SHORT).show();
            } else {
                mSavePwButton.setVisibility(View.VISIBLE);
                mSavePwButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPreferences.edit().putString("password", pattern).commit();
                        finish();
                        //TODO start another activity or fragment;
                    }
                });
            }
        } else {
            if (mPassword.equals(pattern)) {
                //TODO start another activity or fragment;
                finish();
            } else {
                Toast.makeText(this, getString(R.string.password_error), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
