package net.bandung.bean;

public class EventBean {

    private int eventid;
    private String nama_event;
    private String deskripsi;
    private String gambar;
        
    
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
	public String getGambar() {
		return gambar;
	}
	public void setGambar(String gambar) {
		this.gambar = gambar;
	}
}