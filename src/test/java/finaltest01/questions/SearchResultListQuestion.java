package finaltest01.questions;

import finaltest01.ui.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class SearchResultListQuestion implements Question {
    private static String keyword;
    public static String result;
    @Override
    public Object answeredBy(Actor actor) {
        SearchResultListQuestion.result = Text.of(Booking.RESULT)
                .viewedBy(actor).value();
        System.out.println(result);
        return result;
    }

//    public List<String> answeredBy(Actor actor) {
//        result = TextContent.of(Booking.RESULT_LIST)
//                .viewedBy(actor)
//                .asList();
//        return result;
//    }
    public static Question<String> TextofSearchResults(String keyword) {
        SearchResultListQuestion.keyword = keyword;
        return new SearchResultListQuestion();
    }

}
