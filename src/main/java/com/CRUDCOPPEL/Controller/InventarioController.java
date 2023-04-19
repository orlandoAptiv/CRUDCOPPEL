//en esta clase estan los endpoints de inventario
package com.CRUDCOPPEL.Controller;

import com.CRUDCOPPEL.Model.InventarioModel;
import com.CRUDCOPPEL.Model.ServiceResponse;
import com.CRUDCOPPEL.Service.IFinventarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //agregar anotacion para indicar que es un restcontroller
@RequestMapping("api/sku") // agregar para poder ubicarlo
@CrossOrigin("*")// cualquier cliente puede llegar a consumir nuestro servicio

public class InventarioController {

    @Autowired
    private IFinventarioService ifinventarioservices;  //inyectar nuestro servicio

    @GetMapping("/list")
    public ResponseEntity<List<InventarioModel>> list() {
        var result = ifinventarioservices.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody InventarioModel SKU) {
        ServiceResponse response = new ServiceResponse();
        int result = ifinventarioservices.save(SKU);
        if(result ==1){  //evaluar si nos regreso 1 si existen datos, entonces decir que se guardo con exito
            response.setMessage("item saved with success");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody InventarioModel SKU) {
        ServiceResponse response = new ServiceResponse();
        int result = ifinventarioservices.save(SKU);
        if(result ==1){  //evaluar si nos regreso 1 si existen datos, entonces decir que se actualizo con exito
            response.setMessage("item update with success");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/delete/{sku}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int sku) {
        ServiceResponse response = new ServiceResponse();
        int result = ifinventarioservices.deleteBySKU(sku);
        if(result ==1){  //evaluar si nos regreso 1 si existen datos, entonces decir que se actualizo con exito
            response.setMessage("item removed with success");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
