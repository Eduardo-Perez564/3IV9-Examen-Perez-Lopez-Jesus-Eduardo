import java.io.*;

public class Jueguito{

    public char [][] tablero;    
    public char jugadorUno;
    public char jugadorDos;
    public boolean turno;
    int Contador;

    //constructor

    public Jueguito(){

        tablero = new char [3][3]; //matriz tipo char para X u O
        jugadorUno = 'X'; //para imprimir en las casillas
        jugadorDos = 'O';//para imprimir en las casillas
        turno = true; //cuando el turno es true tira el jugador 1 y cuando es false tira el jugador 2
        int Contador = 0; //las veces que han tirado los jugadores
        iniciar_tablero();//llamamos al metodo
    
    }
    //aqui es donde se llevará el orden y se mandará a llamar a los de más métodos
    public void jugar(){

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
           
        System.out.println("BIENVENIDO A GATO Ver. 1.0");      
                   
        do{
           
            indicarTurno();                
            imprimir_tablero();     
            try{elegir_posicion(Integer.parseInt(entrada.readLine()));}
            catch(IOException e){}    
            catch(NumberFormatException e){
                           
                if(getTurno()==true)
                               
                    System.out.println("ERROR!: Ingreso Un Caracter No Valido, Por Favor, Intente Nuevamente JUGADOR 1.");
                           
                else
                                   
                    System.out.println("ERROR!: Ingreso Un Caracter No Valido, Por Favor, Intente Nuevamente JUGADOR 2.");      
            }
                             
            buscar_ganador();
           
        }while(getContador()<9);
           
        if(getContador()==9){
                   
            System.out.println("GATO! JUEGO EMPATADO!");                                        
            imprimir_tablero();
            System.out.println("Gracias por jugar :3");
        }
             
        System.out.println("Gracias por jugar :3");       
    }

    //Se inicializa el arreglo y se definen las posiciones de las casillas
    public void iniciar_tablero(){

        int posicion = 1;

        for (int i=0; i<3; i++){

            for (int j=0; j<3; j++){

                tablero [i][j] = Integer.toString(posicion).charAt(0);
                posicion++;

            }
        }
    }

    //aqui se imprime el tablero

    public void imprimir_tablero(){
        
        for(int i=0;i<3;i++){
               
            for(int j=0;j<3;j++){
                   
                    if(j<2)
                            System.out.print(" " + tablero[i][j] + " |");
                    else
                            System.out.print(" " + tablero[i][j] + " ");                                              
            }
            if(i<2)
                   
                    System.out.println("\n-----------");                                                                   
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }

    //El lugar en donde se ingresara el dato en matriz
    public void posicion_arreglo (int a, int b, char c){
        tablero [a][b] = c;
    }
    //Para definir quien debe tirar
    public void setTurno(boolean d){
        turno = d;
    }
    //Para definir cuantas casillas quedan
    public void setContador(int e){
        Contador = e;
    }
    //estos metodos nos regresaran las variables

    public char getposicion_arreglo(int a, int b){
        return tablero[a][b];
    }
    public char getjugadorUno(){
        return jugadorUno;
    }
    public char getjugadorDos(){
        return jugadorDos;
    }
    public boolean getTurno(){
        return turno;
    }
    public int getContador(){
        return Contador;
    }

    //indicaremos a que jugador pertenece el turno
    public void indicarTurno(){

        if(getTurno() == true){
            System.out.println("Es el turno del jugador 1, selecciona la casilla en la que quieres tirar");
        }else{
            System.out.println("Es el turno del jugador 2, selecciona la casilla en la que quieres tirar");
        }
    }

    //para alternar el turno
    public char obtener_XO(){
        
        if(getTurno() == true)
            return jugadorUno;
        else
            return jugadorDos;
        
    }

    //para cambiar el valor de nuestro booleano y establecer turnos
    public void cambiarTurno(){
        if(obtener_XO() == 'X'){
            setTurno(false);
        }else{
            setTurno(true);
        }
    }

    //aqui evitaremos que se tire mas de una vez en alguna casilla
    public void comprobar_Casilla(char espacio, int posicionUno, int posicionDos){

        if(espacio != getjugadorUno() && espacio != getjugadorDos()){

            posicion_arreglo(posicionUno, posicionDos, obtener_XO());
            cambiarTurno();
            Contador++;
        }else{
            //si la casilla esta ocupada entonces:
            System.out.println("OnO La casilla esta ocupada, por favor elige otra");
        }
    }

    //con un switch indicaremos las posiciones del tablero y el arreglo
    public void elegir_posicion(int posicion){

        switch (posicion) {
            case 1:
                comprobar_Casilla(getposicion_arreglo(0,0),0,0);
                break;
            case 2:
                comprobar_Casilla(getposicion_arreglo(0,1),0,1);
                break;
            case 3:
                comprobar_Casilla(getposicion_arreglo(0,2),0,2);
                break;
            case 4:
                comprobar_Casilla(getposicion_arreglo(1,0),1,0);
                break;
            case 5:
                comprobar_Casilla(getposicion_arreglo(1,1),1,1);
                break;
            case 6:
                comprobar_Casilla(getposicion_arreglo(1,2),1,2);
                break;
            case 7:
                comprobar_Casilla(getposicion_arreglo(2,0),2,0);
                break;
            case 8:
                comprobar_Casilla(getposicion_arreglo(2,1),2,1);
                break;
            case 9:
                comprobar_Casilla(getposicion_arreglo(2,2),2,2);
                break;        
            default:
            //en caso de que seleccione una casilla diferente del intervalo 1:9
                System.out.println("Esa casilla no existe, por favor ingresa otra");
                break;
        }
    }

    //imprime el nombre del ganador
    public void nombrar_ganador(char a){

        if (a=='X')
            System.out.println("El jugador 1 ha ganado");
        else if(a=='O')
            System.out.println("El jugador 2 ha gando");
        
    }
    
    public void buscar_ganador(){

        //comprobar las formas de ganar horizontales
        for (int i=0; i<3; i++){

            for (int j=0; j<3; j++){

                if(tablero[i][j] == tablero [i][j-1] && tablero [i][j] == tablero[i][j+1]){
                    nombrar_ganador(tablero [i][j]);
                    imprimir_tablero();
                    setContador(10);
                    
                }
            }
        }
        //comprobar las formas de ganar de manera vertical
        for (int i=0; i<3; i++){

            for (int j=0; j<3; j++){

                if(tablero[j][i] == tablero [j][i-1] && tablero [j][i] == tablero[j][i+1]){
                    nombrar_ganador(tablero [j][i]);
                    imprimir_tablero();
                    setContador(10);
                }
            }
        }
        //para ganar de forma diagonal
        if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
            nombrar_ganador(tablero [1][1]);
            imprimir_tablero();
            setContador(10);
        }
        
        //para ganar de forma diagonal invertida
        if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
            nombrar_ganador(tablero [1][1]);
            imprimir_tablero();
            setContador(10);
        }
    }

}