package com.CRUDCOPPEL.Repository;

import com.CRUDCOPPEL.Model.InventarioModel;
import java.util.List;

public interface IFinventarioRepository {

    public List<InventarioModel> findAll();

    public int save(InventarioModel SKU);

    public int update(InventarioModel SKU);

    public int deleteBySKU(int SKU);

}
