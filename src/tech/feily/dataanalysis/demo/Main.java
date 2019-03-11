package tech.feily.dataanalysis.demo;

import java.util.Random;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

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
        System.out.append(mean + "    " + std + "    " + median + "    " + stats.INFINITE_WINDOW + "    " + stats.getWindowSize());
        System.out.println("--------");
        SummaryStatistics ss = new SummaryStatistics();
        for (int i = 0; i < datas.length; i++) {
            ss.addValue(datas[i]);
        }
        double mean1 = stats.getMean();
        double std1 = stats.getStandardDeviation();
        double median1 = stats.getPercentile(50);
        System.out.println(mean1 + "    " + std1 + "    " + median1);
        double mean2 = StatUtils.mean(datas);
        double variance2 = StatUtils.variance(datas);
        double median2 = StatUtils.percentile(datas, 50);
        System.out.println(mean2 + "    " + variance2 + "    " + median2);
    }

}
