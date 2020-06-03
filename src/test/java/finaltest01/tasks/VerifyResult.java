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
    private static String result;
    public VerifyResult(String keyword, String result){
        this.keyword = keyword;
        this.result = result;
    }

    @Override
    @Step("{0} see #result matched with destination is #keyword in the list of result")
    public <T extends Actor> void performAs(T t) {
        result = Text.of(Booking.RESULT).viewedBy(t).asString();
        System.out.println(result);

//        t.attemptsTo(
//                Ensure.thatTheSetOf(Booking.RESULT_LIST).allMatch(TheMatchingElement.containsText(keyword))
//        );


    }
    public static Interaction getItemList(String keyword){
        return instrumented(VerifyResult.class, keyword);
    }

}
