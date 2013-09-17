/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DataAccess;

import br.edu.ifnmg.jpa.DomainModel.TipoPessoa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class TipoPessoaDAO extends DAOGenerico<TipoPessoa> {
    
    public TipoPessoaDAO(){
        super(TipoPessoa.class);
    }
    
     public List<TipoPessoa> BuscaTipoPorNome(String nome){
        Query consulta = manager.createQuery("select t from TipoPessoa t where  nome = :p0");
        //Retorna consulta
        return consulta.setParameter("p0", nome).getResultList();
    }
    
    public List<TipoPessoa> ListaTodos(){
        Query consulta = manager.createQuery("select t from TipoPessoa p");
        //Retorna consulta
        return consulta.getResultList();
    }
    
    
}
