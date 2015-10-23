package com.silion.lockpatterndemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements LockPatternView.OnPatternChangeListener {
    private LockPatternView mLockPatternView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLockPatternView = (LockPatternView) findViewById(R.id.lockPatternView);
        mLockPatternView.setOnPatternChangeListener(this);
    }

    @Override
    public void onPatternChange(String pattern) {
        if (pattern == null) {
            Toast.makeText(this, "password error", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "password is : " + pattern, Toast.LENGTH_LONG).show();
        }
    }
}
