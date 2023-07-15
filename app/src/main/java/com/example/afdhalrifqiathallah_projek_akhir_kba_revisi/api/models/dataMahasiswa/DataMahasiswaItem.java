package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa;

import com.google.gson.annotations.SerializedName;

public class DataMahasiswaItem{

	@SerializedName("fakultas")
	private String fakultas;

	@SerializedName("image")
	private String image;

	@SerializedName("nim")
	private String nim;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id")
	private String id;

	public void setFakultas(String fakultas){
		this.fakultas = fakultas;
	}

	public String getFakultas(){
		return fakultas;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataMahasiswaItem{" + 
			"fakultas = '" + fakultas + '\'' + 
			",image = '" + image + '\'' + 
			",nim = '" + nim + '\'' + 
			",nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}