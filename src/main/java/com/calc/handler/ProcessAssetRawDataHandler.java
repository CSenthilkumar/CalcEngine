package com.calc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calc.model.AssetDTO;
import com.calc.repository.AssetRepository;

@Service
public class ProcessAssetRawDataHandler {

	@Autowired
	private AssetRepository assetRepo;

	public void processAssetRawData(AssetDTO request) {

		if ("success".equalsIgnoreCase(assetRepo.addAsset(request))) {

			System.out.println("*****   Asset Raw Data Stored successfully   ******");

		} else {

			System.out.println("*****   Processing data failed   *****");
		}
	}
}
