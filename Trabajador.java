
/**
 * Write a description of class Trabajador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trabajador
{
    private int clave;
    private String nombre;
    private String area;
    private double sueldoB;
    private int ventas;
    private double comision;
    private double sueldoF;
    
    public Trabajador(int clav,String nom,String are,double suelB,int vent,double comi){
        this.clave=clav;
        this.nombre=nom;
        this.area=are;
        this.sueldoB=suelB;
        this.ventas=vent;
        this.comision=comi;
        this.sueldoF=vent*comi;
    }
    
    public String toString(){
        return this.clave +" | "+this.nombre+" | "+this.area+" | "+this.sueldoB+" | "+this.ventas+" | "+this.comision+" | "+this.sueldoF+" | ";
    }
}
