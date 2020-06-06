package finaltest01.features.search;

import finaltest01.actions.ChooseDate;
import finaltest01.actions.VisitorBooking;
import finaltest01.questions.SearchResultListQuestion;
import finaltest01.tasks.SearchDestination;
import finaltest01.tasks.VerifyResult;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import finaltest01.tasks.OpenTheApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class BookingStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void search_booking() {

        LocalDate now = LocalDate.now();
        System.out.println(now);

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                SearchDestination.withKeyword("Phú Quốc"),
                ChooseDate.from(now.plusDays(7)).to(now.plusDays(10)),
                VisitorBooking.adults(4).child(3).room(2),
                VerifyResult.getItemList("Phú Quốc")

        );
        then(anna).should(seeThat("The number of matched rooms ", SearchResultListQuestion.getResultList(), equalTo("280")));

    }

}