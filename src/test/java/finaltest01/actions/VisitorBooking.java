package finaltest01.actions;

import finaltest01.ui.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Action;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VisitorBooking implements Interaction {
    private int room_qty;
    private int adult_qty;
    private int children_qty;
    public VisitorBooking(int adult_qty, int children_qty, int room_qty){
        this.room_qty = room_qty;
        this.adult_qty = adult_qty;
        this.children_qty = children_qty;
    }
    public static VisitorBookingBuilder adults(int adult_qty){
        return new VisitorBookingBuilder(adult_qty);
    }
    @Override
    @Step("{0} books #room_qty rooms for #adult_qty adults and #children_qty childrens")
    public <T extends Actor> void performAs(T t) {
        Booking.VISTOR.resolveFor(t).click();
        WaitUntil.the(Booking.ADULT, isVisible()).forNoMoreThan(10).seconds();
        for(int i = 0; i<adult_qty-2; i++)
            Booking.ADULT.resolveFor(t).click();
        WaitUntil.the(Booking.CHILDREN, isVisible()).forNoMoreThan(10).seconds();
        for(int i = 0; i<children_qty; i++)
            Booking.CHILDREN.resolveFor(t).click();
        WaitUntil.the(Booking.ROOM, isVisible()).forNoMoreThan(10).seconds();
        for(int i = 0; i<room_qty-1; i++)
            Booking.ROOM.resolveFor(t).click();
        Booking.SEARCH_BUTTON.resolveFor(t).click();
    }
    public static class VisitorBookingBuilder{
        private int adult_qty;
        private int children_qty;
        public VisitorBookingBuilder(int adult_qty){
            this.adult_qty = adult_qty;
        }
        public VisitorBookingBuilder child(int children_qty){
            this.children_qty = children_qty;
            return this;
        }
        public Interaction room(int room_qty){
            return instrumented(VisitorBooking.class, this.adult_qty, this.children_qty, room_qty);
        }

    }
}
