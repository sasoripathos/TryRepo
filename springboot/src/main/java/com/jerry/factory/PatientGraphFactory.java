package com.jerry.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphs")
public class PatientGraphFactory {
	@RequestMapping(value="/line", method = RequestMethod.GET, produces = "image/png")
	public @ResponseBody byte[] getLineGraph() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(600, "jerry", "01/01/2012");
		dataset.addValue(300, "jerry", "01/20/2012");
		dataset.addValue(400, "jerry", "02/10/2012");
		dataset.addValue(540, "upper bound", "01/01/2012");
		dataset.addValue(540, "upper bound", "01/20/2012");
		dataset.addValue(540, "upper bound", "02/10/2012");
		dataset.addValue(450, "lower bound", "01/01/2012");
		dataset.addValue(450, "lower bound", "01/20/2012");
		dataset.addValue(450, "lower bound", "02/10/2012");
		JFreeChart lineChart = ChartFactory.createLineChart("abc", "date", "value", dataset,
				PlotOrientation.VERTICAL, true,true,false);
		// set axis font
		lineChart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		lineChart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		// set background
		lineChart.getPlot().setBackgroundPaint(Color.white);
		
		// set legend font
		lineChart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 16));
		lineChart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		lineChart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		
		CategoryItemRenderer renderer = lineChart.getCategoryPlot().getRenderer();
		//()renderer.set
		((LineAndShapeRenderer) renderer).setDefaultShapesVisible(true);
		// set label for data
		((LineAndShapeRenderer) renderer).setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		((LineAndShapeRenderer) renderer).setDefaultItemLabelsVisible(true);
		((LineAndShapeRenderer) renderer).setDefaultItemLabelFont(new Font("Arial", Font.BOLD, 16));
		//ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		//renderer.setDefaultPositiveItemLabelPosition(position); 
		
		// Set size
		BufferedImage buf = lineChart.createBufferedImage(900, 600);
		//Graphics2D g = buf.createGraphics();
		//g.setColor(Color.WHITE);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			ImageIO.write(buf, "png", outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outStream.toByteArray();
	}
	
	@RequestMapping(value="/bar", method=RequestMethod.GET, produces="image/png")
	public @ResponseBody byte[] getBarGraph() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(4.0, "lower bound", "WBC");
		dataset.addValue(4.4, "patient value", "WBC");
		dataset.addValue(10.5, "upper bound", "WBC");
		dataset.addValue(4.10, "lower bound", "RBC");
		dataset.addValue(6.43, "patient value", "RBC");
		dataset.addValue(5.60, "upper bound", "RBC");
		dataset.addValue(80, "lower bound", "MVC");
		dataset.addValue(86, "patient value", "MVC");
		dataset.addValue(90, "upper bound", "MVC");
		JFreeChart barChart = ChartFactory.createBarChart("ABC", "Category", "Value", dataset,
				PlotOrientation.VERTICAL, true,true,false);
		// set axis font
		barChart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		// set background
		barChart.getPlot().setBackgroundPaint(Color.white);
		// set legend font
		barChart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		
		
		CategoryItemRenderer renderer = barChart.getCategoryPlot().getRenderer();
		// set maximum width of a bar
		((BarRenderer) renderer).setMaximumBarWidth(0.15);
		
		// set maximum margin between items
		((BarRenderer) renderer).setItemMargin(0.05);
		
		// set bar lable number and font
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelFont(new Font("Arial", Font.BOLD, 16));
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultPositiveItemLabelPosition(position); 
		
		// Set Bar Color
		renderer.setSeriesPaint(0, new Color(50,225,255));
		renderer.setSeriesPaint(1, new Color(255, 87, 51));
		renderer.setSeriesPaint(2, Color.green);
		
		// Set size
		BufferedImage buf = barChart.createBufferedImage(700, 500);
		//Graphics2D g = buf.createGraphics();
		//g.setColor(Color.WHITE);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			ImageIO.write(buf, "png", outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outStream.toByteArray();
	}
	
	@RequestMapping(value="/interbar", method=RequestMethod.GET, produces="image/png")
	public @ResponseBody byte[] getInterBarGraph() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//dataset.addValue(455, "lower bound", "jerry");
		dataset.addValue(643, "ABC Value", "ABC");
		//dataset.addValue(512, "upper bound", "jerry");
		JFreeChart barChart = ChartFactory.createBarChart("ABC", "Category", "Value", dataset,
				PlotOrientation.VERTICAL, true,true,false);
		// set axis font
		barChart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("Arial", Font.BOLD, 16));
		// set background
		barChart.getPlot().setBackgroundPaint(Color.white);
		// set legend font
		barChart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		barChart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Arial", Font.BOLD, 16));
		
		
		CategoryItemRenderer renderer = barChart.getCategoryPlot().getRenderer();
		// set maximum width of a bar
		((BarRenderer) renderer).setMaximumBarWidth(0.15);
		
		// set bar lable number and font
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelFont(new Font("Arial", Font.BOLD, 16));
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultPositiveItemLabelPosition(position); 
		
		// Set Bar Color
		renderer.setSeriesPaint(0, new Color(255, 87, 51));
		
		// add interval marker
		IntervalMarker goodRange = new IntervalMarker(455,512);
		goodRange.setPaint(Color.green);
		goodRange.setLabel("health range");
		goodRange.setLabelFont(new Font("Arial", Font.BOLD, 16));
		goodRange.setLabelAnchor(RectangleAnchor.RIGHT);
		goodRange.setLabelTextAnchor(TextAnchor.CENTER_RIGHT);
		goodRange.setLabelBackgroundColor(Color.green);
		barChart.getCategoryPlot().addRangeMarker(goodRange, Layer.BACKGROUND);
		
		// Set chart size
		BufferedImage buf = barChart.createBufferedImage(700, 500);
		//Graphics2D g = buf.createGraphics();
		//g.setColor(Color.WHITE);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			ImageIO.write(buf, "png", outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outStream.toByteArray();
	}
}
