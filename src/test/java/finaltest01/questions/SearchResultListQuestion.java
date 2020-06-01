package finaltest01.questions;

import finaltest01.ui.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;

import java.util.List;

public class SearchResultListQuestion implements Question<String>{
    private String keyword;
    @Override
    public String answeredBy(Actor actor) {
        String s = Text.of(Booking.RESULT).viewedBy(actor).asString();
        System.out.println(s);
       return Value.of(Booking.RESULT).viewedBy(actor).asString();
    }



    public static Question<String> getResultList() {
        return new SearchResultListQuestion();
    }


}
