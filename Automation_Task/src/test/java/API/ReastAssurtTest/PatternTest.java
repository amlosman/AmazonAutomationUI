package API.ReastAssurtTest;
import API.BaseForEachRequest.ReqPattern;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static io.restassured.RestAssured.given;
public class PatternTest {
    private static Response patternRes;
    @Test
    public static void LoginHappyScenarioTest()
    {
        patternRes = given()
                .spec(ReqPattern.patternReqSpecification())
                .body("{\n" +
                        "\"uername\": \"merchant@foodics.com\",\n" +
                        " \"password\": \"123456\"\n" +
                        "}\n").when()
                .post();

        patternRes.then()
                .log().body();
         patternRes.then()
                .spec(ReqPattern.respSpecification_Redirect_Valid());
    }
    @Test
    public static void LoginWithoutBodyTest()
    {
        patternRes = given()
                .spec(ReqPattern.patternReqSpecification())
                .body("{\n"+
                        "}\n")
                .when()
                .post();
        patternRes.then();


    }
    @Test
    public static void LoginWithoutUserNameTest()
    {
        patternRes = given()
                .spec(ReqPattern.patternReqSpecification())
                .body("{\n"+
                        "\"uername\": \"merchant@foodics.com\",\n" +
                        "}\n")
                .when()
                .post();
        patternRes.then();
    }
    @Test
    public static void LoginPasswordTest()
    {
        patternRes = given()
                .spec(ReqPattern.patternReqSpecification())
                .body("{\n"+
                        " \"password\": \"123456\"\n" +
                        "}\n")
                .when()
                .post();
        patternRes.then();
    }

}
