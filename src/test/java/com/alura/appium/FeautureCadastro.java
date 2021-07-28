package com.alura.appium;


import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;


public class FeautureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();

        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaCadastro.Cadastrar("buffon", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.retornarMensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();

        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin =telaCadastro.Cadastrar("messi", "123", "123");
        telaLogin.buscarElementos();

    }

    @Test
    public void nao_consigo_cadastrar_dois_usuarios_com_o_mesmo_login() throws NoSuchElementException{

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin1 = new LoginPageObject(driver);
        telaLogin1.buscarElementos();

        CadastroPageObject telaCadastro1 = telaLogin1.irParaTelaDeCadastro();
        telaCadastro1.buscarElementos();

        LoginPageObject telaLogin2 =telaCadastro1.Cadastrar("gus", "123", "123");
        telaLogin2.buscarElementos();

        CadastroPageObject telaCadastro2 = telaLogin2.irParaTelaDeCadastro();
        telaCadastro2.buscarElementos();
        telaCadastro2 = telaCadastro2.Cadastrar_Usuario_Ja_Existente("gus", "123", "123");

        Assert.assertEquals("Usuario já Cadastrado", telaCadastro2.retornarMensagemErro());
        driver.navigate().back();

    }

    @Test
    public void consigo_cadastrar_dois_usuarios_diferentes_com_a_mesma_senha() throws NoSuchElementException{

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin1 = new LoginPageObject(driver);
        telaLogin1.buscarElementos();

        CadastroPageObject telaCadastro1 = telaLogin1.irParaTelaDeCadastro();
        telaCadastro1.buscarElementos();

        LoginPageObject telaLogin2 =telaCadastro1.Cadastrar("alex", "123", "123");
        telaLogin2.buscarElementos();

        CadastroPageObject telaCadastro2 = telaLogin2.irParaTelaDeCadastro();
        telaCadastro2.buscarElementos();
        LoginPageObject telaLogin3 = telaCadastro2.Cadastrar("fran", "123", "123");

        telaLogin3.buscarElementos();
    }

}
