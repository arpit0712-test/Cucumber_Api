package org.apiTestingFramework.cuke.apis;

import org.apiTestingFramework.cuke.pojo.Orders;
import org.apiTestingFramework.cuke.pojo.PurchaseUnits;
import org.apiTestingFramework.cuke.base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class OrderApi extends BaseTest {
    static String orderId;

    public static String getAccessToken() {
        String access_Token = given().param("grant_type", "client_credentials")
                .auth()
                .preemptive()
                .basic(client_Id, secret_Key)
                .post("/v1/oauth2/token").jsonPath().get("access_token").toString();
        return access_Token;
    }

    public static Response createOrder(String currencyCode,String currencyValue) {
        ArrayList<PurchaseUnits> purchase_units = new ArrayList<PurchaseUnits>();
        purchase_units.add(new PurchaseUnits(currencyCode, currencyValue));
        Orders order = new Orders("CAPTURE", purchase_units);
        Response response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(getAccessToken())
                .body(order)
                .post("/v2/checkout/orders");
        orderId = response.jsonPath().get("id").toString();

        return response;
    }

    public static Response getOrderDetails() {

        System.out.println("Order id is : " + orderId);
        Response response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(getAccessToken())
                .get("/v2/checkout/orders" + "/" + orderId);
        response.prettyPrint();


        return response;
    }

}
