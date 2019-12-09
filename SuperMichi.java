
/**
 * el gato jugado con la compu xd
 * 
 * @criss_215
 * @version (2.1)
 */
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.InputMismatchException;
public class SuperMichi{
    private char [][] tablero=new char[3][3];
    private boolean player=true;
    private int jugadas=0;
    private char J1;
    private char J2;
    private int y,x;
    private void reset(){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                tablero[j][i]='\u0000';
        jugadas=0;
    }
    public static void main(String [] args){
        SuperMichi cat=new SuperMichi();
        int resp;
        do{
            String[] letra = {"X","O"};
            int seleccion = JOptionPane.showOptionDialog(null, "Jugar como:\nX<--primer jugador\nO<--segundo jugador", "Escoger Jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, letra, letra[0]);
            cat.jugadores(seleccion);
            cat.impri();
            cat.jugadas();
            resp = JOptionPane.showConfirmDialog(null, "¿Quieres jugar otra vez?", "El gato", JOptionPane.YES_NO_OPTION);
            if(resp==0)cat.reset();
        }while(resp==0);
    }
    private void jugadores(int lt){
        if(lt==0){
            this.J1='x';
            this.J2='o';
            this.player=true;
        }else{
            this.J1='o';
            this.J2='x';
            this.player=false;
        }
    }
    private int[] miTurno(){
        Scanner sc=new Scanner(System.in);
        int[] turno=new int[2];
        System.out.println("te toca UwU");
        System.out.println("ingrese posicion de su jugada");
        try{
            System.out.print("columna: "); turno[0]=sc.nextInt();
            System.out.print("fila: "); turno[1]=sc.nextInt();
        }catch(InputMismatchException excepcion){
            System.out.println("ingrese una pocision valida");
            turno=miTurno();
        }finally{
            return turno;
        }
    }
    private void jugadas(){
        if(player){
            int[] xy=miTurno();
            x=xy[0];
            y=xy[1];
        }else{
            x=compu()[0];
            y=compu()[1];
        }
        
        if(jugadaValida(x,y)){
            jugadas++;
            if(player){
                tablero[x][y]=J1;
                player=!player;
            }else{
                System.out.println("\nme toca OwO");
                tablero[x][y]=J2;
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
    private boolean jugadaValida(int n, int m){
        boolean jugadaV=true;
        if(n>=3||m>=3){
            jugadaV=false;
        }else{
            if(tablero[n][m]!='\u0000')
                jugadaV=false;
        }
        return jugadaV;
    }
    private String ganador(){
        String gano="empate";
        if((tablero[0][0]==J1&&tablero[1][1]==J1&&tablero[2][2]==J1)||
           (tablero[2][0]==J1&&tablero[1][1]==J1&&tablero[0][2]==J1)||
           (tablero[0][0]==J1&&tablero[0][1]==J1&&tablero[0][2]==J1)||
           (tablero[1][0]==J1&&tablero[1][1]==J1&&tablero[1][2]==J1)||
           (tablero[2][0]==J1&&tablero[2][1]==J1&&tablero[2][2]==J1)||
           (tablero[0][0]==J1&&tablero[1][0]==J1&&tablero[2][0]==J1)||
           (tablero[0][1]==J1&&tablero[1][1]==J1&&tablero[2][1]==J1)||
           (tablero[0][2]==J1&&tablero[1][2]==J1&&tablero[2][2]==J1)){
               gano="ganastes";
            }else if((tablero[0][0]==J2&&tablero[1][1]==J2&&tablero[2][2]==J2)||
           (tablero[2][0]==J2&&tablero[1][1]==J2&&tablero[0][2]==J2)||
           (tablero[0][0]==J2&&tablero[0][1]==J2&&tablero[0][2]==J2)||
           (tablero[1][0]==J2&&tablero[1][1]==J2&&tablero[1][2]==J2)||
           (tablero[2][0]==J2&&tablero[2][1]==J2&&tablero[2][2]==J2)||
           (tablero[0][0]==J2&&tablero[1][0]==J2&&tablero[2][0]==J2)||
           (tablero[0][1]==J2&&tablero[1][1]==J2&&tablero[2][1]==J2)||
           (tablero[0][2]==J2&&tablero[1][2]==J2&&tablero[2][2]==J2)){
               gano="te gane wahaha";
            }
        return gano;
    }
    private void impri(){
        System.out.println("\n   0  1  2");
        for(int i=0;i<3;i++){
            System.out.print(i+" ");
            for(int j=0;j<3;j++){
                System.out.print("["+tablero[j][i]+"]");}
                System.out.println("");}
    }
    private int[] compu(){
        int poc[]=new int[2];
        /**1 encontrar si puede ganar
         * 2 encontrar bloquear all rival
         */
        for(int j=1;j<=2;j++){
            char l;
            if(j==1) l=J2;
            else l=J1;
            
            if(tablero[1][1]==l&&tablero[0][0]==l&&tablero[2][2]=='\u0000'){//diagonal ar-ab
                poc[0]=2;
                poc[1]=2;
                return poc;
            }else if(tablero[1][1]==l&&tablero[2][2]==l&&tablero[0][0]=='\u0000'){
                poc[0]=0;
                poc[1]=0;
                return poc;
            }else if(tablero[1][1]=='\u0000'&&tablero[0][0]==l&&tablero[2][2]==l){
                poc[0]=1;
                poc[1]=1;
                return poc;
            }else if(tablero[1][1]==l&&tablero[0][2]==l&&tablero[2][0]=='\u0000'){//diagonal ab-ar
                poc[0]=2;
                poc[1]=0;
                return poc;
            }else if(tablero[1][1]==l&&tablero[2][0]==l&&tablero[0][2]=='\u0000'){
                poc[0]=0;
                poc[1]=2;
                return poc;
            }else if(tablero[1][1]=='\u0000'&&tablero[2][0]==l&&tablero[0][2]==l){
                poc[0]=1;
                poc[1]=1;
                return poc;
            }else{
                for(int i=0;i<3;i++){
                    if(tablero[1][i]==l&&tablero[0][i]==l&&tablero[2][i]=='\u0000'){///por columna
                        poc[0]=2;
                        poc[1]=i;
                        return poc;
                    }else if(tablero[1][i]==l&&tablero[2][i]==l&&tablero[0][i]=='\u0000'){
                        poc[0]=0;
                        poc[1]=i;
                        return poc;
                    }else if(tablero[1][i]=='\u0000'&&tablero[0][i]==l&&tablero[2][i]==l){
                        poc[0]=1;
                        poc[1]=i;
                        return poc;
                    }else if(tablero[i][1]==l&&tablero[i][0]==l&&tablero[i][2]=='\u0000'){//por fila
                        poc[0]=i;
                        poc[1]=2;
                        return poc;
                    }else if(tablero[i][1]==l&&tablero[i][2]==l&&tablero[i][0]=='\u0000'){
                        poc[0]=i;
                        poc[1]=0;
                        return poc;
                    }else if(tablero[i][1]=='\u0000'&&tablero[i][0]==l&&tablero[i][2]==l){
                        poc[0]=i;
                        poc[1]=1;
                        return poc;
                    }
                }
            }
        }
        poc[0]=(int)(Math.random()*2.1);
        poc[1]=(int)(Math.random()*2.1);
        return poc;
    }
    
}
