/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DataAccess;

import br.edu.ifnmg.jpa.DomainModel.Aluno;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author emerson
 */

public class AlunoDAO extends DAOGenerico<Aluno> {
    
    public AlunoDAO(){
        super(Aluno.class);
    }
    
    public List<Aluno> BuscarAlunoPorNome(String nome){
        Query consulta = manager.createQuery("select a from Aluno a where  nome = :p0");
        //Retorna consulta
        return consulta.setParameter("p0", nome).getResultList();
    }
    
    public List<Aluno> ListaTodos(){
        Query consulta = manager.createQuery("select a from Aluno a");
        //Retorna consulta
        return consulta.getResultList();
    }
    
}
