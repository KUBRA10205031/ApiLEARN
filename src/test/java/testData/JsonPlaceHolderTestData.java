package testData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {


   public static HashMap<String, Object> expectedData;

   public HashMap setUpDataTodos() {

      expectedData = new HashMap<>();
      expectedData.put("StatusCode",200);
      expectedData.put("Server","cloudflare");
      expectedData.put("userId",1);
      expectedData.put("id",2.0);
      expectedData.put("title","quis ut nam facilis et officia qui");
      expectedData.put("completed",false);


      return expectedData;
   }


   public static HashMap<String, Object> expectedDatajson;


   public HashMap setUpDataJson() {

      expectedDatajson = new HashMap<>();
      expectedDatajson.put("userId",10);
      expectedDatajson.put("id",198);
      expectedDatajson.put("title","quis eius est sint explicabo");
      expectedDatajson.put("completed",true);


      return expectedDatajson;


}

public HashMap<String,Object> setUpForPutRequest(){
      expectedData =new HashMap<>();
      expectedData.put("userId",1);
      expectedData.put("title","CW FSQA API Tutorial");
      expectedData.put("completed",true);
      return expectedData;
}
}



