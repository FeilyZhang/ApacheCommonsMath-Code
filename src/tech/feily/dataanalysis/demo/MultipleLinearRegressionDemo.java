package tech.feily.dataanalysis.demo;

import java.util.Arrays;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class MultipleLinearRegressionDemo {

    public static void main(String[] args) {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[]{11.0, 12.0, 13.0, 14.0, 15.0, 16.0};
        double[][] x = new double[6][];
        x[0] = new double[]{0, 0, 0, 0, 0};
        x[1] = new double[]{2.0, 0, 0, 0, 0};
        x[2] = new double[]{0, 3.0, 0, 0, 0};
        x[3] = new double[]{0, 0, 4.0, 0, 0};
        x[4] = new double[]{0, 0, 0, 5.0, 0};
        x[5] = new double[]{0, 0, 0, 0, 6.0};          
        regression.newSampleData(y, x);
        double[] beta = regression.estimateRegressionParameters(); 
        System.out.println(Arrays.toString(beta));
        double result = 0;
        for (int i = 0; i < beta.length; i++) {
            if (i == 0) {
                result += beta[i];
            } else {
                result += beta[i] * x[0][i - 1];
            }
        }
        System.out.println(result);
        
        double regressandVariance = regression.estimateRegressandVariance();

        double rSquared = regression.calculateRSquared();

        double sigma = regression.estimateRegressionStandardError();
        System.out.println(regressandVariance);
        System.out.println(rSquared);
        System.out.println(sigma);
    }

}
