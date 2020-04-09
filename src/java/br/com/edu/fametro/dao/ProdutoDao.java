package br.com.edu.fametro.dao;

import br.com.edu.fametro.util.HibernateUtil;
import org.hibernate.Session;
import br.com.edu.fametro.entidade.Produto;
import java.util.List;
import org.hibernate.Query;

public class ProdutoDao {
    
    Session session;

    public ProdutoDao() {
        session = HibernateUtil.getSessionFactory().openSession();
        
    }
    
    public void SalvarOuEditar(Produto produto){
        if(produto.getId() == null){
            Salvar(produto);
        }else{
            Alterar(produto);
        }
    }
    
    public void Salvar(Produto produto){
        session.getTransaction().begin();
        session.save(produto);
        session.getTransaction().commit();
        session.close();
    }
    
    public void Alterar(Produto produto){
        session.getTransaction().begin();
        session.update(produto);
        session.getTransaction().commit();
        session.close();
    }
    
    public void Excluir(Produto produto){
        session.getTransaction().begin();
        session.delete(produto);
        session.getTransaction().commit();
        session.close();
    }
    
    public Produto buscarProduto(int codigoId){
        Query sql = session.createQuery("from Produto where id = :codigoId");
        sql.setInteger("codigoId", codigoId);
        Produto prod = (Produto)sql.uniqueResult();
        return prod;
    }
    
    public List<Produto> Listar(){
        Query sql = session.createQuery("from Produto");
        return sql.list();
    }
    
}
