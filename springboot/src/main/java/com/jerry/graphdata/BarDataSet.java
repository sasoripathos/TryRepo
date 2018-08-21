package com.jerry.graphdata;

import java.util.List;

public class BarDataSet extends GraphDataSet {
	private String backgroundColor;
	
	public BarDataSet() {
	}
	
	public BarDataSet(String label, List<Number> data, String borderColor, String backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.setLabel(label);
		this.setData(data);
		this.setBorderColor(borderColor);
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
