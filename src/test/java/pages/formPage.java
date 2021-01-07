package pages;

import com.carlos.desafio.liferay.PageObject;
import org.openqa.selenium.*;
import static configUtils.configUtil.aguardar;

public class formPage extends PageObject {

    public static final String URL_FORM = "https://forms.liferay.com/web/forms/shared/-/form/122548";

    public formPage() {
        super(null);
    }

    public void iniciar(){
        this.browser.navigate().to(URL_FORM);
    }

    public void fechar(){
        this.browser.quit();
    }

    public void preencherFormulario(String nome, String dataNascimento, String descricaoTeste){

        String xpathCampoNome = ".//input[@class='ddm-field-text form-control']";
        String xpathCampoData = ".//input[@class='form-control input-group-inset input-group-inset-after']";
        String xpathCampoTesting = ".//textarea[@class='ddm-field-text form-control']";
        String xpathBotao = ".//button[@type='submit']";
        String xpathData = "/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[4]";

        WebElement campoNome = browser.findElement(By.xpath(xpathCampoNome));
        WebElement campoData = browser.findElement(By.xpath(xpathCampoData));
        WebElement campoDescricaoTeste = browser.findElement(By.xpath(xpathCampoTesting));



        campoNome.sendKeys(nome);
        //campoData.sendKeys(dataNascimento);
        aguardar(2000);
        campoDescricaoTeste.sendKeys(descricaoTeste);
        aguardar(2000);
        click(xpathCampoData);
        click(xpathData);
        aguardar(2000);
        click(xpathBotao);

    }

    public void click(String xpath){
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
    }

    public String paginaAtual(){
        return browser.getCurrentUrl();
    }


    public WebElement buscaMensagemSucesso(String xpath){


        WebElement mensagemSucesso = browser.findElement(By.xpath(xpath));

        return mensagemSucesso;

    }






}
