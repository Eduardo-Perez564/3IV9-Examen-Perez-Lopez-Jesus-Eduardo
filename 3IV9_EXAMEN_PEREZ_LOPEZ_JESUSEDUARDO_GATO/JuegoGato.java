  import java.io.*;

  public class JuegoGato{

      public char [] [] tablero;
      public char jugadorUno;//Para poner una X
      public char jugadorDos;//Para poner una O
      public boolean turno;
      int contador;
  
   //Constructor
      public JuegoGato(){
         
          tablero = new char[3][3];
          jugadorUno = 'X';
          jugadorDos = 'O';
          turno = true;  //Si turno = true, el jugador 1 tira, sino entonces tira el jugador 2
          int contador = 0;     //Lleva Cuenta De Las Veces Que Han Participado Los Jugadores 1 y 2.
          inicializarTablero();  
      }

      //En este metodo se mandan a llamar los metodos
      public void jugarGato(){

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
         
          System.out.println("Bienvenido ");
                 
        do{
         
          indicarTurno();
          imprimirTablero();     
          try{elegirPosicion(Integer.parseInt(entrada.readLine()));}
          catch(IOException e){}    
          catch(NumberFormatException e){
                         
            if(getTurno()==true)
                             
              System.out.println("ERROR!: Ingreso Un Caracter No Valido, Por Favor, Intente Nuevamente JUGADOR 1.");
                         
            else
                                 
              System.out.println("ERROR!: Ingreso Un Caracter No Valido, Por Favor, Intente Nuevamente JUGADOR 2.");      
          }
                           
          buscarGanador();
         
        }while(getContador()<9);
         
        if(getContador()==9){         
          System.out.println("GATO!");
          imprimirTablero();
          System.out.println("Gracias por jugar :3");             
        }
           
        System.out.println("Gracias por jugar :3");           
    }
         
    // Especifica El Numero Que Le Corresponde A Cada Casilla.
      public void inicializarTablero(){
         
          int posicion = 1;
         
          for(int i=0;i<3;i++){
                 
            for(int j=0; j<3;j++){
                         
              tablero[i][j] = Integer.toString(posicion).charAt(0);
              posicion++;

            }                      
          }
      }
     
    //Imprime las casillas
      public void imprimirTablero(){
                 
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
       
      public void indicarPosicionArreglo (int a, int b, char c) {
        tablero [a][b]=c;
      }
    //cambia el valor de turno
      public void setTurno(boolean d){
        turno=d;
      }
    //Manipula el valor de "contador".  
      public void setContador(int e){
        contador=e;
      }
    //nos devuelve la posicion del arreglo
      public char getPosicionArreglo(int a, int b){
        return tablero[a][b];
      }
         
    //Regresa el valor de "jugadorUno".
      public char getJugadorUno(){
        return jugadorUno;
      }
     
    //Regresa el valor de "jugadorDos"
      public char getJugadorDos(){
        return jugadorDos;
      }
   
    //Regresa el valor de "turno".
      public boolean getTurno(){
        return turno;
      }
    //Regresa el valor de "contador".              
      public int getContador(){
        return contador;
      }          
     
    //Imprime el turno del jugador
      public void indicarTurno(){
          
        if(getTurno()==true)
          System.out.println("Jugador 1, elije una casilla");
                 
        else
                 
          System.out.println("Jugador 2, elije una casilla"); 
      }
     
    //obtenemos la X u O
      public char obtenerFigura(){
         
        if(getTurno()==true)
                 
          return jugadorUno;
                 
        else
                 
          return jugadorDos;     
      }
     
    //Cambia el valor de "Turno"
      public void cambiarTurno(){        
         
        if(obtenerFigura()=='X') //Si el Metodo regresa un valor char identido a "X" cambia el valor de "turno" a "false".
                 
          setTurno(false);
         
        else
                 
          setTurno(true);
      }
       
    //Verifica si la casilla esta ocupada
      public void comprobarEspacio(char espacio, int posicionUno, int posicionDos){
       
        //Si Se Cumple La Condicion Se Ingresa El Valor En La Posicion Del Arreglo Especificada. 
          if(espacio!=getJugadorUno()&&espacio!=getJugadorDos()){
                 
             indicarPosicionArreglo(posicionUno, posicionDos,obtenerFigura());
             cambiarTurno();
             contador++;
          }
         
          else
           
           //Si la casilla esta ocupada:                             
             System.out.println("La Casilla Esta Ocupada, Elija Otra Por Favor");                
      }
             
    //asi se selecciona la posicion  
      public void elegirPosicion(int posicion){
                             
        switch(posicion){
                 
                    //Comprueba Si La Posicion Esta Disponible Valiendose Del Metodo "comprobarEspacio()"
          case 1:
            comprobarEspacio(getPosicionArreglo(0,0),0,0);
            break;
          case 2:
            comprobarEspacio(getPosicionArreglo(0,1),0,1);
            break;
          case 3:
            comprobarEspacio(getPosicionArreglo(0,2),0,2);
            break;
          case 4:
            comprobarEspacio(getPosicionArreglo(1,0),1,0);
            break;
          case 5:
            comprobarEspacio(getPosicionArreglo(1,1),1,1);
            break;
          case 6:
            comprobarEspacio(getPosicionArreglo(1,2),1,2);
            break;
          case 7:
            comprobarEspacio(getPosicionArreglo(2,0),2,0);
            break;
          case 8:
            comprobarEspacio(getPosicionArreglo(2,1),2,1);
            break;
          case 9:
            comprobarEspacio(getPosicionArreglo(2,2),2,2);
            break;
          default:
          //Si digita un numero que no este en el intervalo 1:9 :
            System.out.println("Por Favor, Ingrese Solo Un Digito Del 1 al 9.");
            break;                             
        }          
      }
     
    //cuando gana alguien
      public void decirGanador(char a){
         
        if(a=='X')

          System.out.println("Oh vaya, gano el jugador 1, Felicidades!");
                 
        else if(a=='O')
                             
          System.out.println("Oh vaya, gano el jugador 2, Felicidades!");
      }
     
   //Verifica Las conficiones bajo las cuales se puede ganar
      public void buscarGanador(){
                   
        //De forma horizontal
        for(int i=0;i<3;i++){
                 
          for(int j=1;j<2;j++){
                         
            if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
                                                         
              decirGanador(tablero[i][j]);
              imprimirTablero();
              setContador(10);
            }                              
          }                      
        }
     
        //De forma vertical
        for(int i=0;i<3;i++){
                 
          for(int j=1;j<2;j++){
             
            if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
                         
              decirGanador(tablero[j][i]);
              imprimirTablero();
              setContador(10);
            }                              
          }
        }
         
        //De forma diagonal
          if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
         
           decirGanador(tablero[1][1]);
           imprimirTablero();
           setContador(10);
          }  
             
        //De forma diagonal invertida
          if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
                 
            decirGanador(tablero[1][1]);
            imprimirTablero();                  
            setContador(10);
          }      
      }    
}   