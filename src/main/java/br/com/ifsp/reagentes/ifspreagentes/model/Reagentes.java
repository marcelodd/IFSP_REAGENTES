/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "reagentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reagentes.findAll", query = "SELECT r FROM Reagentes r"),
    @NamedQuery(name = "Reagentes.findByCas", query = "SELECT r FROM Reagentes r WHERE r.cas = :cas"),
    @NamedQuery(name = "Reagentes.findByFormula", query = "SELECT r FROM Reagentes r WHERE r.formula = :formula")})
public class Reagentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Cas")
    private String cas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Formula")
    private String formula;
    @Lob
    @Column(name = "Info")
    private byte[] info;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reagentes")
    private Collection<Sinonimos> sinonimosCollection;

    public Reagentes() {
    }

    public Reagentes(String cas) {
        this.cas = cas;
    }

    public Reagentes(String cas, String formula) {
        this.cas = cas;
        this.formula = formula;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

    @XmlTransient
    public Collection<Sinonimos> getSinonimosCollection() {
        return sinonimosCollection;
    }

    public void setSinonimosCollection(Collection<Sinonimos> sinonimosCollection) {
        this.sinonimosCollection = sinonimosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cas != null ? cas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reagentes)) {
            return false;
        }
        Reagentes other = (Reagentes) object;
        if ((this.cas == null && other.cas != null) || (this.cas != null && !this.cas.equals(other.cas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifsp.reagentes.ifspreagentes.dao.Reagentes[ cas=" + cas + " ]";
    }
    
}
