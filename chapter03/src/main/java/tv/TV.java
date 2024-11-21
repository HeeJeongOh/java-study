package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {
		this(1, 0, false);
	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	void power(boolean on) {
		this.power = on;
	}

	void channel(int channel) {
		this.channel = channel;
		
		if(this.channel > 255) { this.channel = 1; }
		if(this.channel < 1) { this.channel = 255; }
	}

	void channel(boolean up) {
		if(up == true) {
			this.channel(this.channel + 1);
		}
		else {
			this.channel(this.channel - 1);
		}
	}

	void volume(int volume) {
		this.volume = volume;

		if(this.volume > 100) { this.volume = 0; }
		if(this.volume < 0) { this.volume = 100; }
	}

	void volume(boolean up) {
		if(up == true) {
			this.volume(this.volume + 1);
		}
		else {
			this.volume(this.volume - 1);
		}
	}

	void status() {
		System.out.format("TV[channel=%d, volume=%d, power=%s]\n", this.channel, this.volume, this.power ? "on" : "off");

	}

}
