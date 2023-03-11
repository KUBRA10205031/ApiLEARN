package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
/*


    /*hocanın notu :
        Bizler bu zamana kadar sizler ile birlikte POSTMAN üzerinde farklı doc. sahip olan
        çeşitli API lere request attık.
        REq atarken HTTP methodların da GET, POST; PUT, PATCH and DELETE methoslarınınkullandık.



        Bizler markete genle olarak POSTMAN i bir otomasyon toolu olarak değil manule test tool u olarka
        kullanıyoruz. Fakat dersler de işlediğimiz üsere PSTAMN ile test otomasyonu yapabiliyoruz.

        API testlerimiz bundan sonra REstAssured Lib. kullanrak yapacğaız.


        TEST leri yapabiliyor olmak içn sizlerin bir doc. ihtiyacı vardır.
        Biz test eng. bu doc. göre API leri nasıl kullanacağımız veya nasıl test edeceğimizi öğreniriz.

        Ve doc. lara göre çeşitli seneryoalr oluşturabiliriz. Tıpkı ne gibi?
        Selenium Web UI teslteri koştuğumuz gibi.
 */
    /*
    bizler bu zaman kadar postman üzerinden çeşitli api lere farklı dök. sahip olan çeşitli api 'lere request attık
    atarken http methodlarından
    get , post , put , patc and delete meethodlarını kullandık
    bizler markette genel olarak postmanı bir otomasyonu toolu olarak değil manuel test toolu olarak kullanıyoruz
    fakat derslerde işlediğimiz
    üzere postman ile test otomasyonu yapabiliyoruz
    apı testlerimizi bundan sonra restAssured Lib. kullanarak yapacağız.
    testleri yapabiliyor olmak için bir dök. ihtiyacı vardır  biz test engineer olarak bu apı leri nasıl kullanacağımız
    ve ya
    nasıl test edeceğimizi öğreniriz
    dökümanlara göre çeşitli senoryalar oluşturabiliriz. tıpkı ne gibi selenium  ve uı testleri koştuğumuz gibi.

    test case neden yazıyor

    --> expected result test caseden alıyorum selenium(web),uı,apı(response),mobile (androıd,ıphone)--> farketmez

    --- Actual result response den alacağım.

    Gherkin Language:
    keywords:

    Given --> testin yapılabilmesi için ön hazırlık ,ön şart
    When --> Action --> gerçekleştirilecek eylemler
    Then --> Assertion için kullanıyoruz
    And --> öncesinde kullanılan keywordun etkisini hala devam ettiğini bizlere gösterir.

     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */

    @Test  //--> bu main method gibi

    public void get01(){
       /*

       4 tane adımımız vardır:

       1) url'i tanımlamam lazım url 'i set etmem lazım

       2) Expected data'ları tanımlamam lazım.Expected dataları set etmem lazım
       Expected datalar test case 'den dökümantosyanlardan alınır.(çeşitli methodlar alınacak ileride şu an için bu adım ignore edilecektir.)

       3) Request gönder.

       4) Assertion işlemi yapılır.

        */

        //Step 1 :url set ediniz:(https://restful-booker.herokuapp.com/booking/7)

        String URL = "https://restful-booker.herokuapp.com/booking/7";

        //Step 2: expected data'lara set et.(ignore edilmişyit bu ders için)

        //Step 3: Request gönder
        Response response =given().
                    when().
                    get(URL);
        System.out.println("RESPONSE: ");
        response.prettyPrint(); // prettyprint() sout gibidir.

       //Step :4 Assertion işlemleri

        //Test 1:Status code ,----> 200
        response.then().assertThat().statusCode(200);//200 test case 'den alınmıştır.

       // Test 2: Content type
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().contentType(ContentType.JSON);

        //Test 3: Status Line
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        //Status code 'u konsola nasıl yazdırabiliriz.

        System.out.println("Status code:"+response.getStatusCode());

        //Content type'ı konsola nasıl yazdırbiliriz.
        System.out.println("Content Type :" +response.getContentType());

        //Status lıne'ı nasıl yazdırabilirim
        System.out.println("Status line:"+response.getStatusLine());

        //Response Time'ı nasıl yazdırabiilirim
        System.out.println("Response Time:"+response.getTime());

        //HEADERS'ı konsola nasıl yazdırabilirim.
        System.out.println("Headers:"+response.getHeaders());


    }











}
