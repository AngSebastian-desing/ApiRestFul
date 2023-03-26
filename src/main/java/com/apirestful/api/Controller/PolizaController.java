package com.apirestful.api.Controller;

import com.apirestful.api.Model.Poliza;
import com.apirestful.api.Service.PolizaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angel
 */
@RestController
public class PolizaController {
    
    @Autowired
    private PolizaService polizaService;
    
    @GetMapping("/polizas")
    public List<Poliza> consulta(){
        return polizaService.consulta();
    }
    
    @GetMapping("/polizas/{id}")
    public ResponseEntity<Poliza> consultarPoliza(@PathVariable Integer id){        
        try{
           Poliza poliza = polizaService.consultaPoliza(id);
            return new ResponseEntity<>(poliza,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/polizas")
    public void grabar(@RequestBody Poliza poliza){
        polizaService.grabar(poliza);
    }
    
    @PutMapping("/polizas/{id}")
    public ResponseEntity<Poliza> actualizar(@RequestBody Poliza poliza, @PathVariable Integer id){
        try{
            Poliza polizaActual = polizaService.consultaPoliza(id);
            
            polizaActual.setEmpleadoGenero(poliza.getEmpleadoGenero());
            polizaActual.setSku(poliza.getSku());
            polizaActual.setCantidadPoliza(poliza.getCantidadPoliza());           
            polizaActual.setFecha(poliza.getFecha());
            polizaService.actualizar(polizaActual);

            return new ResponseEntity<>(HttpStatus.OK);
            
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/polizas/{id}")
    public void eliminar( @PathVariable Integer id){
        polizaService.eliminar(id);
    }
    
}
