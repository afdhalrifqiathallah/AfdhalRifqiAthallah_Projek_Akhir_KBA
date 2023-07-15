package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityMainBinding;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityRegisterSuccessBinding;

public class RegisterSuccessActivity extends AppCompatActivity {

    ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginSuccees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(RegisterSuccessActivity.this, LoginActivity.class);
                startActivity(login);
                finishAffinity();
            }
        });
    }
}