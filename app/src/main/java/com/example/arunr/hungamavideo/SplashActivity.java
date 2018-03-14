package com.example.arunr.hungamavideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
    private AlertDialog dialog;

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
                // when back button is pressed from MainActivity it exits the app
                // else it goes to dialog screen and then the splashscreen,
                // when the dialog is displayed to the user for first time
                // or if the user has not agreed to the terms and conditions
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                // setting the buttons isClicked value to true
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isClicked", true);
                editor.apply();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
