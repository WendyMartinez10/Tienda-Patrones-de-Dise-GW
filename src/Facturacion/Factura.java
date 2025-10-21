/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facturacion;

import Clientes.Cliente;
import Facturacion.EstadoFactura;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jprod
 */
public class Factura {
    private int numero;
    private Cliente cliente;
    private LocalDateTime fecha;
    private List<ItemFactura> items;
    private EstadoFactura estado;
    
private Factura(FacturaBuilder builder) {
        this.numero = builder.numero;
        this.cliente = builder.cliente;
        this.fecha = builder.fecha != null ? builder.fecha : LocalDateTime.now();
        this.items = builder.items;
        this.estado = builder.estado != null ? builder.estado : EstadoFactura.PENDIENTE;
    }

    
    public int getNumero() { return numero; }
    public Cliente getCliente() { return cliente; }
    public LocalDateTime getFecha() { return fecha; }
    public List<ItemFactura> getItems() { return items; }
    public EstadoFactura getEstado() { return estado; }

    public void setEstado(EstadoFactura e){ this.estado = e; }

    
    public void addItem(ItemFactura item) { items.add(item); }

    public double getSubtotal() {
        return items.stream().mapToDouble(ItemFactura::getSubtotal).sum();
    }

    public double getImpuesto() {
        return getSubtotal() * 0.13;
    }

    public double getTotal() {
        return getSubtotal() + getImpuesto();
    }

    @Override
    public String toString() {
        return "Factura{" + "numero=" + numero + ", cliente=" + cliente + ", fecha=" + fecha + ", items=" + items + ", estado=" + estado + '}';
    }

   

    public static class FacturaBuilder {
        private int numero;
        private Cliente cliente;
        private LocalDateTime fecha;
        private List<ItemFactura> items = new ArrayList<>();
        private EstadoFactura estado;

        public FacturaBuilder setNumero(int numero) {
            this.numero = numero;
            return this;
        }

        public FacturaBuilder setCliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public FacturaBuilder setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public FacturaBuilder addItem(ItemFactura item) {
            this.items.add(item);
            return this;
        }

        public FacturaBuilder setEstado(EstadoFactura estado) {
            this.estado = estado;
            return this;
        }

        // 🚀 Método final que crea la Factura
        public Factura build() {
            return new Factura(this);
        }
    }
}