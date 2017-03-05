package net.bandung.bean;

import java.sql.Blob;

public class EventBean {

    private int eventid;
    private String nama_event;
    private String deskripsi;
    private java.sql.Blob gambar;
        
    
    public int getEid() {
		return eventid;
	}
	public void setEid(int eventid) {
		this.eventid = eventid;
	}
	public String getEvent() {
		return nama_event;
	}
	public void setEvent(String nama_event) {
		this.nama_event = nama_event;
	}
	public String getIsi() {
		return deskripsi;
	}
	public void setIsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}	
	public Blob getGambar() {
		return gambar;
	}
	public void setGambar(Blob gambar) {
		this.gambar = gambar;
	}
}