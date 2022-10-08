package com.calc.repository;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.calc.model.AssetDataDTO;

@Repository
public class GetAssetDayWiseHistory {

	@Autowired
	private DynamoDBMapper mapper;

	public String addAsset(AssetDataDTO assetData) {
		
		mapper.save(assetData);
		return "success";
	}
	
	public List<AssetDataDTO> getAssetDayWiseHistory(String messageDate) {

		HashMap<String, AttributeValue> attr = new HashMap<>();
		attr.put(":v1", new AttributeValue().withS(parseDate(messageDate)));

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("begins_with(messageDateTime,:v1)").withExpressionAttributeValues(attr);

		return mapper.scan(AssetDataDTO.class, scanExpression);
	}

	private String parseDate(String messageDate) {

		String dateString = null;
		try {

			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(messageDate);
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			dateString = formatter.format(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return dateString;
	}
}
