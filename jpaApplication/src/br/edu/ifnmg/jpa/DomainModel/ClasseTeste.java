/*
 * Essa classe é apenas para testes!
 * 
 */
package br.edu.ifnmg.jpa.DomainModel;

import br.edu.ifnmg.jpa.DataAccess.AlunoDAO;
import br.edu.ifnmg.jpa.DataAccess.DAOGenerico;
import br.edu.ifnmg.jpa.DataAccess.TipoPessoaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author emerson
 */
public class ClasseTeste {
    public static void main(String[] args){
          
        //Criando objeto e setando um valor
        
        TipoPessoa tipo = new TipoPessoa();
        tipo.setNomeTipo("Aluno");
        //Fim
       
        try{
            //Iniciando DAO
            TipoPessoaDAO daoTipo = new TipoPessoaDAO();
        
            //Persistindo dados
            daoTipo.Salvar(tipo);
            
        }catch(Exception ex){
            System.out.printf("Erro ClasseTeste - Prox. Linha 23");
        }
        
        
        //NOTA : Agora que eu persistir no banco o tipo de pessoa posso dar 
        //sequencia ao restante dos dados
       
        try{
            //Iniciando DAO
            AlunoDAO daoAluno = new AlunoDAO();
            
            //Criando os Objetos
            Email email = new Email();
            Endereco endereco = new Endereco();
            Aluno aluno = new Aluno();
            
            //Setando valores
            aluno.setNomePessoa("Emerson II");
            aluno.setRgPessoa(11111); //Apenas para efeito de testes
            aluno.setCpfPessoa(22222); //Apenas para efeito de testes
            aluno.setDataNascimento(new Date()); //Apenas para efeito de testes
            aluno.setMatricula("IF2012");
            
            //Setando tipo de Pessoa já persistido no banco
            aluno.setTipo(tipo);
            
            //Setando Email
            email.setEndEmail("emerson@info.com.br");
            aluno.addEmail(email);
            
            //Setando Endereço
            endereco.setRua("B1");
            endereco.setNum(150);
            endereco.setBairro("Azul");
            aluno.addEndereco(endereco);
            
            daoAluno.Salvar(aluno);
           
        }catch(Exception ex){
            //Mensagem informando onde ocorreu o erro
            System.out.printf("Erro ClasseTeste - Prox. Linha 40");
        }
        
        
    
        try{
            AlunoDAO dao = new AlunoDAO();
            
            List<Aluno> listar = dao.ListaTodos();
        
            JOptionPane.showMessageDialog(null, listar);
            
        }catch(Exception ex){
        
        }
        //Fim dos Testes  
    }
    
}
