/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="Pessoas")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    //Gera automaticamente os ID do ob
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //----
    //Continuando Mapeamento da classe
    @Column(name="nomePessoa", length=100) //Aqui com o length atribui-se um valor maximo de caracteres 
    private String nomePessoa;
    
    @Column(name="rgPessoa") 
    private int rgPessoa;
    
    @Column(name="cpfPessoa")
    private int cpfPessoa;
    
    //Para os atributos tipo DATE é preciso usar o @Temporal
    @Temporal(TemporalType.DATE)
    @Column(name="nascimentoPessoa")
    private Date dataNascimento;
    
    //Relaciomentos
    //Aqui temos um relacionamento N <Pessoas> PARA 1 <TiposPessoas>, 
    //ou seja, Pessoas depende de TiposPessoas
    @ManyToOne 
    private TipoPessoa tipo;
    
    //Um para muitos, onde sera criado uma tabela Pessoas_Email
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Cascateamento
    private List<Email> emails;
    
    //Um para muitos, onde sera criado uma tabela Pessoas_Enderecos
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Cascateamento
    private List<Endereco> enderecos;
    
    //Inicio Construtor
    public Pessoa(){
        nomePessoa = "vazio";
        rgPessoa = 0;
        cpfPessoa = 0;
        dataNascimento = new Date();
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
    }
    //Fim Construtor
    
    //Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(int rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public int getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(int cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    //Inicio Metodos para add e remover Email 
    public void addEmail(Email e){
        if(!emails.contains(e)){
            emails.add(e);
        }
    }
    //----
    public void removeEmail(Email e){
        if(emails.contains(e)){
            emails.remove(e);
        }
    }
    //Fim
    
    //Inicio Metodos para add e remover Endereço
    public void addEndereco(Endereco e){
        if(!enderecos.contains(e)){
            enderecos.add(e);
        }
    } 
    //----
    public void removeEndereco(Endereco e){
        if(enderecos.contains(e)){
            enderecos.remove(e);
        }
    }
    //Fim
    
    //----
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.jpa.DomainModel.Pessoa[ id=" + id + " ]";
    }
    
}
