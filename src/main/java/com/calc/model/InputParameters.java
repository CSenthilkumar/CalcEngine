package com.calc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputParameters implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7076000587427961947L;

	@JsonProperty("ASSETID")
    private String assetId;
	@JsonProperty("MESSAGEDATETIME")
    private String messageTimeStamp;
	@JsonProperty("DEVICEID")
    private int deviceId;
	@JsonProperty("STATUS")
    private int status;
	@JsonProperty("SEVERITY")
    private String severity;
	@JsonProperty("MIN.VALUE")
    private int minValue;
	@JsonProperty("MAX.VALUE")
    private int maxValue;
	@JsonProperty("ROLE")
    private String role;
	@JsonProperty("ASSETNAME")
    private String assetName;
	
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(String messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "inputParameters [assetId=" + assetId + ", messageTimeStamp=" + messageTimeStamp + ", deviceId="
                + deviceId + ", status=" + status + ", severity=" + severity + ", minValue=" + minValue + ", maxValue="
                + maxValue + ", role=" + role + ", assetName=" + assetName + "]";
    }
}
