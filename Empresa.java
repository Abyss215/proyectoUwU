
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Empresa
{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("cuantos empleados tiene??");
        int t=sc.nextInt();
        Trabajador [] trabajadores=new Trabajador[t];
        for(int i=0;i<t;i++)
            trabajadores[i]=anadirT();
        System.out.println("  clave  |  nombre  |  area de trabajo  |  sueldo base  | ventas | comision |  sueldo  |");
        for(int i=0;i<t;i++)
            System.out.println(trabajadores[i].toString());
    }
    private static Trabajador anadirT(){
        Scanner sc=new Scanner(System.in);
        int clave;
        String nombre;
        String area;
        double sueldoB;
        int ventas;
        double comision;
        Trabajador trabaj;
        try{
            System.out.println("clave del empleado");
            clave=sc.nextInt();
            System.out.println("nombre del empleado");
            nombre=sc.nextLine();
            System.out.println("area de trabajo del empleado");
            area=sc.nextLine();
            System.out.println("sueldo base del empleado");
            sueldoB=sc.nextDouble();
            System.out.println("numero de ventas del empleado");
            ventas=sc.nextInt();
            System.out.println("comision por venta del empleado");
            comision=sc.nextDouble();
            trabaj=new Trabajador(clave,nombre,area,sueldoB,ventas,comision);
        }catch(InputMismatchException excepcion){
            System.out.println("algun dato es incorrecto intente denuevo");
            trabaj=anadirT();
        }
        return trabaj;
    }
}
