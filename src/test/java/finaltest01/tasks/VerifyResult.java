package finaltest01.tasks;

import finaltest01.questions.SearchResultListQuestion;
import finaltest01.ui.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;
import net.serenitybdd.screenplay.ensure.web.TheMatchingElement;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Action;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerifyResult implements Interaction {
    private final String keyword;
    public VerifyResult(String keyword){
        this.keyword = keyword;
    }

    @Override
    @Step("{0} see results matched with destination is #keyword in the list of result")
    public <T extends Actor> void performAs(T t) {


        t.attemptsTo(
                Ensure.thatTheSetOf(Booking.RESULT_LIST).allMatch(TheMatchingElement.containsText(keyword))
        );


    }
    public static Interaction getItemList(String keyword){
        return instrumented(VerifyResult.class, keyword);
    }

}
