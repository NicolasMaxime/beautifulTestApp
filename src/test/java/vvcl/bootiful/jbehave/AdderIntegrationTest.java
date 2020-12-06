package vvcl.bootiful.jbehave;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.BeforeStories;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdderIntegrationTest extends SerenityStories {

    @BeforeStories
    public void init() {
        System.out.println("---------STARTING TEST--------------");
    }

}
