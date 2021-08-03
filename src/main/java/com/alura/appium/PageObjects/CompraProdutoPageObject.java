package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompraProdutoPageObject extends PageObjectBase{

    private MobileElement botaoComfirmarPagamento;
    private MobileElement botaoDeslogar;
    private MobileElement campoCartao;
    private MobileElement campoValidade;
    private MobileElement campoCVC;
    private MobileElement preco;

    private final By campobotaoComfirmarPagamento;
    private final By campobotaoDeslogar;
    private final By campoCartaoID;
    private final By campoValidadeID;
    private final By campoCVCID;
    private final By precoID;

    protected CompraProdutoPageObject(AppiumDriver driver) {
        super(driver);
        campobotaoComfirmarPagamento = By.id("br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento");
        campobotaoDeslogar = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        campoCartaoID = By.id("br.com.alura.aluraesporte:id/pagamento_numero_cartao");
        campoValidadeID = By.id("br.com.alura.aluraesporte:id/pagamento_data_validade");
        campoCVCID = By.id("br.com.alura.aluraesporte:id/pagamento_cvc");
        precoID = By.id("br.com.alura.aluraesporte:id/pagamento_preco");
    }

    @Override
    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(campobotaoComfirmarPagamento));
        botaoComfirmarPagamento = (MobileElement) driver.findElement(campobotaoComfirmarPagamento);
        botaoDeslogar = (MobileElement) driver.findElement(campobotaoDeslogar);
        preco = (MobileElement) driver.findElement(precoID);
    }

    public void adicionarNumeroDoCartao(String numero, String cvv, String validade) {
        campoCartao = (MobileElement) driver.findElement(campoCartaoID).findElement(By.xpath("//android.widget.EditText"));
        campoValidade = (MobileElement) driver.findElement(campoValidadeID).findElement(By.xpath("//android.widget.EditText"));
        campoCVC = (MobileElement) driver.findElement(campoCVCID).findElement(By.xpath("//android.widget.EditText"));
        campoCartao.setValue(numero);
        campoValidade.setValue(validade);
        campoCVC.setValue(cvv);
    }

    public ListaDeProdutosPageObject confirmarPagamento(){
        botaoComfirmarPagamento.click();
        return new ListaDeProdutosPageObject(this.driver);
    }

    public boolean estaPaginaDeCompra(){
        return botaoComfirmarPagamento.isDisplayed();
    }
}
