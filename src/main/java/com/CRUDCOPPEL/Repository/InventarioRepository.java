package com.CRUDCOPPEL.Repository;

import com.CRUDCOPPEL.Model.InventarioModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository // indicamos que esta clase es un repositorio que esta accediendo a la base de datos
public class InventarioRepository implements IFinventarioRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate; //inyectar para poder realizar las consultas a la BD
    
    @Override
    public List<InventarioModel> findAll() {
        String SQL = "select SKU,Nombre,Cantidad from Inventario";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(InventarioModel.class)); //BeanPropertyRowMapper propiedad de jdbctemplate para hacer el mapping de todos los atributos del modelo
    }

    @Override
    public int save(InventarioModel SKU) {
        String SQL = "insert into inventario values(?,?,?)";
       return  jdbcTemplate.update(SQL, new Object[]{SKU.getSKU(),SKU.getNombre(),SKU.getCantidad()});
    
    }

    @Override
    public int update(InventarioModel SKU) {
         String SQL = "update inventario set Nombre=?, Cantidad=? where SKU=?";
       return  jdbcTemplate.update(SQL, new Object[]{SKU.getNombre(),SKU.getCantidad(),SKU.getSKU()});
    
    }

    @Override
    public int deleteBySKU(int SKU) {
        String SQL="delete from inventario where SKU=?";
        return  jdbcTemplate.update(SQL, new Object[]{SKU});
         
    }
   
}




