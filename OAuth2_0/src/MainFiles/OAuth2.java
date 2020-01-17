package MainFiles;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class OAuth2 {



public static void main(String[] args) {

// TODO Auto-generated method stub
//String generateCode= "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss";
System.setProperty("webdriver.chrome.driver", "C://Users//mohtej01//Desktop//API Automation//chromedriver_win32//chromedriver.exe/");
WebDriver driver= new ChromeDriver();
driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss");


//String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvQExB17SAzvv9gClmnNjo0VBYYCSJZ6C1l6cl0-PdQKDEs57HpR23cipRsAlchppaXl6vBkRKnm0qUDJXdjO5SI&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
//String code="2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M";
//String partialcode=url.split("code=")[1];
//String code=partialcode.split("&scope")[0];
//System.out.println(code);

Response response =
                given() 
                .urlEncodingEnabled(false)
                 .queryParams("code","")
                   .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        .queryParams("grant_type", "authorization_code")
                         .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                         .queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
                         .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").then().extract().response();
String arg= response.asString();
System.out.println(arg);
JsonPath jsonPath = new JsonPath(arg);
String accessToken = jsonPath.getString("access_token");
    System.out.println(accessToken);
String r2=    given().contentType("application/json").
queryParams("access_token", accessToken)
.when()
           .get("https://rahulshettyacademy.com/getCourse.php").asString();
System.out.println(r2);
}



}

