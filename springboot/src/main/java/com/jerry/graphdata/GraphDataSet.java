package com.jerry.graphdata;

import java.util.List;

public abstract class GraphDataSet {
	private String label;
	private List<Number> data;
	private String borderColor;
	
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<Number> getData() {
		return data;
	}
	public void setData(List<Number> data) {
		this.data = data;
	}
	
}
