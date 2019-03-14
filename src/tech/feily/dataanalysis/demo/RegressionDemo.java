package tech.feily.dataanalysis.demo;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class RegressionDemo {

    public static void main(String[] args) {
        SimpleRegression regression = new SimpleRegression();
        regression.addData(1d, 1d);
        regression.addData(2d, 2d);
        regression.addData(3d, 3d);
        System.out.println(regression.getIntercept());
        // displays intercept of regression line

        System.out.println(regression.getSlope());
        // displays slope of regression line

        System.out.println(regression.getSlopeStdErr());
        // displays slope standard error

        System.out.println(regression.getR());

        System.out.println(regression.predict(5));
    }

}
