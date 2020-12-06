package vvcl.bootiful.steps;

import net.thucydides.core.annotations.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import vvcl.bootiful.AdderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ContextConfiguration(classes = AdderService.class)
public class AdderServiceSteps {

    @Autowired
    private AdderService adderService;

    private int givenNumber;
    private int base;
    private int sum;

    public void givenBaseAndAdder(int base, int adder) {
        this.base = base;
        adderService.baseNum(base);
        this.givenNumber = adder;
    }

    public void whenAdd() {
        sum = adderService.add(givenNumber);
    }

    public void thenSummedUp() {
        assertEquals(base + givenNumber, sum);
    }
    public void thenWrong() {
        assertNotEquals(base + givenNumber, sum);
    }
    public void whenAccumulate() {
        sum = adderService.accumulate(givenNumber);
    }
}
