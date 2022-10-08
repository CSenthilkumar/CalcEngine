package com.calc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.calc.model.AssetDTO;

@Repository
public class AssetRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public String addAsset(AssetDTO assetData) {
		mapper.save(assetData);
		return "success";
	}

	public AssetDTO findPersonByPersonId(String personId) {
		return mapper.load(AssetDTO.class, personId);
	}

	public String deletePerson(AssetDTO assetData) {
		mapper.delete(assetData);
		return "assetData removed !!";
	}

	public String editPerson(AssetDTO assetData) {
		mapper.save(assetData, buildExpression(assetData));
		return "record updated ...";
	}

	private DynamoDBSaveExpression buildExpression(AssetDTO assetData) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("assetId", new ExpectedAttributeValue(new AttributeValue().withS(assetData.getAssetId())));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}

}
