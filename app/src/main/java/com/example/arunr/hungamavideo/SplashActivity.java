package com.example.arunr.hungamavideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by arun.r on 07-03-2018.
 */

public class SplashActivity extends AppCompatActivity {

    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initializing shared preference
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean isClicked = prefs.getBoolean("isClicked", false);

        if (!isClicked) {
            showStartDialog();
        } else {
            final Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            }, 1500);
        }
    }

    private void showStartDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);

        View view = getLayoutInflater().inflate(R.layout.terms_and_conditions, null);

        ScrollView scrollView = view.findViewById(R.id.scrollView);
        final TextView tcDetails = view.findViewById(R.id.termsAndConditionsDetails);
        CheckBox checkBox = view.findViewById(R.id.checkBox);
        final Button btnContinue = view.findViewById(R.id.btnContinue);

        builder.setView(view).setMessage("Terms and Conditions");

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnContinue.setEnabled(true);
                } else {
                    btnContinue.setEnabled(false);
                }
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isClicked", true);
        editor.apply();

    }
}
