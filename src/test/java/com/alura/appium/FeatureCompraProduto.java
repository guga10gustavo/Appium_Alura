package com.alura.appium;

import com.alura.appium.PageObjects.*;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

public class FeatureCompraProduto {

    @Test
    public void preencher_campos_e_comprar_produto(){

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
        telaCompraProduto.adicionarNumeroDoCartao("123","456","12/34/56");

        ListaDeProdutosPageObject listaDeProdutos2 = telaCompraProduto.confirmarPagamento();
        listaDeProdutos2.buscarElementos();

        ListaDePagamentosPageObject telaListaPagamento=listaDeProdutos2.exibirListaPagamentos();
        telaListaPagamento.buscarElementos();

        Assert.assertTrue(telaListaPagamento.confimarPagamentoCompra());

    }
}