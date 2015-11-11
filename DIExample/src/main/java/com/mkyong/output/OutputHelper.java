package com.mkyong.output;

public class OutputHelper {
	IOutputGenerator outputGenerator;
	
	public OutputHelper() {
	}

	public void generateOutput() {
		outputGenerator.generateOutput();
	}
	
	public OutputHelper(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}

	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
}
