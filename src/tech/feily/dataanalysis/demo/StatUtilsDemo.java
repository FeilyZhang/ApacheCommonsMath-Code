package tech.feily.dataanalysis.demo;

import java.util.Random;

import org.apache.commons.math3.stat.StatUtils;

public class StatUtilsDemo {

    public static void main(String[] args) {
        Random random = new Random();
        double[] datas = new double[10];
        // First construct the original data.
        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(10);
        }
        double geometricMean = StatUtils.geometricMean(datas, 0, datas.length);
        double max = StatUtils.max(datas);
        double min = StatUtils.min(datas);
        double mean = StatUtils.mean(datas);
        double quantile25 = StatUtils.percentile(datas, 25);
        double quantile50 = StatUtils.percentile(datas, 50);
        double quantile75 = StatUtils.percentile(datas, 75);
        double quantile100 = StatUtils.percentile(datas, 100);
        double sum = StatUtils.sum(datas);
        double sumSq = StatUtils.sumSq(datas);
        double populationVariance = StatUtils.populationVariance(datas);
        double variance = StatUtils.variance(datas);
        System.out.println("geometricMean : "  + geometricMean + ", mean : " + mean + ", max : " + max);
        System.out.println("min : "  + min + ", populationVariance : " + populationVariance + ", sum : "  + sum + ", sumSq : " + sumSq);
        System.out.println("variance : "  + variance + ", quantile25 : " + quantile25);
        System.out.println("quantile50 : "  + quantile50 + ", quantile75 : " + quantile75 + ", quantile100 : " + quantile100);
    }

}
