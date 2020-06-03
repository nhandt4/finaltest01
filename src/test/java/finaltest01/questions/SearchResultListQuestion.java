package finaltest01.questions;

import finaltest01.ui.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class SearchResultListQuestion implements Question<String>{
    @Override
    public String answeredBy(Actor actor) {
        String result = Text.of(Booking.RESULT).viewedBy(actor).asString();
        String substr = result.substring(10, result.length());
        String[] results = substr.split(" ");
        return  results[0];
    }
    public static Question<String> getResultList() {
        return new SearchResultListQuestion();
    }


}
