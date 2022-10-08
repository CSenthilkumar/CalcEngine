package com.calc.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "ConditionalRule")
public class ConditonRulesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7055600012989583091L;

	@DynamoDBHashKey(attributeName = "conditionRuleId")
	private String conditionRuleId;

	@DynamoDBAttribute
	private String conditionName;

	@DynamoDBAttribute
	private int source;

	@DynamoDBAttribute
	private int parameter;

	@DynamoDBAttribute
	private String triggerCondition;

	@DynamoDBAttribute
	private String condtionExpression;

	public String getConditionRuleId() {
		return conditionRuleId;
	}

	public void setConditionRuleId(String conditionRuleId) {
		this.conditionRuleId = conditionRuleId;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

	public String getTriggerCondition() {
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition) {
		this.triggerCondition = triggerCondition;
	}

	public String getCondtionExpression() {
		return condtionExpression;
	}

	public void setCondtionExpression(String condtionExpression) {
		this.condtionExpression = condtionExpression;
	}

	@Override
	public String toString() {
		return "ConditonRulesDTO [conditionRuleId=" + conditionRuleId + ", conditionName=" + conditionName + ", source="
				+ source + ", parameter=" + parameter + ", triggerCondition=" + triggerCondition
				+ ", condtionExpression=" + condtionExpression + "]";
	}

}
