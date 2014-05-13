package com.pis.charts;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.pis.model.ZamMaerz;
import com.pis.service.EntityService;
import com.pis.service.MaerzService;

public class TrendCharts {

	
	public static JFreeChart generateEffeciencyChart(EntityService<ZamMaerz> zamMaerzService) {

		// Create a time series chart
		XYSeries series = new XYSeries("Chod pece");
		List<ZamMaerz> zamMaerzList = zamMaerzService.getEntities();
		for (int i=0;i<zamMaerzList.size();i++) {
			series.add(i+1,zamMaerzList.get(i).getMaerz().getChodPece());
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYLineChart("Chod pece", "Zmena", "Hodiny", dataset, PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public static JFreeChart generatePlanChart(EntityService<ZamMaerz> zamMaerzService) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<ZamMaerz> zamMaerzList = zamMaerzService.getEntities();
		for (int i=0;i<zamMaerzList.size();i++) {
			dataset.addValue(zamMaerzList.get(i).getMaerz().getVyrobaVapno6Plan(), "Plán",(Integer)i);
			dataset.addValue(zamMaerzList.get(i).getMaerz().getVyrobaVapno6Skut(), "Skutočnosť",(Integer)i);	
	
	//		dataset.addValue(zamMaerzList.get(i).getMaerz().getVyrobaVapno6Plan(), "Plán", zamMaerzList.get(i).getDatum().toString()+" "+zamMaerzList.get(i).getZmena());
		//	dataset.addValue(zamMaerzList.get(i).getMaerz().getVyrobaVapno6Skut(), "Skutočnosť", zamMaerzList.get(i).getDatum().toString()+" "+zamMaerzList.get(i).getZmena());	
		}
		JFreeChart chart = ChartFactory.createBarChart3D("Porovnanie plánu a skutočnosti výroby vápna", "Zmena", "Jednotka", dataset, PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

}
