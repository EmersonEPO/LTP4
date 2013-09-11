/*
 * Essa classe é apenas para testes!
 * 
 */
package br.edu.ifnmg.jpa.DomainModel;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author emerson
 */
public class ClasseTeste {
    public static void main(String[] args){
        
        //"Criando" Gerenciador de entidades
        EntityManager manager;
        EntityManagerFactory factory;
        //-----
        factory = Persistence.createEntityManagerFactory("Persistencia"); //Esse nome se encontra no arq persistencia.xml
        manager = factory.createEntityManager();
        
        //Inicio dos Testes
        
        //Aqui iniciei uma nova Transação
        EntityTransaction transacaoOne = manager.getTransaction();
        
        //Criando objeto e setando um valor
        TipoPessoa tipo = new TipoPessoa();
        tipo.setNomeTipo("Aluno");
        //Fim
        
        try{
            
            //Iniciando transacao
            transacaoOne.begin();
            
            //Persistindo os dados no banco
            manager.persist(tipo);
            
            //Se tudo ocorreu corretamente será dado um commit
            transacaoOne.commit();
            
        }catch(Exception ex){
            //Aqui acontecerá um rollback caso ocorra algum erro na transação
            transacaoOne.rollback();
            //Mensagem informando onde ocorreu o erro
            System.out.printf("Erro na PRIMEIRA transação LOCAL >> ClasseTeste - Linha 18");
        }
        
        /*NOTA : Agora que eu persistir no banco o tipo de pessoa posso dar sequencia ao restante dos dados*/
        
        //Aqui é preciso iniciar uma nova transação, já que uma vez feito um commit a transaçaõ termina
        //mudei o nome da variavel para não ter confusão, mas posso ultilizar o mesmo nome da primeira transação
        //Iniciando Transação
        EntityTransaction transacaoTwo = manager.getTransaction();
        
        try{
            //Iniciando transação
            transacaoTwo.begin();
            
            //Criando os Objetos
            Email email = new Email();
            Endereco endereco = new Endereco();
            Pessoa pessoa = new Pessoa();
            
            //Setando valores
            pessoa.setNomePessoa("Emerson Pereira");
            pessoa.setRgPessoa(1); //Apenas para efeito de testes
            pessoa.setCpfPessoa(2); //Apenas para efeito de testes
            pessoa.setDataNascimento(new Date()); //Apenas para efeito de testes
            
            //Setando tipo de Pessoa já persistido no banco
            pessoa.setTipo(tipo);
            
            //Setando Email
            email.setEndEmail("emerson@emerson");
            pessoa.addEmail(email);
            
            //Setando Endereço
            endereco.setRua("A");
            endereco.setNum(100);
            endereco.setBairro("Azul");
            pessoa.addEndereco(endereco);
            
            //Persistindo dados no banco
            manager.persist(pessoa);
            
            //Se tudo ocorreu corretamente será dado um commit
            transacaoTwo.commit();
            
            
        }catch(Exception ex){
            //Aqui acontecerá um rollback caso ocorra algum erro na transação
            transacaoTwo.rollback();
            //Mensagem informando onde ocorreu o erro
            System.out.printf("Erro na SEGUNDA transação LOCAL >> ClasseTeste - Linha 61");
        }
        //Fim dos Testes
        
    }
    
}
