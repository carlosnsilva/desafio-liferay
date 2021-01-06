package pages;

import com.carlos.desafio.liferay.PageObject;
import org.openqa.selenium.*;

public class formPage extends PageObject {
    public static final String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    public formPage() {
        super(null);
        this.browser.navigate().to(URL_FORM);
    }


    public void fechar(){
        this.browser.quit();

    }
}
