package com.calc.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "ProcessAssetData")
public class AssetDataDTO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7084520587145925205L;

	@DynamoDBHashKey(attributeName = "assetId")
    private String assetId;
    
    @DynamoDBAttribute
    private String messageDateTime;
    
    @DynamoDBAttribute
    private int deviceId;
    
    @DynamoDBAttribute
    private int status;
    
    @DynamoDBAttribute
    private String severity;
    
    @DynamoDBAttribute
    private int minValue;
    
    @DynamoDBAttribute
    private int maxValue;
    
    @DynamoDBAttribute
    private String role;
    
    @DynamoDBAttribute
    private String assetName;
    
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getMessageDateTime() {
		return messageDateTime;
	}

	public void setMessageDateTime(String messageDateTime) {
		this.messageDateTime = messageDateTime;
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
        return "inputParameters [assetId=" + assetId + ", messageTimeStamp=" + messageDateTime + ", deviceId="
                + deviceId + ", status=" + status + ", severity=" + severity + ", minValue=" + minValue + ", maxValue="
                + maxValue + ", role=" + role + ", assetName=" + assetName + "]";
    }
    
}
