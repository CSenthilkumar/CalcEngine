package com.calc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calc.model.AssetDTO;
import com.calc.model.AssetDataDTO;
import com.calc.model.AssetDataResponse;
import com.calc.model.ConditonRulesDTO;
import com.calc.repository.ConditionRulesRepository;
import com.calc.repository.GetAssetDayWiseHistory;

@Component
public class ConditionRulesHandler {

	@Autowired
	ConditionRulesRepository repo;
	
	@Autowired
	GetAssetDayWiseHistory assetRepo;
	
	public AssetDataResponse processConditionRules(AssetDTO assetRequest) {
		
		AssetDataResponse response = new AssetDataResponse();
		ConditonRulesDTO reulerequest = prepareRulesRequest(assetRequest);
		
		String status = repo.addRule(reulerequest);
		System.out.println(status);
					
		if("success".equalsIgnoreCase(assetRepo.addAsset(prepareAssetData(assetRequest, reulerequest)))) {
			
			System.out.println("*****   Processed Asset Data Stored successfully into DB   ******");
    		response.setAssetList(assetRepo.getAssetDayWiseHistory(assetRequest.getMessageDateTime()));
    		
    	} else {
    		
    		response.setMessage("Processing data failed ...");
    	}
		
		return response;
	}
	
	private static AssetDataDTO prepareAssetData(AssetDTO assetRequest, ConditonRulesDTO reulerequest) {
		
		AssetDataDTO asset = new AssetDataDTO();
		
		asset.setAssetId(assetRequest.getAssetId());
		asset.setAssetName(assetRequest.getAssetName());
		asset.setDeviceId(assetRequest.getDeviceId());
		asset.setMessageDateTime(assetRequest.getMessageDateTime());
		asset.setMaxValue(assetRequest.getMaxValue());
		asset.setMinValue(assetRequest.getMinValue());
		asset.setRole(assetRequest.getRole());
		asset.setSeverity(reulerequest.getCondtionExpression());
		asset.setStatus(assetRequest.getStatus());
		
		return asset;
	}
	private static ConditonRulesDTO prepareRulesRequest(AssetDTO assetRequest) {
		
		ConditonRulesDTO rules = new ConditonRulesDTO();
	
		rules.setConditionRuleId(assetRequest.getAssetId());
		rules.setCondtionExpression(prepareConditionExpression(assetRequest));
		rules.setParameter(assetRequest.getStatus());
		rules.setSource(assetRequest.getDeviceId());
		rules.setTriggerCondition(prepareTriggerCondition(rules.getCondtionExpression()));
		rules.setConditionName(prepareConditionName(rules.getCondtionExpression()));
		
		return rules;
	}
	
	private static String prepareConditionExpression (AssetDTO request) {
		
		if(request.getStatus()>= request.getMinValue() && request.getStatus() <= request.getMaxValue()) {
			return "MEDIUM";
		} 
		else if(request.getStatus()< request.getMinValue() ) {
			return "LOW";
		}
		else if(request.getStatus() > request.getMaxValue()) {
			return "CRITICAL";
		} else {
			return "NONE";
		}
	}
	
	private static String prepareTriggerCondition(String exp) {
		
		if("LOW".equalsIgnoreCase(exp)) {
			return "Less Than";
		} 
		else if("MEDIUM".equalsIgnoreCase(exp)) {
			return "Equal";
		}
		else if("CRITICAL".equalsIgnoreCase(exp)) {
			return "Greater Than";
		}
		else {
			return "None";
		}
	}
	
	private static String prepareConditionName(String exp) {
		
		if("LOW".equalsIgnoreCase(exp)) {
			return "Operation Stopped";
		} 
		else if("MEDIUM".equalsIgnoreCase(exp)) {
			return "Operation Running Progress";
		}
		else if("CRITICAL".equalsIgnoreCase(exp)) {
			return "Operation Overload";
		}
		else {
			return "None";
		}
	}
}
