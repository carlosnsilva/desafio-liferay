package testes;

import com.carlos.desafio.liferay.PageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.formPage;

public class teste {

    private formPage paginaFormulario;


    @BeforeEach
    public void beforeEach(){
        this.paginaFormulario = new formPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaFormulario.fechar();
    }

    @Test
    public void TestandoAbrirOBrowser(){
        System.out.println("Deu certo");
    }


}
