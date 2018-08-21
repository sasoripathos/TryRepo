package com.jerry.factory;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.graphdata.BarDataSet;
import com.jerry.graphdata.GraphDataSet;
import com.jerry.graphdata.PatientGraphDataPack;

@RestController
@RequestMapping("/patient_data")
public class PatientDataService {
	@GetMapping("/{id}")
	public PatientGraphDataPack getOneTestResult(@PathVariable int id, @RequestParam("field") String field) {
		List<String> lables = new ArrayList<String>();
		lables.add(field);
		List<GraphDataSet> datasets = new ArrayList<GraphDataSet>();
		datasets.add(this.getSampleDataSet("lower bound", 80));
		datasets.add(this.getSampleDataSet("patient "+ id +" value", 86));
		datasets.add(this.getSampleDataSet("upper bound", 90));
		return new PatientGraphDataPack(lables, datasets);
	}
	
	@GetMapping("/testdataset")
	public GraphDataSet getSampleDataSet() {
		List<Number> datas = new ArrayList<Number>();
		datas.add(1);
		datas.add(2);
		datas.add(3);
		GraphDataSet a = new BarDataSet("testset", datas, "#112233", "#223344");
		return a;
	}
	
	public GraphDataSet getSampleDataSet(String lable, Number value) {
		List<Number> datas = new ArrayList<Number>();
		datas.add(value);
		GraphDataSet a = new BarDataSet(lable, datas, "#112233", "#223344");
		return a;
	}
}
