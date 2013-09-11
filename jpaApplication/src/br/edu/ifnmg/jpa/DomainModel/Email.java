/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jpa.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author emerson
 */
@Entity
@Table(name="Emails")
public class Email implements Serializable {
    //Inicio Mapeamento
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gera ID automatico
    private Long id;

    @Column(name="enderecoEmail", length=100)//Aqui com o length atribui-se um valor maximo de caracteres 
    private String endEmail;
    //Fim Mapeamento
    
    //Inicio construtor
    public Email(String endEmail) {
        this.endEmail = endEmail;
    }
    
    public Email() {
        this.endEmail = "vazio";
    }
    //Fim
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndEmail() {
        return endEmail;
    }

    public void setEndEmail(String endEmail) {
        this.endEmail = endEmail;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.jpa.DomainModel.Email[ id=" + id + " ]";
    }
    
}
