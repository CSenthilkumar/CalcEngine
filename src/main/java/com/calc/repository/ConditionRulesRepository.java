package com.calc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.calc.model.ConditonRulesDTO;

@Repository
public class ConditionRulesRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public String addRule(ConditonRulesDTO rules) {
        mapper.save(rules);
        return "*****   Condition Rules Data Stored into DynamoDB successfully   ******";
    }

    public ConditonRulesDTO findPersonByPersonId(String personId) {
        return mapper.load(ConditonRulesDTO.class, personId);
    }

    public String deletePerson(ConditonRulesDTO rules) {
        mapper.delete(rules);
        return "assetData removed !!";
    }

    public String editPerson(ConditonRulesDTO assetData) {
        mapper.save(assetData, buildExpression(assetData));
        return "record updated ...";
    }

    private DynamoDBSaveExpression buildExpression(ConditonRulesDTO rules) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("conditionRuleId", new ExpectedAttributeValue(new AttributeValue().withS(rules.getConditionRuleId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
