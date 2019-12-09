
/**
 * Write a description of class Empresa here.
 * 
 * @acriss_215 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
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
            trabajadores[i]=new Trabajador(leerClave(),leerNombre(),leerArea(),leerSueldo(),leerVentas(),leerComision());
        System.out.println("  ");
        acciones(trabajadores);
    }
    ///acciones
    private static void acciones(Trabajador [] tr){
        String [] selec={"Busqueda","filtrar","mostrar todo","exit"};
        int resp = JOptionPane.showOptionDialog(null, "Que desea hacer??", "Acciones" ,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);
        if(resp==0)busqueda(tr);
        else if(resp==1)filtro(tr);
        else if(resp==2)todo(tr);
        else System.out.println("Adiooooos..... UnU");
    }
    //filtro
    private static void filtro(Trabajador [] tr){
        boolean algo=false;
        String [] selec={"sueldo","area de trabajo","inicial del nombre","ventas"};
        int resp = JOptionPane.showOptionDialog(null, "filtrar por:", "Filtrar" ,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);
        if(resp==0){//sueldo
            String[] suel={"mayor","menor"};
            int mM = JOptionPane.showOptionDialog(null, "Sueldo:", "Filtrar" ,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, suel, suel[0]);
            int bus=0;
            try{
                bus=Integer.parseInt(JOptionPane.showInputDialog("sueldo"));
            }catch(NumberFormatException excepcion){
                System.out.println("buscando..");
            }
            System.out.println("filtro por sueldo"+suel[mM]+" que "+bus);
            for(int i=0;i<tr.length;i++){
                if(mM==0&&bus<tr[i].getSueldoF()){
                    algo=true;
                    System.out.println(tr[i].toString());
                }else if(mM==1&&bus>tr[i].getSueldoF()){
                    algo=true;
                    System.out.println(tr[i].toString());                        
                }
            }
        }else if(resp==1){///area
            String[] opc=seleccion(tr);
            String respu= (String) JOptionPane.showInputDialog(null, "Seleccione areade trabajo", "Filtrar", JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
            System.out.println("filtro por area de trabajo:"+respu);
            for(int i=0;i<tr.length;i++){
                if(tr[i].getArea().equals(respu)){
                    algo=true;
                    System.out.println(tr[i].toString());
                }
            }
        }else if(resp==2){///inicial
            String inicial = JOptionPane.showInputDialog("Escriba la inicial");//texto
            System.out.println("filtro por inicial: "+inicial);
            for(int i=0;i<tr.length;i++){
                try{
                    if(inicial.charAt(0)==tr[i].getNombre().charAt(0)){//try
                        algo=true;
                        System.out.println(tr[i].toString());
                    }
                }catch(StringIndexOutOfBoundsException excepcion){
                    System.out.println("buscando...");
                }
            }
        }else{//ventas
            String[] vet={"ninguna venta","mayores a.."};
            int vt = JOptionPane.showOptionDialog(null, "ventas:", "Filtrar" ,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, vet, vet[0]);
            int bus=0;
            if(vt==1) {
                try{
                    bus =Integer.parseInt(JOptionPane.showInputDialog("ventas"));
                }catch(NumberFormatException excepcion){
                    System.out.println("buscando..");
                }
                vet[vt]+=bus;
            }
            System.out.println("filtro por "+vet[vt]);
            for(int i=0;i<tr.length;i++){
                if(vt==0&&tr[i].getVentas()==0){
                    algo=true;
                    System.out.println(tr[i].toString());
                }else if(vt==1&&bus<tr[i].getVentas()){
                    algo=true;
                    System.out.println(tr[i].toString());                        
                }
            }
        }
        if(!algo) System.out.println("no se encontro nada\n");
        acciones(tr);
    }
        private static String[] seleccion(Trabajador []tr){
        String[] se1=new String[tr.length];
        for(int i=0;i<tr.length;i++)
            se1[i]=tr[i].getArea();
        int t=0;
        for(int i=0;i<se1.length;i++)
            for(int j=i+1;j<se1.length;j++)
                if(se1[i].equals(se1[j])){
                    t++;
                    break;}
        String []se2=new String[tr.length-t];
        int x=0;
        for(int i=0;i<se1.length;i++){
            boolean f=true;
            for(int j=i+1;j<se2.length;j++)
                if(se1[i].equals(se2[j])){
                    f=false;
                    break;}
            if(f&&x<se2.length){
                se2[x]=se1[i];
                x++;
            }
        }
        return se2;
    }
    //imprimir todo
    private static void todo(Trabajador [] tr){
        System.out.println("\n\ttrabajadores:");
        for(int i=0;i<tr.length;i++){
            System.out.println("\ttrabajador "+(i+1));
            System.out.println(tr[i].toString());}
        acciones(tr);
    }
    ///busquedas
    private static void busqueda(Trabajador [] tr){
        String tipo,txt="la clave";
        String [] selec={"clave","nombre","area de trabajo"};
        int resp = JOptionPane.showOptionDialog(null, "hacer busqueda por:", "Busqueda" ,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);
        if(resp==0)
            txt = "la clave";
        else if(resp==1)
            txt = "el nombre";
        else
            txt ="la area de trabajo";
        tipo = JOptionPane.showInputDialog("Escriba "+txt+" a buscar");
        boolean algo=false;
        System.out.println("\tbuscando "+txt+" "+tipo+":");
        for(int i=0;i<tr.length;i++){
            if(resp==0){
                if(tipo.equals(""+tr[i].getClave())){
                    algo=true;
                    System.out.println(tr[i].toString());
                }    
            }else if(resp==1){
                if(tipo.equals(tr[i].getNombre())){
                    algo=true;
                    System.out.println(tr[i].toString());
                }            
            }else{
                if(tipo.equals(tr[i].getArea())){
                    algo=true;
                    System.out.println(tr[i].toString());
                }
            }
        }
        if(!algo)System.out.println("no se encontro nada con "+txt+" ingrensado\n");
        acciones(tr);
    }
    ////leeer datos
    private static int leerClave(){
        Scanner sc=new Scanner(System.in);
        int clave;
        try{
            System.out.println("clave del empleado");
            clave=sc.nextInt();
        }catch(InputMismatchException excepcion){
            System.out.println("dato incorrecto intente denuevo");
            clave=leerClave();
        }
        return clave;
    }
    private static String leerNombre(){
        Scanner sc=new Scanner(System.in);
        String nombre;
        try{
            System.out.println("nombre del empleado");
            nombre=sc.nextLine();
        }catch(InputMismatchException excepcion){
            System.out.println("dato incorrecto intente denuevo");
            nombre=leerNombre();
        }
        return nombre;
    }
    private static String leerArea(){
        Scanner sc=new Scanner(System.in);
        String area;
        try{
            System.out.println("area de trabajo del empleado");
            area=sc.nextLine();
        }catch(InputMismatchException excepcion){
            System.out.println("dato incorrecto intente denuevo");
            area=leerArea();
        }
        return area;
    }
    private static double leerSueldo(){
        Scanner sc=new Scanner(System.in);
        double sueldo;
        try{
            System.out.println("sueldo base del empleado");
            sueldo=sc.nextDouble();
        }catch(InputMismatchException excepcion){
            System.out.println("dato incorrecto intente denuevo");
            sueldo=leerSueldo();
        }
        return sueldo;
    }
    private static int leerVentas(){
        Scanner sc=new Scanner(System.in);
        int ventas;
        try{
            System.out.println("numero de ventas del empleado");
            ventas=sc.nextInt();
        }catch(InputMismatchException excepcion){
            System.out.println("dato incorrecto intente denuevo");
            ventas=leerVentas();
        }
        return ventas;
    }
    private static double leerComision(){
        Scanner sc=new Scanner(System.in);
        double comision;
        try{
            System.out.println("comision por venta del empleado");
            comision=sc.nextDouble();
        }catch(InputMismatchException excepcion){
            System.out.println("algun dato es incorrecto intente denuevo");
            comision=leerComision();
        }
        return comision;
    }
}
