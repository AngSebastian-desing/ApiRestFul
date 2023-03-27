package com.apirestful.api.Controller;

import com.apirestful.api.Model.Poliza;
import com.apirestful.api.Service.PolizaService;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(PolizaController.class);
    
   // Logger logger = LoggerFactory.getLogger(PolizaController.class);

    @Autowired
    private PolizaService polizaService;         
    
    @GetMapping("/polizas")
    public List<Poliza> consulta(){
        logger.debug("Se consultaron todas las polizas");
        return polizaService.consulta();
    }
    
    @GetMapping("/polizas/{id}")
    public ResponseEntity<Poliza> consultarPoliza(@PathVariable Integer id){        
        try{
            Poliza poliza = polizaService.consultaPoliza(id);
            logger.debug("Se consulto la poliza " + id);
            return new ResponseEntity<>(poliza,HttpStatus.OK);
        }catch(Exception ex){
            logger.error("Ha ocurrido un error al intentar consultar la póliza: "+id+" "+ ex.toString(),ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/polizas")
     public ResponseEntity<Void> grabar(@RequestBody Poliza poliza) throws SQLException{
        polizaService.generarPoliza(poliza.getSku(), poliza.getCantidadPoliza(), poliza.getEmpleadoGenero());
        return ResponseEntity.ok().build();
     }
    
    /*@PostMapping("/polizas")
    public void grabar(@RequestBody Poliza poliza){
        
        //inventarioModel.restarProducto(polizaModel.getSku());
        polizaService.grabar(poliza);
        //return new ResponseEntity<>("Se guardo correctamente",HttpStatus.OK);
    }
    */
    
    @PutMapping("/polizas/{id}")
    public ResponseEntity<Poliza> actualizar(@RequestBody Poliza poliza, @PathVariable Integer id){
        try{
            Poliza polizaActual = polizaService.consultaPoliza(id);
            
            polizaActual.setEmpleadoGenero(poliza.getEmpleadoGenero());
            polizaActual.setSku(poliza.getSku());
            polizaActual.setCantidadPoliza(poliza.getCantidadPoliza());           
            polizaActual.setFecha(poliza.getFecha());
            polizaService.actualizar(polizaActual);
            logger.debug("Se actualizo la poliza " + id);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }catch(Exception ex){
            logger.error("Ha ocurrido un error al intentar actualizar la póliza: "+id+" "+ ex.toString(),ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/polizas/{id}")
    public void eliminar( @PathVariable Integer id){
        polizaService.eliminar(id);
    }
    
}
