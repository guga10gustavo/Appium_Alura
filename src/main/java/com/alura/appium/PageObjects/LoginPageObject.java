package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase{

    private MobileElement botaoCadastro;
    private MobileElement nomeUsuarioID;
    private MobileElement senha;
    private MobileElement botaoLogin;
    private MobileElement msgErroLogin;

    private final By campobotaoCadastroID;
    private final By camponomeUsuarioID;
    private final By camposenha;
    private final By campobotaoLogin;
    private final By erroLogin;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        campobotaoCadastroID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        camponomeUsuarioID = By.id("br.com.alura.aluraesporte:id/input_usuario");
        camposenha = By.id("br.com.alura.aluraesporte:id/input_senha");
        campobotaoLogin = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        erroLogin = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");

    }
    @Override
    public void buscarElementos(){

        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(campobotaoCadastroID));
        nomeUsuarioID = (MobileElement)driver.findElement(camponomeUsuarioID);
        senha = (MobileElement)driver.findElement(camposenha);
        botaoLogin = (MobileElement)driver.findElement(campobotaoLogin);
        botaoCadastro = (MobileElement)driver.findElement(campobotaoCadastroID);
    }

    public CadastroPageObject irParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }


    public LoginPageObject fazerLoginErrado(String usuario, String pass) {

        nomeUsuarioID.setValue(usuario);
        senha.setValue(pass);
        botaoLogin.click();
        return new LoginPageObject(this.driver);
    }

    public String retornarMensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroLogin));

        msgErroLogin = (MobileElement)driver.findElement(erroLogin);
        return msgErroLogin.getText();

    }

    public ListaDeProdutosPageObject fazerLoginValido(String usuario, String pass) {

        nomeUsuarioID.setValue(usuario);
        senha.setValue(pass);
        botaoLogin.click();

        return new ListaDeProdutosPageObject(this.driver);
    }
}
