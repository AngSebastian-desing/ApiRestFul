package com.apirestful.api.Service;

import com.apirestful.api.Model.Poliza;
import com.apirestful.api.Repository.PolizaRepository;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class PolizaService {
    @Autowired
    private PolizaRepository polizaRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
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
    
    public int generarPoliza(Integer v_sku, int v_cantidad, int v_empleado_genero) throws SQLException {
        String sqlCallFunction = "{call generar_poliza(?, ?, ?, ?, ?)}";
        CallableStatement cs = jdbcTemplate.getDataSource().getConnection().prepareCall(sqlCallFunction);

        cs.setInt(1, v_sku);
        cs.setInt(2, v_cantidad);
        cs.setInt(3, v_empleado_genero);
        cs.registerOutParameter(4, Types.INTEGER); // estado
        cs.registerOutParameter(5, Types.VARCHAR); // mensaje

        cs.execute();

        int estado = cs.getInt(4);
        String mensaje = cs.getString(5);

        if (estado == 1) {
            // la operación fue exitosa
            System.out.println(mensaje);
        } else {
            // la operación falló
            System.out.println(mensaje);
        }
        
        return estado;
    }
    

}
