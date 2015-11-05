/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.testes;

import br.com.ifsp.reagentes.ifspreagentes.dao.ReagenteDao;
import br.com.ifsp.reagentes.ifspreagentes.model.Reagente;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;


/**
 *
 * @author Marcelo
 */
public class TesteReagente {
    
    public static void main(String[] args) throws SQLException{
         ReagenteDao dao = new ReagenteDao();
        for(int i = 0; i < 10;i++ ){
            byte[] e = "TESTE".getBytes();
            Blob b = new SerialBlob(e);
  
            Reagente r = new Reagente("Teste", "Formula", b);
                   
             dao.persist(r);
        }
    }
}
