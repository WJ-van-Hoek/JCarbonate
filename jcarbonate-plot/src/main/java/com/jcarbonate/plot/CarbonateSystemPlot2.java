package com.jcarbonate.plot;

import com.jcarbonate.logic.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

@SuppressWarnings("serial")
public class CarbonateSystemPlot2 extends ApplicationFrame {

    public CarbonateSystemPlot2(String title) {
        super(title);
        JFreeChart xylineChart = createChart();
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setBackgroundPaint(new Color(255, 228, 196));

        setContentPane(chartPanel);
    }

    private JFreeChart createChart() {
        XYSeries pco2Series = new XYSeries("PCO2");

        double fixedDIC = 0.0001; // Fixed DIC (you can adjust this value)

        // Loop over HCO3- values from 1e-8 to the fixed DIC value (in mol/L)
        for (double hco3Value = 1e-8; hco3Value <= fixedDIC; hco3Value *= 1.2) {
            // Using builders to create HCO3 and DIC instances
            HCO3 hco3 = HCO3.builder().value(hco3Value).build();
            DIC dic = DIC.builder().value(fixedDIC).build();            
            
            CarbonateSystem carbonateSystem = new CarbonateSystem(hco3, dic);

            pco2Series.add(hco3Value, carbonateSystem.getPCO2());
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pco2Series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "HCO3- concentration vs PCO2 ",
                "HCO3- Concentration (mol/L)",
                "PCO2 (atm)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return chart;
    }

    public static void main(String[] args) {
        CarbonateSystemPlot2 chart = new CarbonateSystemPlot2("Carbonate System");
        chart.pack();
        chart.setVisible(true);
    }
}
