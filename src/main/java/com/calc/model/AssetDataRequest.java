package com.calc.model;

import java.io.Serializable;

public class AssetDataRequest implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6965971309016301555L;

	private InputParameters inputParameters;

    public InputParameters getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    @Override
    public String toString() {
        return "AssetDataRequest [inputParameters=" + inputParameters + "]";
    }
}
