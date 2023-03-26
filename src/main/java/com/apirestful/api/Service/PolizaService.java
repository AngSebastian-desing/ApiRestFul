package com.apirestful.api.Service;

import com.apirestful.api.Model.Poliza;
import com.apirestful.api.Repository.PolizaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class PolizaService {
    @Autowired
    private PolizaRepository polizaRepo;
    
    public List<Poliza> consulta(){
        return polizaRepo.findAll();
    }
    
    public Poliza consultaPoliza(Integer idPoliza){
      return polizaRepo.findById(idPoliza).get();
    }
    
    public void grabar(Poliza poliza){
        polizaRepo.save(poliza);
    }
    
    public Poliza actualizar(Poliza idPoliza){
      return polizaRepo.save(idPoliza);
    }
    
    public void eliminar(Integer poliza){
        polizaRepo.deleteById(poliza);
    }
    

}
