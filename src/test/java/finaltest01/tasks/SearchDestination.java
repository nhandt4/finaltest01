package finaltest01.tasks;


import finaltest01.ui.Booking;
import net.bytebuddy.asm.Advice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchDestination implements Task {
    private final String searchTerm;
    public SearchDestination(String searchTerm){
        this.searchTerm = searchTerm;
    }

    @Override
    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.searchTerm).into(Booking.SEARCH_DESTINATION),
                Click.on(Booking.RECOMMEND_OPTION)

        );

    }
    public static SearchDestination withKeyword(String keyword){
        return instrumented(SearchDestination.class, keyword);
    }
}
