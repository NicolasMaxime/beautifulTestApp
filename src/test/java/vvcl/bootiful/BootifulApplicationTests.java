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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BootifulApplicationTests {

	@Test
	void testAdderAccumulate(){
		RequestSpecification dix = given().param("num", 10);
		RequestSpecification cinqcinq = given().param("num", 55);
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("10"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("20"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("30"));
		dix.post("/adder/accumulate").then().assertThat().body(equalTo("40"));
		cinqcinq.post("/adder/accumulate").then().assertThat().body(equalTo("95"));
		cinqcinq.post("/adder/accumulate").then().assertThat().body(equalTo("150"));
		when().get("/adder/current/").then().assertThat().body(equalTo("150"));
	}

	@Test
	void testAdderReset(){
		when().delete("/adder/reset/").then().assertThat().body(equalTo("0"));
	}

	@Test
	void contextLoads() {
	}

}
