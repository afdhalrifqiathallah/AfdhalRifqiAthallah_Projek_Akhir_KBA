package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.ApiConfig;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.register.ResponseRegister;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityMainBinding;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.etUsernamaRegister.getText().toString().trim();
                String email = binding.etEmailRegister.getText().toString().trim();
                String password = binding.etPasswordRegister.getText().toString().trim();

                if(TextUtils.isEmpty(userName)) {
                    binding.etUsernamaRegister.setError("username harus diisi!");
                } else if(TextUtils.isEmpty(email)) {
                    binding.etEmailRegister.setError("Email harus diisi!");
                } else if(TextUtils.isEmpty(password)) {
                    binding.etPasswordRegister.setError("Password harus diisi!");
                } else {
                    register(userName, email, password);
                }
            }
        });
    }

    private void register(String userName, String email, String password) {
        ApiConfig.service.requestRegister(userName, email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()){
                    ResponseRegister responseRegister = response.body();
                    if (responseRegister.isSukses()){
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();

                        Intent registerSuccess = new Intent(RegisterActivity.this, RegisterSuccessActivity.class);
                        startActivity(registerSuccess);
                        finishAffinity();

                    } else {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Response Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Dimohon untuk periksa jaringan anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


