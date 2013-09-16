/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DataAccess;

import br.edu.ifnmg.jpa.DomainModel.Professor;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author emerson
 */
public class ProfessorDAO extends DAOGenerico<Professor> {
    
    public ProfessorDAO(){
        super(Professor.class);
    }
    
    public List<Professor> BuscaProfessorPorNome(String nome){
        Query consulta = manager.createQuery("select p from Professor p where  nome = :p0");
        //Retorna consulta
        return consulta.setParameter("p0", nome).getResultList();
    }
    
    public List<Professor> ListaTodos(){
        Query consulta = manager.createQuery("select p from Professor p");
        //Retorna consulta
        return consulta.getResultList();
    
    
    }
    
}
