package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.DetalhesDoProdutoPageObject;
import com.alura.appium.PageObjects.ListaDeProdutosPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeatureListaDeProdutos {

    @Test
    public void consigo_esolher_um_produto_para_comprar(){

        AppiumDriver driver = AppiumDiverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();

        CadastroPageObject telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin =telaCadastro.Cadastrar("gus", "123", "123");
        telaLogin.buscarElementos();

        ListaDeProdutosPageObject listaDePodutos = telaLogin.fazerLoginValido("gus","123");
        listaDePodutos.buscarElementos();

        DetalhesDoProdutoPageObject telaDetalhesProduto = listaDePodutos.escolherProduto("Camisa");
    }
}