/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "sinonimos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinonimos.findAll", query = "SELECT s FROM Sinonimos s"),
    @NamedQuery(name = "Sinonimos.findByReagenteCas", query = "SELECT s FROM Sinonimos s WHERE s.sinonimosPK.reagenteCas = :reagenteCas"),
    @NamedQuery(name = "Sinonimos.findByDescricao", query = "SELECT s FROM Sinonimos s WHERE s.sinonimosPK.descricao = :descricao"),
    @NamedQuery(name = "Sinonimos.findByIsDefault", query = "SELECT s FROM Sinonimos s WHERE s.isDefault = :isDefault")})
public class Sinonimos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SinonimosPK sinonimosPK;
    @Column(name = "IsDefault")
    private Integer isDefault;
    @JoinColumn(name = "Reagente_Cas", referencedColumnName = "Cas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reagentes reagentes;

    public Sinonimos() {
    }

    public Sinonimos(SinonimosPK sinonimosPK) {
        this.sinonimosPK = sinonimosPK;
    }

    public Sinonimos(String reagenteCas, String descricao) {
        this.sinonimosPK = new SinonimosPK(reagenteCas, descricao);
    }

    public SinonimosPK getSinonimosPK() {
        return sinonimosPK;
    }

    public void setSinonimosPK(SinonimosPK sinonimosPK) {
        this.sinonimosPK = sinonimosPK;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Reagentes getReagentes() {
        return reagentes;
    }

    public void setReagentes(Reagentes reagentes) {
        this.reagentes = reagentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinonimosPK != null ? sinonimosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinonimos)) {
            return false;
        }
        Sinonimos other = (Sinonimos) object;
        if ((this.sinonimosPK == null && other.sinonimosPK != null) || (this.sinonimosPK != null && !this.sinonimosPK.equals(other.sinonimosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifsp.reagentes.ifspreagentes.dao.Sinonimos[ sinonimosPK=" + sinonimosPK + " ]";
    }
    
}
