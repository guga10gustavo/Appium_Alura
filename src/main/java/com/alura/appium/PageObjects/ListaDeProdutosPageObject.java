package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class ListaDeProdutosPageObject extends PageObjectBase{

    private MobileElement botaoDeslogar;
    private MobileElement listaComProdutos;

    private final By campobotaoDeslogar;
    private final By campolistaComProdutos;

    public ListaDeProdutosPageObject(AppiumDriver driver){
        super(driver);
        campobotaoDeslogar = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
        campolistaComProdutos = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");

    }

    @Override
    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.presenceOfElementLocated(campolistaComProdutos));
        botaoDeslogar = (MobileElement) driver.findElement(campobotaoDeslogar);
        listaComProdutos = (MobileElement) driver.findElement(campolistaComProdutos);
    }

    public LoginPageObject deslogar() {

        botaoDeslogar.click();
        return new LoginPageObject(this.driver);
    }


    public DetalhesDoProdutoPageObject escolherProduto(String produto) {

        Map<String,Integer> p = new HashMap<>();
        p.put("Bola de futebol",0);
        p.put("Camisa",1);
        p.put("Chuteira",2);
        p.put("Bermuda",3);
        int index = p.get(produto);
//        MobileElement mercadoria = listaComProdutos
//                .findElementByXPath("//android.view.ViewGroup[@index='2']");
        MobileElement mercadoria = listaComProdutos
                .findElementByXPath("//android.view.ViewGroup[@index='"+index+"']");
        mercadoria.click();

        return new DetalhesDoProdutoPageObject(this.driver);
    }
}
