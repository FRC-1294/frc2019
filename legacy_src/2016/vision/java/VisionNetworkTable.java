package org.usfirst.frc.team1294.vision;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionNetworkTable {
	private static final String THRESHOLD_HIGH_L = "thresholdHighL";
	private static final String THRESHOLD_HIGH_S = "thresholdHighS";
	private static final String THRESHOLD_HIGH_H = "thresholdHighH";
	private static final String THRESHOLD_LOW_L = "thresholdLowL";
	private static final String THRESHOLD_LOW_S = "thresholdLowS";
	private static final String THRESHOLD_LOW_H = "thresholdLowH";
	private static final int DEFAULT_THRESHOLD_HIGH_L = 255;
	private static final int DEFAULT_THRESHOLD_HIGH_S = 255;
	private static final int DEFAULT_THRESHOLD_HIGH_H = 120;
	private static final int DEFAULT_THRESHOLD_LOW_L = 150;
	private static final int DEFAULT_THRESHOLD_LOW_S = 150;
	private static final int DEFAULT_THRESHOLD_LOW_H = 30;
	
	private static final String QUALITY = "quality";
	private static final int DEFAULT_QUALITY = 50;
	
	private static final String FPS = "fps";
	private static final int DEFAULT_FPS = 5;
	
	private static final String TARGET_ACQUIRED = "targetAcquired";
	private static final boolean DEFAULT_TARGET_ACQUIRED = false;
	
	private static final String TARGET_X = "targetX";
	private static final int DEFAULT_TARGET_X = 0;
	
	private static final String TARGET_Y = "targetY";
	private static final int DEFAULT_TARGET_Y = 0;
	
	private static final String LAST_UPDATED = "lastUpdated";
	private static final long DEFAULT_LAST_UPDATED = -1;
	
	private static final String DISPLAY_MASK = "displayMask";
	private static final boolean DEFAULT_DISPLAY_MASK = false;
	
	private static final String BRIGHTNESS = "brightness";
	private static final int DEFAULT_BRIGHTNESS = 200;
	
	private static final String ABSOLUTE_EXPOSURE = "absoluteExposure";
	private static final int DEFAULT_ABSOLUTE_EXPOSURE = 20;
	
	private static final String CAPTURE_NEXT_FRAME = "captureNextFrame";
	private static final boolean DEFAULT_CAPTURE_NEXT_FRAME = false;
	
	private final NetworkTable nt;

	public VisionNetworkTable() {
		NetworkTable.setClientMode();
		NetworkTable.setTeam(1294);
		nt = NetworkTable.getTable("vision");
		
		
		// send version information
		VersionInformation vi = new VersionInformation();
		nt.putString("version", vi.getVersion());
		nt.putString("author", vi.getAuthor());	
	}
	
	public int getThresholdLowH() {
		return (int)nt.getNumber(THRESHOLD_LOW_H, DEFAULT_THRESHOLD_LOW_H);
	}
	
	public void setThresholdLowH(double value) {
		nt.putNumber(THRESHOLD_LOW_H, value);
	}
	
	public int getThresholdLowS() {
		return (int)nt.getNumber(THRESHOLD_LOW_S, DEFAULT_THRESHOLD_LOW_S);
	}
	
	public void setThresholdLowS(double value) {
		nt.putNumber(THRESHOLD_LOW_S, value);
	}
	
	public int getThresholdLowL() {
		return (int)nt.getNumber(THRESHOLD_LOW_L, DEFAULT_THRESHOLD_LOW_L);
	}
	
	public void setThresholdLowL(double value) {
		nt.putNumber(THRESHOLD_LOW_L, value);
	}
	
	public int getThresholdHighH() {
		return (int)nt.getNumber(THRESHOLD_HIGH_H, DEFAULT_THRESHOLD_HIGH_H);
	}
	
	public void setThresholdHighH(double value) {
		nt.putNumber(THRESHOLD_HIGH_H, value);
	}
	
	public int getThresholdHighS() {
		return (int)nt.getNumber(THRESHOLD_HIGH_S, DEFAULT_THRESHOLD_HIGH_S);
	}
	
	public void setThresholdHighS(double value) {
		nt.putNumber(THRESHOLD_HIGH_S, value);
	}
	
	public int getThresholdHighL() {
		return (int)nt.getNumber(THRESHOLD_HIGH_L, DEFAULT_THRESHOLD_HIGH_L);
	}
	
	public void setThresholdHighL(double value) {
		nt.putNumber(THRESHOLD_HIGH_L, value);
	}
	
	public int getQuality() {
		return (int)nt.getNumber(QUALITY, DEFAULT_QUALITY);
	}
	
	public int getFPS() {
		return (int)nt.getNumber(FPS, DEFAULT_FPS);
	}
	
	public boolean isTargetAcquired() {
		return nt.getBoolean(TARGET_ACQUIRED, DEFAULT_TARGET_ACQUIRED);
	}
	
	public void setTargetAcquired(boolean value) {
		nt.putBoolean(TARGET_ACQUIRED, value);
	}
	
	public int getTargetX() {
		return (int)nt.getNumber(TARGET_X, DEFAULT_TARGET_X);
	}
	
	public void setTargetX(int value) {
		nt.putNumber(TARGET_X, value);
	}
	
	public int getTargetY() {
		return (int)nt.getNumber(TARGET_Y, DEFAULT_TARGET_Y);
	}
	
	public void setTargetY(int value) {
		nt.putNumber(TARGET_Y, value);
	}
	
	public long getLastUpdated() {
		return (long)nt.getNumber(LAST_UPDATED, DEFAULT_LAST_UPDATED);
	}
	
	public void setLastUpdated(long value) {
		nt.putNumber(LAST_UPDATED, value);
	}
	
	public boolean isDisplayMask() {
		return (boolean)nt.getBoolean(DISPLAY_MASK, DEFAULT_DISPLAY_MASK);
	}
	
	public void setDisplayMask(boolean value) {
		nt.putBoolean(DISPLAY_MASK, value);
	}
	
	public int getBrightness() {
		return (int)nt.getNumber(BRIGHTNESS, DEFAULT_BRIGHTNESS);
	}
	
	public void setBrightness(int value) {
		nt.putNumber(BRIGHTNESS, value);
	}
	
	public int getAbsoluteExposure() {
		return (int)nt.getNumber(ABSOLUTE_EXPOSURE, DEFAULT_ABSOLUTE_EXPOSURE);
	}
	
	public void setAbsoluteExposure(int value) {
		nt.putNumber(ABSOLUTE_EXPOSURE, value);
	}
	
	public boolean isCaptureNextFrame() {
		return (boolean)nt.getBoolean(CAPTURE_NEXT_FRAME, DEFAULT_CAPTURE_NEXT_FRAME);
	}
	
	public void setCaptureNextFrame(boolean value) {
		nt.putBoolean(CAPTURE_NEXT_FRAME, value);
	}
}