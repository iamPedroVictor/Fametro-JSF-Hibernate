/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edu.fametro.util;

import br.com.edu.fametro.dao.ProdutoDao;
import br.com.edu.fametro.entidade.Produto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author iampedrovictor
 */
public class Teste {
    public static void main(String[] args){
        Produto prod = new Produto();
        prod.setNome("Teste salvar e editar 2");
        prod.setPreco(500.55);
        prod.setEstoque(16);
        prod.setDataValidade(new Date());

        new ProdutoDao().SalvarOuEditar(prod);
        
    }
}
