package finaltest01.actions;

import finaltest01.ui.Booking;
import jnr.ffi.annotations.In;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseDate implements Interaction {
    private LocalDate startTime;
    private LocalDate endTime;

    public ChooseDate(LocalDate startTime, LocalDate endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    @Step("{0} books a room from #startTime to #endTime")
    public <T extends Actor> void performAs(T t) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Target START_TIME = Target.the("Start time").locatedBy("//td[@data-date='"+dtf.format(this.startTime)+"']");
        Target END_TIME = Target.the("End time").locatedBy("//td[@data-date='"+dtf.format(this.endTime)+"']");
        t.attemptsTo(
                WaitUntil.the(START_TIME, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(START_TIME),
                WaitUntil.the(END_TIME, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(END_TIME)
        );

    }
    public static ChooseDateBuilder from(LocalDate startTime){
        return new ChooseDateBuilder(startTime);
    }
    public static class ChooseDateBuilder{
        private LocalDate startTime;
        public ChooseDateBuilder(LocalDate startTime){
            this.startTime=startTime;
        }
        public Interaction to(LocalDate endTime){
            return instrumented(ChooseDate.class, this.startTime, endTime);
        }
    }
}
