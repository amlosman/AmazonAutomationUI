package API.BaseForEachRequest;

import FileWrappers.ReadFromPropertiesFile;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqPattern {
    public static RequestSpecification patternReqSpecification()  {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();

        reqBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");
        reqBuilder.addHeader("Accept", "*/*");
        reqBuilder.addHeader("Connection", "keep-alive");
        reqBuilder.addHeader("User-Agent", "PostmanRuntime/7.28.4");
        reqBuilder.setBaseUri(ReadFromPropertiesFile.getValue("APILoginURL"));
        return reqBuilder.build();
    }
    public static ResponseSpecification respSpecification_Redirect_Valid() {
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode(302);
        return resBuilder.build();
    }
}
