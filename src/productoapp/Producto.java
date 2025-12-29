package productoapp;

import java.time.LocalDate;

public class Producto
{
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private LocalDate fecha;

    public Producto(int id, String nombre, String categoria, double precio, LocalDate fecha)
    {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public double getPrecio()
    {
        return precio;
    }

    public LocalDate getFecha()
    {
        return fecha;
    }
}



