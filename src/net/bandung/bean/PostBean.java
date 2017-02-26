package net.bandung.bean;

import java.text.SimpleDateFormat;

public class PostBean {

    private int pid;
    private String judul;
    private String isi;
    private String gambar;
    private String kategori;
    private String author;
    private String post_date;
        
    
    public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public String getIsi() {
		return isi;
	}
	public void setIsi(String isi) {
		this.isi = isi;
	}	
	public String getGambar() {
		return gambar;
	}
	public void setGambar(String gambar) {
		this.gambar = gambar;
	}	
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	
	public String getDate() {
		return post_date;
	}
	public void setDate(String post_date) {
		this.post_date = post_date;
	}
}