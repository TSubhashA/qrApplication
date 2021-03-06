package com.example.buscustomerapplicationv2.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buscustomerapplicationv2.R;
import com.example.buscustomerapplicationv2.controller.OtpController;
import com.example.buscustomerapplicationv2.helper.CustomDailogue;
import com.example.buscustomerapplicationv2.sharedPref.AppPreferences;
import com.example.buscustomerapplicationv2.sharedPref.VariablesConstant;

import dmax.dialog.SpotsDialog;

public class OtpActivity extends AppCompatActivity {

    Button back, verify;
    EditText editText;
    SpotsDialog progressBar;

    String oTP;


    OtpController otpController;

//    @Override       // for font style
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("font/caviar_dreams.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );

        setContentView(R.layout.activity_otp);

        back = findViewById(R.id.backBtn);
        verify = findViewById(R.id.verifyBtn);

        oTP = getIntent().getStringExtra("otp");
//        flag = getIntent().getIntExtra("flag", 0);

        editText = findViewById(R.id.otp_ev);


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("OTP : " + oTP);
        dialog.setTitle("OTP Box");
        dialog.setCancelable(false);
        dialog.setPositiveButton("ok",
                (dialog1, which) -> {
                    dialog1.dismiss();
                    Toast.makeText(getApplicationContext(), "OTP : " + oTP, Toast.LENGTH_LONG).show();
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        verify.setOnClickListener(view -> {
            progressBar = new SpotsDialog(OtpActivity.this, R.style.CustomDialogue);
            progressBar.show();
            otpController = new OtpController(OtpActivity.this);
            otpController.onVerifyOtp(AppPreferences.getAppPrefrences(VariablesConstant.MOBILE, OtpActivity.this), editText.getText().toString().trim());

        });

        back.setOnClickListener(view -> finish());

    }

    public void onSuccess() {
        progressBar.dismiss();
        startActivity(new Intent(this, LoginActivity.class));
        Toast.makeText(this, "Registration Success", Toast.LENGTH_LONG).show();
        finish();
    }

//    public void onLoginSuccess(){
//        progressBar.dismiss();
//        finish();
//    }

    public void onError(String s) {
        progressBar.dismiss();
        CustomDailogue.showDailogue(this, s);
    }

}
