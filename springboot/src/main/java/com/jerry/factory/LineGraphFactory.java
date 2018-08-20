package com.jerry.factory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphs")
public class LineGraphFactory {
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
		lineChart.getPlot().setBackgroundPaint(Color.white);
		
		BufferedImage buf = lineChart.createBufferedImage(500, 500);
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
