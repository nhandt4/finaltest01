package finaltest01.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Booking {
    public static Target SEARCH_DESTINATION = Target.the("Destination field").locatedBy("//input[@id='ss']");
    public static Target RECOMMEND_OPTION = Target.the("Recommend option").locatedBy("(//li[@role='option'])[1]");
    public static Target SEARCH_BUTTON = Target.the("Search button").locatedBy("//button[@class='sb-searchbox__button ']");
    public static Target VISTOR = Target.the("Vistor TextArea").locatedBy("//label[@class='xp__input']");
    public static Target ADULT = Target.the("quantity of adult").locatedBy("//button[@aria-label=\"Increase number of Adults\"]");
    public static Target CHILDREN = Target.the("quantity of children").locatedBy("//button[@aria-label=\"Increase number of Children\"]");
    public static Target ROOM = Target.the("quantity of room").locatedBy("//button[@aria-label=\"Increase number of Rooms\"]");
    public static Target RESULT = Target.the("result").locatedBy("//div[@class='sr_header ']/h1");
    public static Target RESULT_LIST = Target.the("Item List").locatedBy("//a[@class='bui-link']");
//    public static Target RESULT_LIST = Target.the("Result List").locatedBy("//div[contains(@class,\"sr_item_new sr_item_default sr_property_block\")]");
}

