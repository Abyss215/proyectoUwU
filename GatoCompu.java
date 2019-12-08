
/**
 * el gato jugado con la compu xd
 * 
 * @criss_215
 * @version (1.0)
 */
import java.util.Scanner;
public class GatoCompu{
    private char [][] tablero=new char[3][3];
    private boolean player=true;
    private int jugadas=0;
    private void jugadas(){
        Scanner sc=new Scanner(System.in);
        int y,x;
        if(player){
            System.out.println("te toca UwU");
            System.out.println("ingrese posicion de su jugada");
            System.out.print("columna: "); x=sc.nextInt();
            System.out.print("fila: "); y=sc.nextInt();
        }else{
            x=(int)(Math.random()*2.1);
            y=(int)(Math.random()*2.1);
        }
        boolean jugadaValida=true;
        if(x>=3||y>=3){
            jugadaValida=false;
        }else{
            if(tablero[x][y]!='\u0000')
                jugadaValida=false;
        }
        if(jugadaValida){
            jugadas++;
            if(player){
                tablero[x][y]='o';
                player=!player;
            }else{
                System.out.println("\nme toca OwO");
                tablero[x][y]='x';
                player=!player;
            }
            if(jugadas<9){
                if(ganador().equals("empate")){
                    impri();
                    jugadas();
                }else{
                    impri();
                    System.out.println(ganador());
                }
            }else{
                impri();
                System.out.println(ganador());
            }
            
        }else{
            if(player){
                System.out.println("\nya se jugo en esa posicion o esta fuera de rango, intente otra");
                impri();
                jugadas();
            }else jugadas();
        }
    }
    private String ganador(){
        String gano="empate";
        if((tablero[0][0]=='o'&&tablero[1][1]=='o'&&tablero[2][2]=='o')||
           (tablero[2][0]=='o'&&tablero[1][1]=='o'&&tablero[0][2]=='o')||
           (tablero[0][0]=='o'&&tablero[0][1]=='o'&&tablero[0][2]=='o')||
           (tablero[1][0]=='o'&&tablero[1][1]=='o'&&tablero[1][2]=='o')||
           (tablero[2][0]=='o'&&tablero[2][1]=='o'&&tablero[2][2]=='o')||
           (tablero[0][0]=='o'&&tablero[1][0]=='o'&&tablero[2][0]=='o')||
           (tablero[0][1]=='o'&&tablero[1][1]=='o'&&tablero[2][1]=='o')||
           (tablero[0][2]=='o'&&tablero[1][2]=='o'&&tablero[2][2]=='o')){
               gano="ganastes";
            }else if((tablero[0][0]=='x'&&tablero[1][1]=='x'&&tablero[2][2]=='x')||
           (tablero[2][0]=='x'&&tablero[1][1]=='x'&&tablero[0][2]=='x')||
           (tablero[0][0]=='x'&&tablero[0][1]=='x'&&tablero[0][2]=='x')||
           (tablero[1][0]=='x'&&tablero[1][1]=='x'&&tablero[1][2]=='x')||
           (tablero[2][0]=='x'&&tablero[2][1]=='x'&&tablero[2][2]=='x')||
           (tablero[0][0]=='x'&&tablero[1][0]=='x'&&tablero[2][0]=='x')||
           (tablero[0][1]=='x'&&tablero[1][1]=='x'&&tablero[2][1]=='x')||
           (tablero[0][2]=='x'&&tablero[1][2]=='x'&&tablero[2][2]=='x')){
               gano="te gane wahaha";
            }
        return gano;
    }
    private void impri(){
        System.out.println("\n   0  1  2");
        for(int y=0;y<3;y++){
            System.out.print(y+" ");
            for(int x=0;x<3;x++){
                System.out.print("["+tablero[x][y]+"]");}
                System.out.println("");}
    }
    public static void main(String [] args){
        GatoCompu cat=new GatoCompu();
        cat.impri();
        cat.jugadas();
    }
}
