package com.jerry.factory;

import java.util.ArrayList;
import java.util.List;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.config.BarChartConfig;
import com.jerry.exception.ExceptionResponse;
import com.jerry.exception.InvalidIdException;
import com.jerry.graphdata.BarDataSet;
import com.jerry.graphdata.GraphDataSet;
import com.jerry.graphdata.PatientGraphDataPack;

@RestController
@RequestMapping("/patient_data")
public class PatientDataService {
	@Autowired
	private BarChartConfig barChartConfig;
	
	@GetMapping("/{id}")
	public PatientGraphDataPack getOneTestResult(@PathVariable int id, @RequestParam("field") String field) throws InvalidIdException {
		if (id <= 0) {
			throw new InvalidIdException("Invalid ID: ID should be non-negative");
		}
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
		GraphDataSet a = new BarDataSet("testset", datas, barChartConfig.getBorderColor(), barChartConfig.getBackgroundColor());
		return a;
	}
	
	public GraphDataSet getSampleDataSet(String lable, Number value) {
		List<Number> datas = new ArrayList<Number>();
		datas.add(value);
		GraphDataSet a = new BarDataSet(lable, datas, barChartConfig.getBorderColor(), barChartConfig.getBackgroundColor());
		return a;
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> invalidIdResponse(InvalidIdException excep) {
		ExceptionResponse resp = new ExceptionResponse();
		resp.setStatus(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(excep.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
