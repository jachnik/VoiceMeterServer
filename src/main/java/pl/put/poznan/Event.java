package pl.put.poznan;

public class Event {
	private String deviceIdentifier;
	private int voicePower;
	
	public Event() { }
	
	public Event(String deviceIdentifier, int voicePower){
		this.deviceIdentifier = deviceIdentifier;
		this.voicePower = voicePower;
	}
	
	public String getDeviceIdentifier() {
		return deviceIdentifier;
	}
	
	public int getVoicePower() {
		return voicePower;
	}

	public void setDeviceIdentifier(String deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	public void setVoicePower(int voicePower) {
		this.voicePower = voicePower;
	}
	

	
}
