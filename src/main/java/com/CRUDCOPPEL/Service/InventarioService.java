
package com.CRUDCOPPEL.Service;

import com.CRUDCOPPEL.Model.InventarioModel;
import com.CRUDCOPPEL.Repository.IFinventarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //indicamos que esta clase es un servicio que despues nos permite inyectarlo al controller
public class InventarioService implements  IFinventarioService{

    @Autowired
    private IFinventarioRepository ifinventariorepository; //invocar repositorio como una variable
    
    @Override
    public List<InventarioModel> findAll() {
        List<InventarioModel> list; // retorna todo el listado de la base de datos
        try {
            list  =  ifinventariorepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public int save(InventarioModel SKU) {
       int row;
        try {
            row  =  ifinventariorepository.save(SKU);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int update(InventarioModel SKU) {
         int row;
        try {
            row  =  ifinventariorepository.update(SKU);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int deleteBySKU(int SKU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
