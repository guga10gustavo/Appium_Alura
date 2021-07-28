package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase{

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;
    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmacaoID;
    private final By campoCastrarID;

    public CadastroPageObject(AppiumDriver driver){
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoCastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }
    @Override
    public void buscarElementos(){
        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmacaoID);
        botaoCadastrar = (MobileElement)driver.findElement(campoCastrarID);
    }

    private void preencherFormulario(String usuario,String senha,String confirmacao){
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario,String senha,String confirmacao) {
        preencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(this.driver);
    }

    public CadastroPageObject Cadastrar_Usuario_Ja_Existente(String usuario,String senha,String confirmacao) {
        preencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new CadastroPageObject(this.driver);
    }

    public String retornarMensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement)driver.findElement(erroID);
        return mensagemErro.getText();
    }
}
