package com.sort.compare;

import java.awt.BasicStroke;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class App extends ApplicationFrame {
	
	/*
	 * Set difficulty EASY, MEDIUM, HARD
	 */
	private static final Difficulty DIFFICULTY = Difficulty.EASY;

	
	/*
	 * 
	 */
	public App(String applicationTitle, String chartTitle) {
		
		super(applicationTitle);
		
		JFreeChart lineChart;
		try {
			lineChart = ChartFactory.createLineChart(chartTitle, "Size of Array", "Speed (ms)", createDataset(),
					PlotOrientation.VERTICAL, true, true, false);
			
			lineChart.getCategoryPlot().getRenderer().setSeriesStroke(0, new BasicStroke(3));
			lineChart.getCategoryPlot().getRenderer().setSeriesStroke(1, new BasicStroke(3));
			
			ChartPanel chartPanel = new ChartPanel(lineChart);
			chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
			setContentPane(chartPanel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DefaultCategoryDataset createDataset() throws Exception {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		List<SortMetric> results = SortWithMetrics.compileSortResults(DIFFICULTY);
		
		for(SortMetric result : results) {
			dataset.addValue(result.getSpeedInMs(), result.getSortType(), result.getItemCount());
		}
		
		return dataset;
	}

	public static void main(String[] args) {
		App chart = new App("Sorting Speed", "Speed of Sort vs Time");

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}