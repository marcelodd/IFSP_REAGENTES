/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "menssagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menssagens.findAll", query = "SELECT m FROM Menssagens m"),
    @NamedQuery(name = "Menssagens.findById", query = "SELECT m FROM Menssagens m WHERE m.id = :id"),
    @NamedQuery(name = "Menssagens.findByAssunto", query = "SELECT m FROM Menssagens m WHERE m.assunto = :assunto"),
    @NamedQuery(name = "Menssagens.findByRemetente", query = "SELECT m FROM Menssagens m WHERE m.remetente = :remetente"),
    @NamedQuery(name = "Menssagens.findByEmail", query = "SELECT m FROM Menssagens m WHERE m.email = :email"),
    @NamedQuery(name = "Menssagens.findByTexto", query = "SELECT m FROM Menssagens m WHERE m.texto = :texto")})
public class Menssagens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Assunto")
    private String assunto;
    @Size(max = 50)
    @Column(name = "Remetente")
    private String remetente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "Email")
    private String email;
    @Size(max = 300)
    @Column(name = "Texto")
    private String texto;

    public Menssagens() {
    }

    public Menssagens(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        if (!(object instanceof Menssagens)) {
            return false;
        }
        Menssagens other = (Menssagens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifsp.reagentes.ifspreagentes.dao.Menssagens[ id=" + id + " ]";
    }
    
}
