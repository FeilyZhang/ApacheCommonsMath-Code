package tech.feily.dataanalysis.demo;

import java.util.Random;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class SummaryStatisticsDemo {

    
    public static void getDescriptiveStatistics(SummaryStatistics stats) {
        double geometricMean = stats.getGeometricMean();
        double mean = stats.getMean();
        double max = stats.getMax();
        double min = stats.getMin();
        double std = stats.getStandardDeviation();
        double populationVariance = stats.getPopulationVariance();
        double sampleVariance = stats.getVariance();
        double sum = stats.getSum();
        double n = stats.getN();
        double sumSq = stats.getSumsq();
        double hashCode = stats.hashCode();
        String string = stats.toString();
        System.out.println("geometricMean : "  + geometricMean + ", mean : " + mean + ", max : " + max);
        System.out.println("min : "  + min + ", std : " + std + ", populationVariance : " + populationVariance + ", sum : " + sum);
        System.out.println("sampleVariance : "  + sampleVariance + ", sumSq : " + sumSq + ", n : " + n );
        System.out.println("hashCode = " + hashCode + "\n" + string);
    }
    
    public static void getDescriptiveStatisticsStatisticalSummary(StatisticalSummary ss) {
        double mean = ss.getMean();
        double max = ss.getMax();
        double min = ss.getMin();
        double std = ss.getStandardDeviation();
        double variance = ss.getVariance();
        double sum = ss.getSum();
        double n = ss.getN();
        System.out.println("mean : " + mean + ", max : " + max + ", min : "  + min );
        System.out.println("std : " + std + ", sum : " + sum + ", variance : "  + variance );
        System.out.println("n : " + n);
        
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        double[] datas = new double[10];
        // First construct the original data.
        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(10);
        }
        SummaryStatistics stats = new SummaryStatistics();
        for (double value : datas) {
            stats.addValue(value);
        }
        getDescriptiveStatistics(stats);
        
        System.out.println("----------");
        
        SummaryStatistics stats1 = stats.copy();
        getDescriptiveStatistics(stats1);

        System.out.println("----------");
        
        SummaryStatistics stats2 = new SummaryStatistics();
        SummaryStatistics.copy(stats, stats2);
        getDescriptiveStatistics(stats2);

        System.out.println("----------");
        
        StatisticalSummary ss = stats.getSummary();
        getDescriptiveStatisticsStatisticalSummary(ss);
        
    }

}
