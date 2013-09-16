/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class DAOGenerico<P> {
    protected EntityManager manager;
    private EntityManagerFactory factory;
    private Class pessoa;
            
    public DAOGenerico(Class p){
        factory = Persistence.createEntityManagerFactory("Persistencia");
        manager = factory.createEntityManager();
        pessoa = p;
    }
    
    
    public boolean Salvar(P obj){
        //Obter Transação
        EntityTransaction transacao = manager.getTransaction();
    
        try{
            //Iniciando transação
            transacao.begin();
            //Persistindo dados
            manager.persist(obj);
            //Se tudo ocorrer corretamente será efetuado um commit
            transacao.commit();
            //Retorna valor verdadeiro indicando que tudo ocorreu corretamente
            return true;
        }catch(Exception ex){
            //Se acontecer algum erro será efetuado um rollback
            transacao.rollback();
            //Retorna valor falso indicando que houve algum erro
            return false;
        }
        
    }
    
    public P Abrir(long id){
        
        try{
            //Persiste o objeto
            P obj = (P)manager.find(pessoa, id);
            
            //Retorna o objeto
            return obj;
        }catch(Exception ex){
            //Retorna objeto null
            return null;
        }
        
    }
    
    public boolean Excluir(P obj){
        //Obtem uma transação
        EntityTransaction transacao = manager.getTransaction();
        
        try{
            //Inicia transação
            transacao.begin();
            //Remove o objeto, Persiste...
            manager.remove(obj);
            //Se tudo ocorrer corretamente será feito um commit
            transacao.commit();
            //Por fim retorna verdadeiro   
            return true;
        
        }catch(Exception ex){
            //Caso ocorra algum problema, sera feito um rollback
            transacao.rollback();
            //Por fim retorna falso
            return false;
        }
        
    }
    
    
    
}
