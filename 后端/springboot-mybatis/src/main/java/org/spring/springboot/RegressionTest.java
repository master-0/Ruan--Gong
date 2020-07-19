package org.spring.springboot;

public class RegressionTest {
    private static String regression = "";
    private static String nullString = "";
    private static String regressionStr = "---RegressionTest---:";

    private RegressionTest() {
    }

    public static void RegressionTestBegin() {
        regression = regressionStr;
    }

    public static void RegressionTestEnd() {
        regression = nullString;
    }

    public static void setTestInfo(String info) {
        regression = regressionStr.substring(0, regressionStr.length() - 4) + info;
    }

    public static String Regression() {
        return regression;
    }
}
