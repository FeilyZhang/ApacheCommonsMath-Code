package tech.feily.dataanalysis.demo;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStatisticsDemo {

    public static void getDescriptiveStatistics(DescriptiveStatistics stats) {
        double geometricMean = stats.getGeometricMean();
        double mean = stats.getMean();
        double max = stats.getMax();
        double min = stats.getMin();
        double std = stats.getStandardDeviation();
        double populationVariance = stats.getPopulationVariance();
        double sampleVariance = stats.getVariance();
        double quantile25 = stats.getPercentile(25);
        double quantile50 = stats.getPercentile(50);
        double quantile75 = stats.getPercentile(75);
        double quantile100 = stats.getPercentile(100);
        double sum = stats.getSum();
        double sumSq = stats.getSumsq();
        double windowSize = stats.getWindowSize();
        double n = stats.getN();
        double[] sortedValues = stats.getSortedValues();
        double[] values = stats.getValues();
        String string = stats.toString();
        System.out.println("geometricMean : "  + geometricMean + ", mean : " + mean + ", max : " + max);
        System.out.println("min : "  + min + ", std : " + std + ", populationVariance : " + populationVariance);
        System.out.println("sampleVariance : "  + sampleVariance + ", quantile25 : " + quantile25);
        System.out.println("quantile50 : "  + quantile50 + ", quantile75 : " + quantile75 + ", quantile100" + quantile100);
        System.out.println("sum : "  + sum + ", sumSq : " + sumSq + ", windowSize : " + windowSize);
        System.out.println("n : "  + n + ", sortedValues : " + Arrays.toString(sortedValues) + ", values : " + Arrays.toString(values));
        System.out.println(string);
        
    }
    public static void main(String[] args) {
        Random random = new Random();
        double[] datas = new double[10];
        // First construct the original data.
        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(10);
        }
        // Then add the raw data to the Class 'DescriptiveStatistics'.
        // DescriptiveStatistics(double[] initialDoubleArray).
        DescriptiveStatistics stats = new DescriptiveStatistics(datas);
        // DescriptiveStatistics(DescriptiveStatistics original).
        DescriptiveStatistics stats1 = new DescriptiveStatistics(stats);
        // Obtaining descriptive statistics.
        getDescriptiveStatistics(stats);
        getDescriptiveStatistics(stats1);
        // Getting Data Set Data Based on Index by 'getElement' Method.
        for (int i = 0; i < 10; i++) {
            System.out.print(stats.getElement(i) + " ");
        }
        System.out.println("\n");
        // DescriptiveStatistics(int window), Only 5 additional data are allowed, 
        // The rest of the data could not be added..
        DescriptiveStatistics stats2 = new DescriptiveStatistics(5);
        for (int i = 0; i < datas.length; i++) {
            stats2.addValue(datas[i]);
        }
        getDescriptiveStatistics(stats2);
        // Adjust data set cap.
        stats2.setWindowSize(10);
        // Then continue to add the remaining data.
        // 
        for (int i = 0; i < 5; i++) {
            stats2.addValue(datas[i]);
        }
        getDescriptiveStatistics(stats2);
        
        DescriptiveStatistics sta = stats.copy();
        getDescriptiveStatistics(sta);
        DescriptiveStatistics sta1 = new DescriptiveStatistics();
        DescriptiveStatistics.copy(sta, sta1);
        getDescriptiveStatistics(sta1);
    }

}
