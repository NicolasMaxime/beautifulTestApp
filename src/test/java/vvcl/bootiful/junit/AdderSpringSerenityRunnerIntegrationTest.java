package vvcl.bootiful.junit;

import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import vvcl.bootiful.steps.AdderServiceSteps;

import java.util.Random;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(locations = "classpath:adder-beans.xml")
public class AdderSpringSerenityRunnerIntegrationTest {

    @Steps
    private AdderServiceSteps adderSteps;

    @Value("#{props['adder']}")
    private int adder;

    @Test
    public void givenNumber_whenAdd_thenSummedUp() {
        Random rand = new Random();
        adderSteps.givenBaseAndAdder(rand.nextInt(20), adder);
        adderSteps.whenAdd();
        adderSteps.thenSummedUp();
    }
}
