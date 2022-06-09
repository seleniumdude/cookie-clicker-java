package pages;
import lombok.Getter;
import selenium.WebDriverHandler;

@Getter
public class PageObjectManager {

private final CommonPage commonPage;
private final Homepage homepage;
private final WebDriverHandler webDriverHandler;

public PageObjectManager (CommonPage commonPage, Homepage homepage, WebDriverHandler webDriverHandler){
    this.commonPage = commonPage;
    this.webDriverHandler = webDriverHandler;
    this.homepage = homepage;
    }

}
