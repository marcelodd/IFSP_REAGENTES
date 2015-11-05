/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.model;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "Reagentes")
public class Reagente implements Serializable{
    @Id
    private String cas;
    @Column(name = "Fomula")
    private String formula;
    @Column(name = "Info")
    private Blob info;

    public Reagente() {
    }

    public Reagente(String cas, String formula, Blob info) {
        this.cas = cas;
        this.formula = formula;
        this.info = info;
    }

    
    
    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Blob getInfo() {
        return info;
    }

    public void setInfo(Blob info) {
        this.info = info;
    }

    
    
    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }
}
