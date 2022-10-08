package com.calc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calc.handler.ConditionRulesHandler;
import com.calc.handler.ProcessAssetRawDataHandler;
import com.calc.model.AssetDTO;
import com.calc.model.AssetDataRequest;
import com.calc.model.AssetDataResponse;

@Service
public class AssetDataServiceImpl {

	@Autowired
	private ProcessAssetRawDataHandler assetHandler;
	
	@Autowired
	private ConditionRulesHandler rulesHandler;

	public AssetDataResponse processAssetRawData(AssetDataRequest request) {

		AssetDTO assetRequest = prepareRequest(request);
		assetHandler.processAssetRawData(assetRequest);
		
		return rulesHandler.processConditionRules(assetRequest);
	}

	private static AssetDTO prepareRequest(AssetDataRequest request) {

		AssetDTO asset = new AssetDTO();
		asset.setAssetId(request.getInputParameters().getAssetId());
		asset.setAssetName(request.getInputParameters().getAssetName());
		asset.setDeviceId(request.getInputParameters().getDeviceId());
		asset.setMessageDateTime(request.getInputParameters().getMessageTimeStamp());
		asset.setMaxValue(request.getInputParameters().getMaxValue());
		asset.setMinValue(request.getInputParameters().getMinValue());
		asset.setRole(request.getInputParameters().getRole());
		asset.setSeverity(request.getInputParameters().getSeverity());
		asset.setStatus(request.getInputParameters().getStatus());

		return asset;
	}

}
