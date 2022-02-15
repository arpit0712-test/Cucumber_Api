package org.apiTestingFramework.cuke.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties configProp = new Properties();
    public static FileInputStream fis;
    public static String client_Id;
    public static String secret_Key;
    public static Response response;

    public static void init() {
        try {
            fis = new FileInputStream("./src/test/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            configProp.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = configProp.getProperty("baseURI");
        client_Id = configProp.getProperty("client_id");
        secret_Key = configProp.getProperty("secretKey");
    }
}
