package com.example.presentation.ui.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

//import com.facebook.stetho.Stetho;
//import com.google.firebase.FirebaseApp;

import com.example.presentation.utils.ExceptionHandler;

import butterknife.ButterKnife;
//import pe.com.patadeperro.presentation.utils.ExceptionHandler;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Stetho.initializeWithDefaults(this);
//        FirebaseApp.initializeApp(this);
//        hideKeyboard(this);
//        getUnhandledExceptions();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    protected void hideKeyboard(Activity activity) {
        //   act.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void next(Class<?> activity) {
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);
    }

    protected void getUnhandledExceptions() {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this, BaseActivity.class));
    }

    protected void injectView() {
        ButterKnife.bind(this);
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    void askPermisions(Activity ctx) {

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };

        if (!hasPermissions(ctx, PERMISSIONS)) {
            ActivityCompat.requestPermissions(ctx, PERMISSIONS, PERMISSION_ALL);
        }
    }

}
