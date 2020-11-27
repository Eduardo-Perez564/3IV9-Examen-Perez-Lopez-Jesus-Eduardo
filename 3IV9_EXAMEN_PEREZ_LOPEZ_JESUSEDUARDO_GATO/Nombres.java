public class Nombres{

    public String Player1;
    public String Player2;

    public Nombres(){
        //constructor
    }

    public void NombresJugadores(){

        System.out.println("Hola, Ingresa el nombre del jugador 1");
        Player1 = System.console().readLine();
        System.out.println("Hola "+Player1+" tu tendras X");

        System.out.println("ngresa el nombre del jugador 2");
        Player2 = System.console().readLine();
        System.out.println("Hola "+Player2+" tu tendras O");

    }

}