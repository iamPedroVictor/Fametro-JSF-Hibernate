package br.com.edu.fametro.beans;

import br.com.edu.fametro.dao.ProdutoDao;
import br.com.edu.fametro.entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean {

    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    
    private final ProdutoDao produtoDao = new ProdutoDao();
    
    public void Salvar(){
        produtoDao.SalvarOuEditar(produto);
    }
    
    public void Alterar(){
        produtoDao.Alterar(produto);
    }
    
    public void Editar(Produto prod){
        this.produto = prod;
    }
    
    public void Excluir(){
        produtoDao.Excluir(produto);
    }
    
    public void listar(){
        produtos = produtoDao.Listar();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
