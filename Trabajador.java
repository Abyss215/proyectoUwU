
/**
 * Write a description of class Trabajador here.
 * 
 * @criss_215 
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
        this.sueldoF=vent*comi+sueldoB;
    }
    
    public int getClave(){return this.clave;}
    public String getNombre(){return this.nombre;}
    public String getArea(){return this.area;}
    public double getSueldoB(){return this.sueldoB;}
    public int getVentas(){return this.ventas;}
    public double getComision(){return this.comision;}
    public double getSueldoF(){return this.sueldoF;}
    
    public String toString(){
        return "clave-->"+this.clave+"\nnombre-->"+this.nombre+"\narea de trabajo-->"+this.area+"\nsueldo base-->"+this.sueldoB+"\nventas-->"+this.ventas+"\ncomision-->"+this.comision+"\nsueldo-->"+this.sueldoF+"\n";
    }
}
