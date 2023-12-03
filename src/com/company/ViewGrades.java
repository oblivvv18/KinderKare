package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.sql.*;

public class ViewGrades extends JFrame {
    private static Watermark vsrcode;

    public ViewGrades(String title) {
        super(title);

        CategoryDataset dataset = createDataset(); //container
        JFreeChart chart = createChart(dataset); //chart itself


        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);

    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset grades = new DefaultCategoryDataset();

        try {
            Watermark vsrcode = View.getSRCode();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");
            String query = "SELECT srcode, activity1, activity2, activity3, activity4, test1, test2 FROM grades where srcode = ?";
            PreparedStatement viewStatement = connection.prepareStatement(query);
            viewStatement.setString(1, View.getSRCode().getText());
            ResultSet resultSet = viewStatement.executeQuery();

            while (resultSet.next()) {
                int srcode = resultSet.getInt("srcode");
                grades.addValue(resultSet.getInt("activity1"), "Activity 1", String.valueOf(srcode));
                grades.addValue(resultSet.getInt("activity2"), "Activity 2", String.valueOf(srcode));
                grades.addValue(resultSet.getInt("activity3"), "Activity 3", String.valueOf(srcode));
                grades.addValue(resultSet.getInt("activity4"), "Activity 4", String.valueOf(srcode));
                grades.addValue(resultSet.getInt("test1"), "Test 1", String.valueOf(srcode));
                grades.addValue(resultSet.getInt("test2"), "Test 2", String.valueOf(srcode));

            }


            resultSet.close();
            viewStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Student Grades",
                "SR Code",
                "Grade (%)",
                dataset,
                PlotOrientation.VERTICAL, // Specify orientation
                true,
                true,
                false
        );
    }
}