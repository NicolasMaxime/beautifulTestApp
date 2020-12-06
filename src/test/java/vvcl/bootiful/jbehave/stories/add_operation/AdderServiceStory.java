package vvcl.bootiful.jbehave.stories.add_operation;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import vvcl.bootiful.steps.AdderServiceSteps;


public class AdderServiceStory {

    @Steps
    AdderServiceSteps adderServiceSteps;

    @Given("$base and $num : to init calculator")
    public void givenABaseAndAnAdder(int base, int adder) {
        adderServiceSteps.givenBaseAndAdder(base, adder);
    }

    @When("I add adder")
    public void whenIAddAdder() {
        adderServiceSteps.whenAdd();
    }

    @Then("I get an addition result")
    public void thenIGetTheSum() {
        adderServiceSteps.thenSummedUp();
    }
}
