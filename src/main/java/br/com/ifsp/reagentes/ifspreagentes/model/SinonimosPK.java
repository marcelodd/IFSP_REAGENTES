/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcelo
 */
@Embeddable
public class SinonimosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Reagente_Cas")
    private String reagenteCas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descricao")
    private String descricao;

    public SinonimosPK() {
    }

    public SinonimosPK(String reagenteCas, String descricao) {
        this.reagenteCas = reagenteCas;
        this.descricao = descricao;
    }

    public String getReagenteCas() {
        return reagenteCas;
    }

    public void setReagenteCas(String reagenteCas) {
        this.reagenteCas = reagenteCas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reagenteCas != null ? reagenteCas.hashCode() : 0);
        hash += (descricao != null ? descricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SinonimosPK)) {
            return false;
        }
        SinonimosPK other = (SinonimosPK) object;
        if ((this.reagenteCas == null && other.reagenteCas != null) || (this.reagenteCas != null && !this.reagenteCas.equals(other.reagenteCas))) {
            return false;
        }
        if ((this.descricao == null && other.descricao != null) || (this.descricao != null && !this.descricao.equals(other.descricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifsp.reagentes.ifspreagentes.dao.SinonimosPK[ reagenteCas=" + reagenteCas + ", descricao=" + descricao + " ]";
    }
    
}
