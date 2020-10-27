import java.util.Scanner;

import java.util.Random;

class AlfaPokedex{

    public static void main(String[] args){

        Scanner entrada = new Scanner (System.in);

        Random rnd = new Random ();

        int id, fuerza, vida; 
        int opcion, poke, mon;
        float ataqueP, defensa, ataqueS;
        char regreso;
        do{
            System.out.println("3IV9 Perez Lopez Jesus Eduardo");
        do{
            System.out.println("Hola, bienvenido.");
            System.out.println();
            System.out.println("Las primeras tres opciones son para ver los atribuos de los pokemones");
            System.out.println();
            System.out.println("1. Charmander");
            System.out.println("2. Bulbasaur");
            System.out.println("3. Squartle");
            System.out.println("4. Batalla Pokemon");
            opcion = entrada.nextInt();
        }while(opcion>=5 || opcion<=0);

            switch(opcion){
                case 1:
    
                    System.out.println("Has elegido ver a Charmander");
                    System.out.println("Estos son sus atributos:");
                    System.out.println("Vida: 50");
                    System.out.println("ID: 100 ");
                    System.out.println("Defensa: 80");
                    System.out.println("Ataque Principal: Furia de Dragon");
                    System.out.println("Ataque Secundario: Gruñido");
                    
    
                break;
                case 2:
    
                    System.out.println("Has elegido ver a Bulbasaur");
                    System.out.println("Estos son sus atributos:");
                    System.out.println("Vida: 70");
                    System.out.println("ID: 200 ");
                    System.out.println("Defensa: 50");
                    System.out.println("Ataque Principal: Gruñido");
                    System.out.println("Ataque Secundario: Latigo");
    
                break;
                case 3:
    
                    System.out.println("Has elegido ver a Squirtle");
                    System.out.println("Estos son sus atributos:");
                    System.out.println("Vida: 60");
                    System.out.println("ID: 300 ");
                    System.out.println("Defensa: 60");
                    System.out.println("Ataque Principal: Pistola de agua ");
                    System.out.println("Ataque Secundario: Mordisco ");
    
                break;
                case 4:
                    do{
                    System.out.println("Que pokemon eliges?");
                    System.out.println("1. Charmander");
                    System.out.println("2. Bulbasaur");
                    System.out.println("3. Squartle");
                    poke = entrada.nextInt();
                    }while (poke>=3 || poke<=0);
                    switch(poke){
                        case 1:
                        mon = (int)Math.floor(Math.random()*(1-2)+2);
                        
                        if(mon ==1){
                            System.out.println("El Pokemon contra el que va a luchar es Bulbasaur");

                        }
                        if (mon == 2){
                            System.out.println("El Pokemon contra el que va a luchar es Squirtle");

                        }
                        break;
                        case 2:
                        mon = (int)Math.floor(Math.random()*(1-2)+2);
                        
                        if(mon ==1){
                            System.out.println("El Pokemon contra el que va a luchar es Charmander");

                        }
                        if (mon == 2){
                            System.out.println("El Pokemon contra el que va a luchar es Squirtle");

                        }
                        break;
                        case 3:
                        mon = (int)Math.floor(Math.random()*(1-2)+2);
                        
                        if(mon ==1){
                            System.out.println("El Pokemon contra el que va a luchar es Charmander");

                        }
                        if (mon == 2){
                            System.out.println("El Pokemon contra el que va a luchar es Bulbasaur");

                        }
                        break;
                    }

                    
                break;
                default:
                    System.out.println("Lo sentimos, no existe esa opcion UnU");
                break;


            }
            System.out.println();
            System.out.println("Deseas regresar al menu o salir?");
            System.out.println("Si deseas Regresar al Menu, oprime R");
            regreso = entrada.next().charAt(0);
        }while(regreso =='R' || regreso =='r');
        
        
        

    }
}