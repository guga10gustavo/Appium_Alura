package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.ListaDeProdutosPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;

public class FeatureLogin {

    @Test
    public void nao_consigo_fazer_login_com_usuario_nao_cadastrado(){

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();

        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin =telaCadastro.Cadastrar("fran", "123", "123");
        telaLogin.buscarElementos();

        telaLogin = telaLogin.fazerLoginErrado("alex","123");

        Assert.assertEquals("Usuário ou senha inválidos",telaLogin.retornarMensagemErro());
    }

    @Test
    public void consigo_fazer_login_com_login_e_senha_validos() throws NoSuchElementException {

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();

        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin =telaCadastro.Cadastrar("gus", "123", "123");
        telaLogin.buscarElementos();

        ListaDeProdutosPageObject listaDePodutos = telaLogin.fazerLoginValido("gus","123");
        listaDePodutos.buscarElementos();
        telaLogin = listaDePodutos.deslogar();
        telaLogin.buscarElementos();


    }

}