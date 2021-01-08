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

    @When("Quando sao preenchidos corretamente")
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

        Assert.assertEquals("Information sent",pageForm.buscaMensagem(xpathMsg1).getText());
        Assert.assertEquals("Information sent successfully!",pageForm.buscaMensagem(xpathMsg2).getText());

        this.pageForm.fechar();
    }

    // Cenario 2
    @Given("Dado nome, data e testes vazios")
    public void dado_nome_data_e_testes_vazios() {
        this.pageForm.iniciar();
    }

    @When("Quando aperta o botao")
    public void Quando_aperta_o_botao() {

        pageForm.clicaBotaoConfirmar();
        aguardar(3000);


    }
    @Then("Entao validamos a mensagem de erro")
    public void entao_validamos_a_mensagem_de_erro() {
        String xpathMsgErro = ".//*[@class='form-feedback-item help-block']";
        String xpathPartyRock = ".//h4[contains(text(),\"Let's party rock\")]";

        Assert.assertEquals("This field is required.",pageForm.buscaMensagem(xpathMsgErro).getText());
        Assert.assertEquals("Let's party rock.",pageForm.buscaMensagem(xpathPartyRock).getText());

        this.pageForm.fechar();


    }

    //Cenario 3
    @Given("Dado nome, data corretos e testes vazio")
    public void dado_nome_data_corretos_e_testes_vazio() {
        this.pageForm.iniciar();

    }

    @When("Quando sao preenchidos")
    public void quando_sao_preenchidos() {
        String nome = "Usuario_Teste";
        String data = formataData(new Date(),"DD/MM/YYYY");
        String campoTesting = "";

        pageForm.preencherFormulario(nome, data,campoTesting);
        aguardar(3000);


    }

    //Cenario 4
    @Given("Dado nome, testes corretos e data vazio")
    public void dado_nome_testes_corretos_e_data_vazio() {
        this.pageForm.iniciar();
    }

    @When("Quando sao preenchidos os campos corretos")
    public void quando_sao_preenchidos_os_campos_corretos() {
        String nome = "Usuario_Teste";
        String data = "";
        String campoTesting = "Por ser uma área incrivel.";

        pageForm.preencherFormulario(nome, data,campoTesting);
        aguardar(3000);


    }

}
