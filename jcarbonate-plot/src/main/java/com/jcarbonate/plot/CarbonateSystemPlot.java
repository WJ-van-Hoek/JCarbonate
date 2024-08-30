package com.jcarbonate.plot;

import com.jcarbonate.logic.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

@SuppressWarnings("serial")
public class CarbonateSystemPlot extends ApplicationFrame {

    public CarbonateSystemPlot(String title) {
        super(title);
        JFreeChart xylineChart = createChart();
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setBackgroundPaint(new Color(255, 228, 196));
        LogAxis yAxis = new LogAxis("Concentration (mol/L)"); // Set the label for the y-axis
        plot.setRangeAxis(yAxis);

        setContentPane(chartPanel);
    }

    private JFreeChart createChart() {
        double fixedPCO2 = 0.0004; // Example PCO2 in atm
        PCO2 pCO2 = new PCO2(fixedPCO2);

        XYSeries h2co3Series = new XYSeries("H2CO3");
        XYSeries hco3Series = new XYSeries("HCO3-");
        XYSeries co3Series = new XYSeries("CO3--");

        // Loop over pH values from 0 to 14
        for (double pHValue = 0.0; pHValue <= 14.0; pHValue += 0.1) {
            PH pH = new PH(pHValue);
            CarbonateSystem carbonateSystem = new CarbonateSystem(pCO2, pH);

            h2co3Series.add(pHValue, carbonateSystem.getH2CO3());
            hco3Series.add(pHValue, carbonateSystem.getHCO3());
            co3Series.add(pHValue, carbonateSystem.getCO3());
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(h2co3Series);
        dataset.addSeries(hco3Series);
        dataset.addSeries(co3Series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Concentrations of Carbonate Species vs pH",
                "pH",
                "Concentration (mol/L)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return chart;
    }

    public static void main(String[] args) {
        CarbonateSystemPlot chart = new CarbonateSystemPlot("Carbonate System");
        chart.pack();
        chart.setVisible(true);
    }
}
