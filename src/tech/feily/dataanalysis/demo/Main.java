package tech.feily.dataanalysis.demo;

import java.util.Random;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        double[] datas = new double[10];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(10);
        }
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for( int i = 0; i < datas.length; i++) {
            stats.addValue(datas[i]);
        }
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        System.out.append(mean + "    " + std + "    " + median);
    }

}
