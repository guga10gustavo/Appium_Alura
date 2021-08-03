package com.alura.appium;

import com.alura.appium.AppiumDiverConfig;
import com.alura.appium.PageObjects.*;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

public class FeatureDetalhesDoProduto {

    @Test
    public void escolho_o_produto_para_comprar(){

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
        telaDetalhesProduto.buscarElementos();

        CompraProdutoPageObject telaCompraProduto = telaDetalhesProduto.irParaCompraDoProduto();
        telaCompraProduto.buscarElementos();
        Assert.assertTrue(telaCompraProduto.estaPaginaDeCompra());


    }
}