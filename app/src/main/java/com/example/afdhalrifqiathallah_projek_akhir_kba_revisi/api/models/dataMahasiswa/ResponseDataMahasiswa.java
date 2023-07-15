package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDataMahasiswa{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataMahasiswa")
	private List<DataMahasiswaItem> dataMahasiswa;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataMahasiswa(List<DataMahasiswaItem> dataMahasiswa){
		this.dataMahasiswa = dataMahasiswa;
	}

	public List<DataMahasiswaItem> getDataMahasiswa(){
		return dataMahasiswa;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDataMahasiswa{" + 
			"pesan = '" + pesan + '\'' + 
			",dataMahasiswa = '" + dataMahasiswa + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}