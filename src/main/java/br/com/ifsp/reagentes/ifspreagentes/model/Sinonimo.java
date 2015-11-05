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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;


/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "Sinonimos")
@ObjectTypeConverter(name = "booleanConverter",
        dataType = Integer.class,
        objectType = Boolean.class,
        conversionValues ={
        @ConversionValue(dataValue = "1", objectValue = "true"),
        @ConversionValue(dataValue = "0",objectValue = "false")},defaultObjectValue = "false")
public class Sinonimo implements Serializable{

    @EmbeddedId
    private SinonimoId id;
    @Convert("booleanConverter")
    @Column(name = "IsDefault")
    private Boolean isDefault;
    @OneToOne
    private Reagente reagente;

    public Reagente getReagente() {
        return reagente;
    }

    public void setReagente(Reagente reagente) {
        this.reagente = reagente;
    }

    
    
    public SinonimoId getId() {
        return id;
    }

    public void setId(SinonimoId id) {
        this.id = id;
    }
    
    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
    
    
}
