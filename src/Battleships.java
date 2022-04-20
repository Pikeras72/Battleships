import java.util.Scanner;
//HECHO POR DIEGO RUIZ PIQUERAS
public class Battleships {

    static Scanner teclado = new Scanner(System.in);

    public static void main (String[] args){Battleships.ejecutar();}

    public static void ejecutar(){
        int[][] tableroJugador = new int[10][10];
        int[][] tableroOrdenador = new int[10][10];
        Battleships.cartel();
        int x = Battleships.seleccionModo();
        Battleships.iniciarTablero(tableroJugador);
        Battleships.iniciarTablero(tableroOrdenador);
        if (x == 1){
            System.out.print("\nUsted dispone de estos barcos:\n");
            System.out.print("\n*****   ****   ***   **   **\n\n");
            Battleships.modo1(tableroJugador, tableroOrdenador);
        }
        else if (x == 2){
            System.out.print("\nUsted dispone de estos barcos:\n");
            System.out.print("\n****   ***   **   **   **\n");
            Battleships.modo2(tableroJugador, tableroOrdenador);
        }
        else if (x == 3){
            System.out.print("\nUsted dispone de estos barcos:\n");
            System.out.print("\n***   **   **   **   **\n\n");
            Battleships.modo3(tableroJugador, tableroOrdenador);
        }
        else{
            System.out.print("\nUsted dispone de estos barcos:\n");
            System.out.print("\n**   **   **   **   **\n\n");
            Battleships.modo4(tableroJugador, tableroOrdenador);
        }
    }

    public static void cartel(){

        System.out.println(",-----.          ,--.   ,--. ,--.           ,--.    ,--.             ");
        System.out.println("|  |) /_ ,--,--,-'  '-,-'  '-|  |,---. ,---.|  ,---.`--',---. ,---.  ");
        System.out.println("|  .-.  ' ,-.  '-.  .-'-.  .-|  | .-. (  .-'|  .-.  ,--| .-. (  .-'                 |         BY           |");
        System.out.println("|  '--' \\ '-'  | |  |   |  | |  \\   --.-'  `|  | |  |  | '-' .-'  `)                |     DIEGO RUIZ P.    |");
        System.out.println("`------' `--`--' `--'   `--' `--'`----`----'`--' `--`--|  |-'`----'  ");
        System.out.println("                                                      `--'          ");
    }

