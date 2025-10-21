/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facturacion;

import Clientes.Cliente;
import Facturacion.Factura;
import Facturacion.RepositorioFacturas;
import Facturacion.ServicioFacturacion;
import Notificaciones.CanalNotificacion;
import Notificaciones.ServicioNotificaciones;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class ServicioFacturacionProxi extends ServicioFacturacion {
       private final ServicioFacturacion servicioReal;
    public ServicioFacturacionProxi(RepositorioFacturas r, ServicioNotificaciones n) {
        super(r, n);
           this.servicioReal = new ServicioFacturacion(r, n);
           
    }

   
    @Override
  public Factura crearFactura(int numero, Cliente cliente){
      if(cliente == null) {
          System.out.println("No se puede crear una factura sin cliente");
          return null;
      }
      return servicioReal.crearFactura(numero, cliente);
  }

   public void emitirFacturacion(int numero, List<CanalNotificacion> canales ) {
       System.out.println("Validacion antes de emitir factura");
       servicioReal.emitirFactura(numero,canales);
       
   }
}

