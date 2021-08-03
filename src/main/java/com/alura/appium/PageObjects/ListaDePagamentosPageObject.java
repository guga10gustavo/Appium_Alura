package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaDePagamentosPageObject extends PageObjectBase{

    private MobileElement botaoDeslogar;
    private MobileElement listacompagamentos;

    private final By campobotaoDeslogar;
    private final By listacompagamentosID;

    public ListaDePagamentosPageObject(AppiumDriver driver){
        super(driver);
        campobotaoDeslogar = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        listacompagamentosID = By.id("br.com.alura.aluraesporte:id/lista_pagamentos_recyclerview");
    }

    @Override
    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(campobotaoDeslogar));
        botaoDeslogar = (MobileElement) driver.findElement(campobotaoDeslogar);
        listacompagamentos = (MobileElement) driver.findElement(listacompagamentosID);


    }
    public boolean confimarPagamentoCompra(){
        MobileElement pg = listacompagamentos
                .findElementByXPath("//android.view.ViewGroup[@index='0']");
        return pg.isDisplayed();
    }

}
