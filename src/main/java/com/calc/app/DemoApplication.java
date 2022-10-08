package com.calc.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.model.AssetDTO;
import com.calc.model.AssetDataRequest;
import com.calc.model.AssetDataResponse;
import com.calc.repository.AssetRepository;
import com.calc.service.AssetDataServiceImpl;

@SpringBootApplication
@RestController
@ComponentScan({"com.calc"})
public class DemoApplication {

    @Autowired
    private AssetRepository assetRepo;
    
    @Autowired
    private AssetDataServiceImpl service;
 
    @PostMapping("/saveAsset")
    public AssetDataResponse saveAsset(@RequestBody AssetDataRequest request) {
    	
        return service.processAssetRawData(request);
    }

    @GetMapping("/getPerson/{personId}")
    public AssetDTO findPerson(@PathVariable String assetId) {
        return assetRepo.findPersonByPersonId(assetId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody AssetDTO asset) {
        return assetRepo.deletePerson(asset);
    }

    @PutMapping("/editPerson")
    public String updatePerson(@RequestBody AssetDTO asset) {
        return assetRepo.editPerson(asset);
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
