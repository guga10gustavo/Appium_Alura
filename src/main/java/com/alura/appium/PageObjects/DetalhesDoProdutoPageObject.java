package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class DetalhesDoProdutoPageObject extends PageObjectBase{

    private MobileElement botaoComprar;
    private MobileElement botaoDeslogar;

    private final By campobotaoComprar;
    private final By campobotaoDeslogar;

    public DetalhesDoProdutoPageObject(AppiumDriver driver){
        super(driver);
        campobotaoComprar = By.id("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
        campobotaoDeslogar = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
    }

    @Override
    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(campobotaoComprar));
        botaoDeslogar = (MobileElement) driver.findElement(campobotaoDeslogar);
        botaoComprar = (MobileElement) driver.findElement(campobotaoComprar);

    }

    public boolean estaPaginaDeDetalhes(){
        return botaoComprar.isDisplayed();
    }

    public CompraProdutoPageObject irParaCompraDoProduto(){
        botaoComprar.click();
        return new CompraProdutoPageObject(this.driver);
    }

}