    public static int seleccionModo(){
        int eleccion = -1;
        System.out.println("\n\t¿Que modo de juego te gustaría probar?");
        System.out.println("\n\t1 - Clásico (3 Barcos distintos y 2 igual)\t\t2 - Intermedio (2 Barcos distintos y 3 iguales)\n\n\t3- Avanzado (1 Barcos distintos y 4 iguales)\t4 - Complicado (5 Barcos iguales) \n");
        do{
            try {
                System.out.print("Elección: ");
                eleccion = Integer.parseInt(teclado.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("Dato no válido "+ex.getMessage());
            }
        }while (eleccion < 1 || eleccion > 4);
        System.out.println("\nPerfecto, usted ha elejido la opción: "+ eleccion);
        return eleccion;
    }

    public static void iniciarTablero(int[][] tablero){
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                tablero[fila][columna] = 0;
            }
        }
    }

    public static void modo1(int [][] tableroJugador,int[][] tableroOrdenador){
        Barco barcoj0 = new Barco(5);
        Barco barcoj1 = new Barco(4);
        Barco barcoj2 = new Barco(3);
        Barco barcoj3 = new Barco(2);
        Barco barcoj4 = new Barco(2);
        Barco barcoo0 = new Barco(5);
        Barco barcoo1 = new Barco(4);
        Barco barcoo2 = new Barco(3);
        Barco barcoo3 = new Barco(2);
        Barco barcoo4 = new Barco(2);
        BarcosJugador barcosJugador = new BarcosJugador();
        BarcosJugador barcosOrdenador = new BarcosJugador();
        barcosJugador.añadirBarco(barcoj0);
        barcosJugador.añadirBarco(barcoj1);
        barcosJugador.añadirBarco(barcoj2);
        barcosJugador.añadirBarco(barcoj3);
        barcosJugador.añadirBarco(barcoj4);
        barcosOrdenador.añadirBarco(barcoo0);
        barcosOrdenador.añadirBarco(barcoo1);
        barcosOrdenador.añadirBarco(barcoo2);
        barcosOrdenador.añadirBarco(barcoo3);
        barcosOrdenador.añadirBarco(barcoo4);
        System.out.println("Tablero Jugador");
        Battleships.mostrarTablero(tableroJugador);
        tableroJugador = establecerBarcos(tableroJugador, barcosJugador);
        tableroOrdenador = establecerBarcosOrdenador(tableroOrdenador, barcosOrdenador);
        System.out.println("\n\nTablero Ordenador");
        Battleships.mostrarTableroOculto(tableroOrdenador);
        while (barcosJugador.getNumHundidos() != 5 && barcosOrdenador.getNumHundidos() != 5){
            tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
            if (barcosOrdenador.getNumHundidos() != 5){
                tableroJugador = turnoOrdenador(tableroJugador, false,  false,0,-1, -1, barcosJugador, barcosOrdenador);
                Battleships.mostrarTablero(tableroJugador);
                System.out.println("\n");
                Battleships.mostrarTableroOculto(tableroOrdenador);
            }
        }
    }

    public static void modo2(int [][] tableroJugador,int[][] tableroOrdenador){
        Barco barcoj0 = new Barco(4);
        Barco barcoj1 = new Barco(3);
        Barco barcoj2 = new Barco(2);
        Barco barcoj3 = new Barco(2);
        Barco barcoj4 = new Barco(2);
        Barco barcoo0 = new Barco(4);
        Barco barcoo1 = new Barco(3);
        Barco barcoo2 = new Barco(2);
        Barco barcoo3 = new Barco(2);
        Barco barcoo4 = new Barco(2);
        BarcosJugador barcosJugador = new BarcosJugador();
        BarcosJugador barcosOrdenador = new BarcosJugador();
        barcosJugador.añadirBarco(barcoj0);
        barcosJugador.añadirBarco(barcoj1);
        barcosJugador.añadirBarco(barcoj2);
        barcosJugador.añadirBarco(barcoj3);
        barcosJugador.añadirBarco(barcoj4);
        barcosOrdenador.añadirBarco(barcoo0);
        barcosOrdenador.añadirBarco(barcoo1);
        barcosOrdenador.añadirBarco(barcoo2);
        barcosOrdenador.añadirBarco(barcoo3);
        barcosOrdenador.añadirBarco(barcoo4);
        System.out.println("Tablero Jugador");
        Battleships.mostrarTablero(tableroJugador);
        tableroJugador = establecerBarcos(tableroJugador, barcosJugador);
        tableroOrdenador = establecerBarcosOrdenador(tableroOrdenador, barcosOrdenador);
        System.out.println("\n\nTablero Ordenador");
        Battleships.mostrarTableroOculto(tableroOrdenador);
        while (barcosJugador.getNumHundidos() != 5 && barcosOrdenador.getNumHundidos() != 5){
            tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
            if (barcosOrdenador.getNumHundidos() != 5){
                tableroJugador = turnoOrdenador(tableroJugador, false,false,0, -1, -1, barcosJugador, barcosOrdenador);
                Battleships.mostrarTablero(tableroJugador);
                System.out.println("\n");
                Battleships.mostrarTableroOculto(tableroOrdenador);
            }
        }
    }

    public static void modo3(int [][] tableroJugador,int[][] tableroOrdenador){
        Barco barcoj0 = new Barco(3);
        Barco barcoj1 = new Barco(2);
        Barco barcoj2 = new Barco(2);
        Barco barcoj3 = new Barco(2);
        Barco barcoj4 = new Barco(2);
        Barco barcoo0 = new Barco(3);
        Barco barcoo1 = new Barco(2);
        Barco barcoo2 = new Barco(2);
        Barco barcoo3 = new Barco(2);
        Barco barcoo4 = new Barco(2);
        BarcosJugador barcosJugador = new BarcosJugador();
        BarcosJugador barcosOrdenador = new BarcosJugador();
        barcosJugador.añadirBarco(barcoj0);
        barcosJugador.añadirBarco(barcoj1);
        barcosJugador.añadirBarco(barcoj2);
        barcosJugador.añadirBarco(barcoj3);
        barcosJugador.añadirBarco(barcoj4);
        barcosOrdenador.añadirBarco(barcoo0);
        barcosOrdenador.añadirBarco(barcoo1);
        barcosOrdenador.añadirBarco(barcoo2);
        barcosOrdenador.añadirBarco(barcoo3);
        barcosOrdenador.añadirBarco(barcoo4);
        System.out.println("Tablero Jugador");
        Battleships.mostrarTablero(tableroJugador);
        tableroJugador = establecerBarcos(tableroJugador, barcosJugador);
        tableroOrdenador = establecerBarcosOrdenador(tableroOrdenador, barcosOrdenador);
        System.out.println("\n\nTablero Ordenador");
        Battleships.mostrarTableroOculto(tableroOrdenador);
        while (barcosJugador.getNumHundidos() != 5 && barcosOrdenador.getNumHundidos() != 5){
            tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
            if (barcosOrdenador.getNumHundidos() != 5){
                tableroJugador = turnoOrdenador(tableroJugador, false,false,0, -1, -1, barcosJugador, barcosOrdenador);
                Battleships.mostrarTablero(tableroJugador);
                System.out.println("\n");
                Battleships.mostrarTableroOculto(tableroOrdenador);
            }
        }
    }

    public static void modo4(int [][] tableroJugador,int[][] tableroOrdenador){
        Barco barcoj0 = new Barco(2);
        Barco barcoj1 = new Barco(2);
        Barco barcoj2 = new Barco(2);
        Barco barcoj3 = new Barco(2);
        Barco barcoj4 = new Barco(2);
        Barco barcoo0 = new Barco(2);
        Barco barcoo1 = new Barco(2);
        Barco barcoo2 = new Barco(2);
        Barco barcoo3 = new Barco(2);
        Barco barcoo4 = new Barco(2);
        BarcosJugador barcosJugador = new BarcosJugador();
        BarcosJugador barcosOrdenador = new BarcosJugador();
        barcosJugador.añadirBarco(barcoj0);
        barcosJugador.añadirBarco(barcoj1);
        barcosJugador.añadirBarco(barcoj2);
        barcosJugador.añadirBarco(barcoj3);
        barcosJugador.añadirBarco(barcoj4);
        barcosOrdenador.añadirBarco(barcoo0);
        barcosOrdenador.añadirBarco(barcoo1);
        barcosOrdenador.añadirBarco(barcoo2);
        barcosOrdenador.añadirBarco(barcoo3);
        barcosOrdenador.añadirBarco(barcoo4);
        System.out.println("Tablero Jugador");
        Battleships.mostrarTablero(tableroJugador);
        tableroJugador = establecerBarcos(tableroJugador, barcosJugador);
        tableroOrdenador = establecerBarcosOrdenador(tableroOrdenador, barcosOrdenador);
        System.out.println("\n\nTablero Ordenador");
        Battleships.mostrarTableroOculto(tableroOrdenador);
        while (barcosJugador.getNumHundidos() != 5 && barcosOrdenador.getNumHundidos() != 5){
            tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
            if (barcosOrdenador.getNumHundidos() != 5){
                tableroJugador = turnoOrdenador(tableroJugador, false,false,0, -1, -1, barcosJugador, barcosOrdenador);
                Battleships.mostrarTablero(tableroJugador);
                System.out.println("\n");
                Battleships.mostrarTableroOculto(tableroOrdenador);
            }
        }
    }

    public static int[][] turnoJugador(int [][] tableroOrdenador, int[][] tableroJugador, BarcosJugador barcosOrdenador){
        Barco barcoTocado = null;
        String letras = "ABCDEFGHIJ";
        boolean hundido = false;
        int fila;
        String letraRecogida;
        System.out.print("Introduzca una fila [A..J]: ");
        letraRecogida = teclado.next();
        fila = Battleships.leerPosicionLetras(letraRecogida);
        letraRecogida = String.valueOf(letras.charAt(fila-1));
        int columna = Battleships.leerPosicionNumeros(1,10);
        if (tableroOrdenador[fila-1][columna-1] == 1){
            tableroOrdenador[fila-1][columna-1] = 2;
            for (int i = 0; i < barcosOrdenador.getNumColocados(); i++){
                for (int j = 0; j < barcosOrdenador.getBarcosColocados()[i].getLonguitud(); j++){
                    if (barcosOrdenador.getBarcosColocados()[i].getPosicionFila()[j] == fila-1 && barcosOrdenador.getBarcosColocados()[i].getPosicionColumna()[j] == columna-1){
                        barcoTocado = barcosOrdenador.getBarcosColocados()[i];
                        barcoTocado.tocar();
                        if (barcoTocado.getTocado() == barcoTocado.getLonguitud()){
                            barcosOrdenador.hundirBarco(i);
                            hundido = true;
                        }
                        break;
                    }
                }
            }
            if (hundido){
                System.out.print("Tablero Jugador --- ¡HUNDISTE UN BARCO DE TAMAÑO: "+barcoTocado.getLonguitud()+" Y ACERTASTE EN ("+letraRecogida+", "+columna+"), JUEGAS DE NUEVO!");
            }else {
                System.out.print("Tablero Jugador --- ¡ACERTASTE EN ("+letraRecogida+", "+columna+"), JUEGAS DE NUEVO!");
            }
            System.out.println("\nTablero Ordenador");
            Battleships.mostrarTablero(tableroJugador);
            System.out.println("\n");
            Battleships.mostrarTableroOculto(tableroOrdenador);
            if (barcosOrdenador.getNumHundidos() == 5){
                System.out.println("\n¡ENHORABUENA, HAS GANADO AL ORDENADOR!");
            }else {
                tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
            }
        }
        else if (tableroOrdenador[fila-1][columna-1] == 0){
            tableroOrdenador[fila-1][columna-1] = 3;
            System.out.print("Tablero Jugador --- ¡AGUA EN ("+letraRecogida+", "+columna+")!");
        }
        else if (tableroOrdenador[fila-1][columna-1] == 2 || tableroOrdenador[fila-1][columna-1] == 3){
            System.out.println("Tablero Jugador --- ¡YA HAS PROBADO ESTA UBICACIÓN, PRUEBA DE NUEVO!");
            tableroOrdenador = turnoJugador(tableroOrdenador, tableroJugador, barcosOrdenador);
        }
        return tableroOrdenador;
    }

    public static int[][] turnoOrdenador(int [][] tableroJugador, boolean acierto, boolean segundoAcierto, int direccionAnterior,int filaAnterior, int columnaAnterior, BarcosJugador barcosJugador, BarcosJugador barcosOrdenador){
        int filaOr = 1, columnaOr= 1, random = 0;
        boolean hundido = false;
        String letras = "ABCDEFGHIJ";
        Barco barcoTocado = null;
        char filaLetra = 'A';
        if (!acierto){
            filaLetra = (char) (Math.random()*10+'A');
            filaOr = Battleships.leerPosicionLetras(String.valueOf(filaLetra));
            columnaOr = (int) (Math.random()*(11 - 1)) + 1;
        }
        else {
            if (!segundoAcierto){
                random = (int) (Math.random()*(5 - 1)) + 1;
                switch (random) {
                    case 1 -> {
                        if ((filaAnterior + 1) != 11) {
                            filaOr = filaAnterior + 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            filaOr = filaAnterior - 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 2 -> {
                        if ((filaAnterior - 1) != 0) {
                            filaOr = filaAnterior - 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            filaOr = filaAnterior + 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 3 -> {
                        if ((columnaAnterior + 1) != 11) {
                            columnaOr = columnaAnterior + 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            columnaOr = columnaAnterior - 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 4 -> {
                        if ((columnaAnterior - 1) != 0) {
                            columnaOr = columnaAnterior - 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            columnaOr = columnaAnterior + 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                }
            }
            else {
                switch (direccionAnterior) {
                    case 1 -> {
                        if ((filaAnterior + 1) != 11) {
                            filaOr = filaAnterior + 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            filaOr = filaAnterior - 2;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 2 -> {
                        if ((filaAnterior - 1) != 0) {
                            filaOr = filaAnterior - 1;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            filaOr = filaAnterior + 2;
                            columnaOr = columnaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 3 -> {
                        if ((columnaAnterior + 1) != 11) {
                            columnaOr = columnaAnterior + 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            columnaOr = columnaAnterior - 2;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                    case 4 -> {
                        if ((columnaAnterior - 1) != 0) {
                            columnaOr = columnaAnterior - 1;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        } else {
                            columnaOr = columnaAnterior + 2;
                            filaOr = filaAnterior;
                            filaLetra = letras.charAt(filaOr-1);
                            break;
                        }
                    }
                }
            }
        }
        if (tableroJugador[filaOr-1][columnaOr-1] == 1){
            tableroJugador[filaOr-1][columnaOr-1] = 2;
            for (int i = 0; i < barcosJugador.getNumColocados(); i++){
                for (int j = 0; j < barcosJugador.getBarcosColocados()[i].getLonguitud(); j++){
                    if (barcosJugador.getBarcosColocados()[i].getPosicionFila()[j] == filaOr-1 && barcosJugador.getBarcosColocados()[i].getPosicionColumna()[j] == columnaOr-1){
                        barcoTocado = barcosJugador.getBarcosColocados()[i];
                        barcoTocado.tocar();
                        if (barcoTocado.getTocado() == barcoTocado.getLonguitud()){
                            barcosJugador.hundirBarco(i);
                            hundido = true;
                        }
                        break;
                    }
                }
            }
            if (hundido){
                System.out.print("\nTablero Ordenador --- ¡EL ORDENADOR HUNDIÓ UN BARCO DE TAMAÑO: "+barcoTocado.getLonguitud()+" Y EL ORDENADOR ACERTÓ EN ("+filaLetra+", "+columnaOr+"), JUEGA DE NUEVO!");
            }else {
                System.out.print("\nTablero Ordenador --- ¡EL ORDENADOR ACERTÓ EN ("+filaLetra+", "+columnaOr+"), JUEGA DE NUEVO!");
            }
            if (acierto == true){
                segundoAcierto = true;
                direccionAnterior = random;
            }
            if (barcosJugador.getNumHundidos() == 5){
                System.out.println("\n¡HA GANADO EL ORDENADOR, MÁS SUERTE LA PRÓXIMA VEZ!");
            }else{
                tableroJugador = turnoOrdenador(tableroJugador, true, segundoAcierto, direccionAnterior,filaOr, columnaOr, barcosJugador, barcosOrdenador);
            }
        }
        else if (tableroJugador[filaOr-1][columnaOr-1] == 0){
            tableroJugador[filaOr-1][columnaOr-1] = 3;
            System.out.println("\nTablero Ordenador --- ¡EL ORDENADOR FALLÓ EN ("+filaLetra+", "+columnaOr+")!");
        }
        else if (tableroJugador[filaOr-1][columnaOr-1] == 2 || tableroJugador[filaOr-1][columnaOr-1] == 3){
            if (direccionAnterior == 4){
                direccionAnterior = 3;
                columnaOr = columnaOr + 2;
            }else if (direccionAnterior == 3){
                direccionAnterior = 4;
                columnaOr = columnaOr - 2;
            }
            else if (direccionAnterior == 2){
                direccionAnterior = 1;
                filaOr = filaOr + 2;
            }
            else if (direccionAnterior == 1){
                direccionAnterior = 2;
                filaOr = filaOr - 2;
            }
            tableroJugador = turnoOrdenador(tableroJugador, acierto, segundoAcierto, direccionAnterior,filaOr, columnaOr, barcosJugador, barcosOrdenador);
        }
        return tableroJugador;
    }

    public static void mostrarTablero(int [][] tablero){
        String letras = "ABCDEFGHIJ";
        System.out.println("\t  1 2 3 4 5 6 7 8 9 10");
        System.out.print("\t");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (j == 0){
                    System.out.print(letras.charAt(i)+" ");
                }
                if(tablero[i][j] == 0){
                    System.out.print("^ ");
                }
                else if (tablero[i][j] == 1){
                    System.out.print("O ");
                }
                else if (tablero[i][j] == 2){
                    System.out.print("X ");
                }
                else if (tablero[i][j] == 3){
                    System.out.print("* ");
                }
            }
            if (i != tablero.length-1){
                System.out.println();
                System.out.print("\t");
            }
        }
    }

    public static void mostrarTableroOculto(int [][] tablero){
        String letras = "ABCDEFGHIJ";
        System.out.println("\t  1 2 3 4 5 6 7 8 9 10");
        System.out.print("\t");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j == 0){
                    System.out.print(letras.charAt(i)+" ");
                }
                if(tablero[i][j] == 0 || tablero[i][j] == 1){
                    System.out.print("^ ");
                }
                else if (tablero[i][j] == 2){
                    System.out.print("X ");
                }
                else if (tablero[i][j] == 3){
                    System.out.print("* ");
                }
            }
            if (i != tablero.length-1){
                System.out.println();
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    public static int[][] establecerBarcos(int[][] tablero, BarcosJugador barcosJugador){
        int contador = 0, posicion = -1, barcoacolocar = -1, opcion = -1, fila;
        boolean tengoBarco = false;
        String letraRecogida;
        Barco barcoActual = null;
        while (contador != 5){
            System.out.print("\nIntroduzca una fila para colocar su barco [A..J]: ");
            letraRecogida = teclado.next();
            fila = Battleships.leerPosicionLetras(letraRecogida);
            int columna = Battleships.leerPosicionNumeros(1,10);
            do {
                try {
                    System.out.print("\n¿Cuál es el tamaño del barco que quieres colocar? ");
                    barcoacolocar = Integer.parseInt(teclado.next());
                }catch (NumberFormatException ex){
                    System.out.print("Dato no válido "+ex.getMessage());
                }
            }while (barcoacolocar == -1);
            for (int i = 0; i < barcosJugador.getNumBarcos(); i++){
                if (barcosJugador.getBarcos()[i].getLonguitud() == barcoacolocar){
                    barcoActual = barcosJugador.getBarcos()[i];
                    posicion = i;
                    tengoBarco= true;
                    break;
                }
            }
            if (tengoBarco){
                System.out.print("\n¿Como lo quieres colocar?");
                System.out.print("\n1 - Hacia arriba\t\t\t2 - Hacia abajo\n3 - Hacia la izquierda\t\t4 - Hacia la derecha");
                do {
                    try {
                        System.out.print("\nElección: ");
                        opcion = Integer.parseInt(teclado.next());
                    }catch (NumberFormatException ex){
                        System.out.println("Dato no válido "+ex.getMessage());
                    }
                }while (opcion == -1);
                boolean comprobacion = Battleships.comprobarColocaccion(tablero,opcion,fila,columna,barcoacolocar,"jugador", barcoActual);
                if (comprobacion){
                    barcosJugador.moverBarco(posicion);
                    contador++;
                    if (contador == 5){
                        System.out.println("\nHas puesto: "+contador+" de 5 barcos");
                    }
                    else {
                        System.out.println("\nHas puesto: "+contador+" de 5 barcos\n");
                    }
                }
            }
            else{
                System.out.println("\nNo dispone de barcos de tamaño "+barcoacolocar+"\n");
            }
            tengoBarco = false;
            barcoacolocar = -1;
            opcion = -1;
            System.out.println("Tablero Jugador");
            Battleships.mostrarTablero(tablero);
        }
        return tablero;
    }

    public static int[][] establecerBarcosOrdenador(int[][] tablero, BarcosJugador barcosOrdenador){
        int contador = 0, posicion = -1;
        Barco barcoActual = null;
        boolean tengoBarco = false;
        while (contador != 5){
            char filaLetra = (char) (Math.random()*10+'A');
            int fila = Battleships.leerPosicionLetras(String.valueOf(filaLetra));
            int columna = (int) (Math.random()*(11 - 1)) + 1;
            int barcoacolocar = (int) (Math.random()*(6 - 1)) + 1;
            for (int i = 0; i < barcosOrdenador.getNumBarcos(); i++){
                if (barcosOrdenador.getBarcos()[i].getLonguitud() == barcoacolocar){
                    barcoActual = barcosOrdenador.getBarcos()[i];
                    posicion = i;
                    tengoBarco= true;
                    break;
                }
            }
            if (tengoBarco){
                int opcion = (int) (Math.random()*(5 - 1)) + 1;
                boolean comprobacion = Battleships.comprobarColocaccion(tablero,opcion,fila,columna,barcoacolocar,"ordenador", barcoActual);
                if (comprobacion){
                    barcosOrdenador.moverBarco(posicion);
                    contador++;
                }
            }
            tengoBarco = false;
        }
        return tablero;
    }

    public static int leerPosicionLetras(String opcionletra){
        int opcion = -1;
        String letras = "ABCDEFGHIJ";
        do {
            for (int i = 0; i < letras.length(); i++){
                if (String.valueOf(letras.charAt(i)).equals(opcionletra)){
                    opcion = i+1;
                    return opcion;
                }
            }
            System.out.println("Recuerda que es una letra y en mayúsculas");
            System.out.print("\nIntroduzca una fila para colocar su barco de  [A..J]: ");
            opcionletra = teclado.next();
        } while (opcion == -1);
        return opcion;
    }

    public static int leerPosicionNumeros(int minimo, int maximo){
        int entero = -1;
        do {
            try {
                System.out.print("Introduzca una columna para colocar su barco [1..10]: ");
                entero = Integer.parseInt(teclado.next());
            }catch (NumberFormatException ex){
                System.out.println("Dato no válido "+ex.getMessage());
            }
        } while(entero < minimo || entero > maximo);
        return entero;
    }

    public static boolean comprobarColocaccion(int[][] tablero, int opcion,int fila,int columna,int barcoacolocar, String pertenece, Barco barcoActual){
        int versiesvalido = 0;
        if (opcion == 1){
            if (fila < barcoacolocar){
                if (pertenece.equals("jugador")){
                    System.out.println("\nBarco demasiado grande para esta posición, pruebe a colocarlo de nuevo\n");
                }
                return false;
            }
            else {
                if (tablero[fila-1][columna-1] != 1){
                    for(int j = fila-1;j > fila-1-barcoacolocar;j--){
                        if(tablero[j][columna-1] != 1){
                            versiesvalido++;
                        }
                    }
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
                if (versiesvalido == barcoacolocar){
                    for(int j = fila-1;j > fila-1-barcoacolocar;j--){
                        barcoActual.añadirFila(j);
                        barcoActual.añadirColumna(columna-1);
                        tablero[j][columna-1] = 1;
                    }
                    return true;
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
            }
        }
        if (opcion == 2){
            if (fila-1+barcoacolocar > 10){
                if (pertenece.equals("jugador")){
                    System.out.println("\nBarco demasiado grande para esta posición, pruebe a colocarlo de nuevo\n");
                }
                return false;
            }
            else {
                if (tablero[fila-1][columna-1] != 1){
                    for(int j = fila-1;j < fila-1+barcoacolocar;j++){
                        if(tablero[j][columna-1] != 1){
                            versiesvalido++;
                        }
                    }
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
                if (versiesvalido == barcoacolocar){
                    for(int j = fila-1;j < fila-1+barcoacolocar;j++){
                        barcoActual.añadirFila(j);
                        barcoActual.añadirColumna(columna-1);
                        tablero[j][columna-1] = 1;
                    }
                    return true;
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
            }
        }
        if (opcion == 3){
            if (columna < barcoacolocar){
                if (pertenece.equals("jugador")){
                    System.out.println("\nBarco demasiado grande para esta posición, pruebe a colocarlo de nuevo\n");
                }
                return false;
            }
            else {
                if (tablero[fila-1][columna-1] != 1){
                    for(int j = columna-1; j > columna-1-barcoacolocar;j--){
                        if(tablero[fila-1][j] != 1){
                            versiesvalido++;
                        }
                    }
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
                if (versiesvalido == barcoacolocar){
                    for(int j = columna-1; j > columna-1-barcoacolocar;j--){
                        barcoActual.añadirFila(fila-1);
                        barcoActual.añadirColumna(j);
                        tablero[fila-1][j] = 1;
                    }
                    return true;
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
            }
        }
        if (opcion == 4){
            if (columna-1+barcoacolocar > 10){
                if (pertenece.equals("jugador")){
                    System.out.println("\nBarco demasiado grande para esta posición, pruebe a colocarlo de nuevo\n");
                }
                return false;
            }
            else {
                if (tablero[fila-1][columna-1] != 1){
                    for(int j = columna-1; j < columna-1+barcoacolocar;j++){
                        if(tablero[fila-1][j] != 1){
                            versiesvalido++;
                        }
                    }
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
                if (versiesvalido == barcoacolocar){
                    for(int j = columna-1; j < columna-1+barcoacolocar;j++){
                        barcoActual.añadirFila(fila-1);
                        barcoActual.añadirColumna(j);
                        tablero[fila-1][j] = 1;
                    }
                    return true;
                }
                else{
                    if (pertenece.equals("jugador")){
                        System.out.println("\nYa hay un barco en estas casillas\n");
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
