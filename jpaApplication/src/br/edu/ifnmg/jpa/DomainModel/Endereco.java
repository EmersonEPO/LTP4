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
@Table(name="Enderecos")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    //Inicio Mapeamento
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gera Id automatico
    private Long id;

    @Column(name="rua", length=100) //Aqui com o length atribui-se um valor maximo de caracteres 
    private String rua;
    
    @Column(name="num")
    private int num;
    
    @Column(name="bairro", length=100)
    private String bairro;
    //Fim mapeamento

   
    
    //Inicio Construtor
     public Endereco(String rua, int num, String bairro) {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
    }
    public Endereco() {
        this.rua = "vazio";
        this.num = 0;
        this.bairro = "vazio";
    }
    //Fim
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.jpa.DomainModel.Endereco[ id=" + id + " ]";
    }
    
}
