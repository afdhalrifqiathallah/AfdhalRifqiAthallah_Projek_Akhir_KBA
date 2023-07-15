package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.Adapter.MahasiswaAdapter;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.ApiConfig;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa.DataMahasiswaItem;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa.ResponseDataMahasiswa;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityListBinding;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    MahasiswaAdapter mahasiswaAdapter;

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rclylist.setHasFixedSize(true);
        binding.rclylist.setLayoutManager(new LinearLayoutManager(this));


        ApiConfig.service.getDataMahasiswa().enqueue(new Callback<ResponseDataMahasiswa>() {
            @Override
            public void onResponse(Call<ResponseDataMahasiswa> call, Response<ResponseDataMahasiswa> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        ResponseDataMahasiswa responseDataMahasiswa = response.body();
                        List<DataMahasiswaItem> dataMahasiswaItems = responseDataMahasiswa.getDataMahasiswa();

                        Toast.makeText(ListActivity.this, "Response Mahasiswa", Toast.LENGTH_SHORT).show();

                        mahasiswaAdapter = new MahasiswaAdapter(dataMahasiswaItems);
                        binding.rclylist.setAdapter(mahasiswaAdapter);

                    }else {
                        Toast.makeText(ListActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ListActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDataMahasiswa> call, Throwable t) {
                Toast.makeText(ListActivity.this, "Harap Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}