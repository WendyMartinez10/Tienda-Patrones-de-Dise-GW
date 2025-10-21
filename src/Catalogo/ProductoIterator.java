/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author USER
 */
public class ProductoIterator implements Iterator<Producto> {
   private List<Producto> productos;
    private int posicion = 0;

    public ProductoIterator(List<Producto> productos) {
        this.productos = productos;
    }


    public boolean hasNext() {
        return posicion < productos.size();
    }

    public Producto next() {
        return productos.get(posicion++);
    }
}
 

