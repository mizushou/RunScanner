package com.example.shouhei.runscanner.runresult;

import android.support.v4.app.Fragment;
import android.util.Log;
import com.example.shouhei.runscanner.SingleFragmentActivity;

public class RunResultActivity extends SingleFragmentActivity {

    private static final String TAG = "RunResultActivity";

    @Override
    protected Fragment createFragment() {
        return new RunsResultFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
