package com.apirestful.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author angel
 */
@Entity
@Table (name = "polizas")
public class Poliza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPoliza ;    
    private Integer empleadoGenero ;    
    private Integer sku;
    private Integer cantidadPoliza;
    private Date Fecha;


    public Integer getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Integer idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Integer getEmpleadoGenero() {
        return empleadoGenero;
    }

    public void setEmpleadoGenero(Integer empleadoGenero) {
        this.empleadoGenero = empleadoGenero;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getCantidadPoliza() {
        return cantidadPoliza;
    }

    public void setCantidadPoliza(Integer cantidadPoliza) {
        this.cantidadPoliza = cantidadPoliza;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    

}
