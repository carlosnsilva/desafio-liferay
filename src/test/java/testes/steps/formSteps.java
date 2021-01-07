package testes.steps;

import com.carlos.desafio.liferay.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.formPage;
import java.text.SimpleDateFormat;
import java.util.*;
import configUtils.configUtil;
import java.util.Date;
import static configUtils.configUtil.formataData;
import static configUtils.configUtil.aguardar;


public class formSteps {

    public formPage pageForm = new formPage();

    // Cenario 1
    @Given("Dado nome, data e testes")
    public void dado_nome_data_e_testes() {

        this.pageForm.iniciar();
    }

    @When("Quando preenchidos corretamente")
    public void quando_preenchidos_corretamente() {

        String nome = "Usuario_Teste";
        String data = formataData(new Date(),"DD/MM/YYYY");
        String campoTesting = "Por ser uma área incrivel.";

        pageForm.preencherFormulario(nome,data,campoTesting);
        aguardar(3000);

    }
    @Then("Entao validamos")
    public void entao_validamos() {

        String xpathMsg1 = ".//*[text()='Information sent']";
        String xpathMsg2 = ".//*[text()='Information sent successfully!']";
        Assert.assertNotEquals("https://forms.liferay.com/web/forms/shared/-/form/122548",pageForm.paginaAtual());

        Assert.assertEquals("Information sent",pageForm.buscaMensagemSucesso(xpathMsg1).getText());
        Assert.assertEquals("Information sent successfully!",pageForm.buscaMensagemSucesso(xpathMsg2).getText());

        this.pageForm.fechar();
    }





}
