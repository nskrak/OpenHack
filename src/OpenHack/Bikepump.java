package OpenHack;

public class Bikepump { // kanske kan implementa ett interace som alla objekten ärver från

	double longitude;
	double latitude;
	String description;
	
	public Bikepump(double longitude, double latitude, String description) { //Kanske borde ta in en map idk
		
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		
	}

	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public String getDescription() {
		return description;
	}
}
