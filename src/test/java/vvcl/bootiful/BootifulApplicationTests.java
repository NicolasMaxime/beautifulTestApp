package vvcl.bootiful;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class BootifulApplicationTests {

	@Test
	void testAdderService(){
		when().delete("/adder/reset/").then().assertThat().body(equalTo("0"));
		RequestSpecification dix = given().param("num", 10);
		RequestSpecification cinqcinq = given().param("num", 55);
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("10"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("20"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("30"));
		cinqcinq.post("/adder/").then().assertThat().body(equalTo("85"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("40"));
		cinqcinq.post("/adder/accumulate").then().assertThat().body(equalTo("95"));
		cinqcinq.post("/adder/accumulate").then().assertThat().body(equalTo("150"));
		when().get("/adder/current/").then().assertThat().body(equalTo("150"));
		cinqcinq.post("/adder/").then().assertThat().body(equalTo("205"));
		when().get("/adder/current/").then().assertThat().body(equalTo("150"));
	}

	@Test
	void contextLoads() {
	}

}
