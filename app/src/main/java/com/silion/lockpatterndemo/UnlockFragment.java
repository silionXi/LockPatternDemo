package com.silion.lockpatterndemo;


import android.app.ActionBar;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnlockFragment extends FragmentBase {


    public UnlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mTitle = UnlockFragment.class.getSimpleName();
        return inflater.inflate(R.layout.fragment_unlock, container, false);
    }

    @Override
    public void updataActionBar() {
        ActionBar actionBar = mMainActivity.getActionBar();
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
        super.updataActionBar();
    }
}
