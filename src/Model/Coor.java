package Model;

public class Coor {

	private double lon;
	private double lat;
	private String msgTime;
	
	
	public Coor() {
		
	}
	
	public Coor(double lon, double lat, String msgTime) {
		this.lon = lon;
		this.lat = lat;
		this.msgTime = msgTime;
	}
	
	public Coor(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
	
	
}
