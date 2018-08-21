package com.jerry.graphdata;

import java.util.List;

public class PatientGraphDataPack {
	private List<String> labels;
	private List<GraphDataSet> datasets;
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<GraphDataSet> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<GraphDataSet> datasets) {
		this.datasets = datasets;
	}
	
}
