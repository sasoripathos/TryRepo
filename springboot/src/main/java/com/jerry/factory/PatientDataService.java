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

@RestController
@RequestMapping("/patient_data")
public class PatientDataService {
	/*@GetMapping("/{id}")
	public void getOneTestResult(@PathVariable int id, @RequestParam("field") String field) {
		
	}*/
	
	@GetMapping("/testdataset")
	public GraphDataSet getSampleDataSet() {
		List<Number> datas = new ArrayList<Number>();
		datas.add(1);
		datas.add(2);
		datas.add(3);
		GraphDataSet a = new BarDataSet("testset", datas, "#112233", "#223344");
		return a;
	}
}
