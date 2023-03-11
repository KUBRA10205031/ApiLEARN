package postRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import pojoDatas.CryptoCurrencyPojo;
import pojoDatas.CustomerInfoPojo;
import testData.BitPaceGetToken;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04 {
      /*

    !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!! --api doc url

    Given
        https://api-sandbox.bitpace.com/api/v1/auth/token adresine POST metodu  ile request atılıp token alınmalı.

       Kullanılacak Request Body: --- token almak için bu aşamaları geçmem lazım
            {
    "merchant_code":"20625123425",
    "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
}


    Token alındıktan sonra aşğaıdaki işlemlere geçebiliriz.
        https://api-sandbox.bitpace.com/api/v1/customer/deposit/address  -- bunlarıı test etmek için tokene ihtiyacım var

        **Alınan Token Headers ta Bearer Auth. olarak gçnderilecektir.**

    When
       Kullanıcı POST metodu ile request atar

       Kullanılacak Request Body:
        {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",
        "first_name":"",
        "last_name":"",
        "email":"drakeF@gmail.com"
    }
}
    Then
        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
        Expected message "Response Approved" içermeli



     */
     // https://api-sandbox.bitpace.com/api/v1/auth/token
    //customer deposit adress gerçekleştiriniz.


    String URL="https://api-sandbox.bitpace.com/api/v1/";
    public String token;

@Before
    public void postforToken(){
    //bu method işlemlerimi yapabilmek için token create eden methoddur.
    //SetURL
    String URLForToken=URL + "auth/token";

    //Set Req Body
    BitPaceGetToken bitPaceGetToken=new BitPaceGetToken();
    Map<String,String>reqBodyMap=bitPaceGetToken.reqTestDataBody();

    //Send a Request
    Response response = given().contentType(ContentType.JSON).
            body(reqBodyMap).//merch doe and password
            when().post(URLForToken);
    //System.out.println("REsponse ");
    //response.prettyPrint();

    //step 4 : Assertion
    //fakar bu casede ben 4.step de response dan token alacağım.

    JsonPath jsonPath=response.jsonPath();
    token = jsonPath.getString("data.token");
    //System.out.println("Tpken :"+token);


}
@Test
    public void createDepositWithPost(){
    //Set URL

    String URLforCreationDeposit= URL + "customer/deposit/address";

    //Step 2 :Set Request Body -->> dökümandan aldım
   /* Kullanılacak Request Body:
    {
        "cryptocurrency": "BTC",
            "customer": {
        "reference_id": "20625123425",
                "first_name":"",
                "last_name":"",
                "email":"drakeF@gmail.com"
    }
    }
*/

    CustomerInfoPojo customerInfoPojo=new CustomerInfoPojo("20625123425","","","drakeF@gmail.com");
    CryptoCurrencyPojo reqBody =new CryptoCurrencyPojo("BTC",customerInfoPojo);

    //Step 3 : Send A REquest

    Response response=given().
            contentType(ContentType.JSON).
            body(reqBody).
            when().
            header("Authorization","Bearer "+token).
            post(URLforCreationDeposit);
    System.out.println("RESPONSE:");
    response.prettyPrint();

    //Step 4 :ASEERTİON

    Map<String,Object>actualDataFromRESPONSE=response.as(HashMap.class);
    System.out.println("actualDataFromRESPONSE = " + actualDataFromRESPONSE);

    assertEquals("Response Approved",actualDataFromRESPONSE.get("message"));


}
//cucumber ile yapılacak
    //req body file ile yapılacak
}
