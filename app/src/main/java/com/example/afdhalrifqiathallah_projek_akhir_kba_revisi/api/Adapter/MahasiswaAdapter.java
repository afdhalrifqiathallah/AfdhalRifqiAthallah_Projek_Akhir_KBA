package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa.DataMahasiswaItem;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.databinding.RowListBinding;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.AdapterViewHolder> {

    List<DataMahasiswaItem> dataMahasiswaItems;

    public MahasiswaAdapter(List<DataMahasiswaItem> dataMahasiswaItems) {
        this.dataMahasiswaItems = dataMahasiswaItems;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(RowListBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.AdapterViewHolder holder, int position) {
        DataMahasiswaItem responsedatamahasiswa = dataMahasiswaItems.get(position);
        String NamaMahasiswa = responsedatamahasiswa.getNama();
        String NimMahasiswa = responsedatamahasiswa.getNim();
        String FakultasMahasiswa = responsedatamahasiswa.getFakultas();

        holder.mahasiswabinding.tvListnama.setText(NamaMahasiswa);
        holder.mahasiswabinding.tvListnim.setText(NimMahasiswa);
        holder.mahasiswabinding.tvListfakultas.setText(FakultasMahasiswa);
        Glide.with(holder.mahasiswabinding.imageView5)
                .load(responsedatamahasiswa.getImage())
                .into(holder.mahasiswabinding.imageView5);
    }

    @Override
    public int getItemCount() {
        return dataMahasiswaItems.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        RowListBinding mahasiswabinding;

        public AdapterViewHolder(RowListBinding mahasiswabinding) {
            super(mahasiswabinding.getRoot());
            this.mahasiswabinding = mahasiswabinding;
        }
    }
}
