package apipracticedt;

import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import techproedenglish01.techproedenglish01api.TestBaseDt;

public class Practice04 extends TestBaseDt {
	/*
	 1)Create base url in TestBase Class for "http://api.openweathermap.org"
	 2)Set the URL to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul&&appid="2cb6803f295233aa579843d9e45599f2"
	   by using pathParams() and queryParams() methods
	 3)Use JSONObject Class or MAP to store expected values
	   Expected Values are: "coord.lon" ==> 28.98f   
	                        "coord.lat" ==> 41.04f
	                        "weather.description" ==> "broken clouds"
	                        "base" ==> "stations"
	                        "main.feels_like" ==> 301.81f
	                        "visibility" ==> 10000
	                        "clouds.all" ==> 57
	                        "sys.country" ==> "TR"
	                        "timezone" ==> 10800
	                        "name" ==> "Istanbul"
	 4)Create GET Request to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul&&appid="2cb6803f295233aa579843d9e45599f2"
	   Print the response body on the console
	 5)Assert Status Code and Response Body details by using body() method
	 6)Assert Response Body details by using assertEquals() method    
	 7)Assert Response Body details by using Soft Assert                   
	*/
	
	@Test
	public void getPractice() {
	   //2)Set the URL to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul&&appid="2cb6803f295233aa579843d9e45599f2"
	   //by using pathParams() and queryParams() methods
		spec05.pathParams("data", "data",
				          "id", 2.5,
				          "weather", "weather").
		       queryParams("q", "Istanbul",
		    		       "appid", "2cb6803f295233aa579843d9e45599f2");
		//3)Use JSONObject Class or MAP to store expected values
		JSONObject expectedData = new JSONObject();
		expectedData.put("coord.lon", 28.98f);
		expectedData.put("coord.lat", 41.04f);
		expectedData.put("weather.description", "scattered clouds");
		expectedData.put("base", "stations");
		expectedData.put("main.feels_like", 291.43);
		expectedData.put("visibility", 10000);
		expectedData.put("clouds.all", 40);
		expectedData.put("sys.country", "TR");
		expectedData.put("timezone", 10800);
		expectedData.put("name", "Istanbul");
		
		//4)Create GET Request
		Response response = given().spec(spec05).when().get("/{data}/{id}/{weather}");
		response.prettyPrint();
		
		//5)Hard Assertion with body()
		response.
		      then().
		      assertThat().
		      statusCode(200).
		      body("coord.lon", equalTo(expectedData.getFloat("coord.lon")),
		    	   "coord.lat", equalTo(expectedData.getFloat("coord.lat")),
		    	   "weather[0].description", equalTo(expectedData.getString("weather.description")),
		    	   "base", equalTo(expectedData.getString("base")),
		    	   //"main.feels_like", equalTo(expectedData.getFloat("main.feels_like")),
		    	   "visibility",equalTo(expectedData.getInt("visibility")),
		    	   "clouds.all", equalTo(expectedData.getInt("clouds.all")),
		    	   "sys.country",equalTo(expectedData.getString("sys.country")),
		    	   "timezone", equalTo(expectedData.getInt("timezone")),
		    	   "name", equalTo(expectedData.getString("name")));
		
		//6)Hard Assertion by using assertEquals(), assertTrue(), assertFalse() ==> Homework
		
		//7)Soft Assertion 
		JsonPath json = response.jsonPath();
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getFloat("coord.lon"), expectedData.getFloat("coord.lon"));
		softAssert.assertEquals(json.getFloat("coord.lat"), expectedData.getFloat("coord.lat"));
		softAssert.assertEquals(json.getString("weather[0].description"), expectedData.getString("weather.description"));
		//softAssert.assertEquals(json.getFloat("main.feels_like"), expectedData.getFloat("main.feels_like"));
		softAssert.assertEquals(json.getInt("visibility"), expectedData.getInt("visibility"));
		softAssert.assertEquals(json.getInt("clouds.all"), expectedData.getInt("clouds.all"));
		softAssert.assertEquals(json.getString("sys.country"), expectedData.getString("sys.country"));
		softAssert.assertEquals(json.getInt("timezone"), expectedData.getInt("timezone"));
		softAssert.assertEquals(json.getString("name"), expectedData.getString("name"));
		
		softAssert.assertAll();
		
		
		//Install JENKINS to your local computer

	}

}
