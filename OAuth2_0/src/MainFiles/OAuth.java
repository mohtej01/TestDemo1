package MainFiles;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class OAuth {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		String url="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
		String split1=url.split("code=")[1];
		String authCode=split1.split("&scope")[0];
		
		Response res=given().urlEncodingEnabled(false)
		
				
		.queryParams("code",authCode)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("state", "verifyfjdss")
		.queryParams("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").then()
		.extract().response();
		String r= res.toString();
		System.out.println(r);
		//JsonPath js=new JsonPath(r);
		//String accessToken=js.get("access_token").toString();
		//System.out.println(accessToken);
		//String response=given().
		//queryParam("access_token",accessToken)
		//.when().log().all()
		//.get("https://rahulshettyacademy.com/getCourse.php").asString();
		//System.out.println(response);
	}

}
