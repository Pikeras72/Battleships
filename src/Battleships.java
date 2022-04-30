import java.util.Scanner;
//Made by: DIEGO RUIZ PIQUERAS
public class Battleships {

    static Scanner teclado = new Scanner(System.in);

    public static void main (String[] args){Battleships.execute();}

    public static void execute(){
        int[][] playerTable = new int[10][10];                         //Create the player's table
        int[][] computerTable = new int[10][10];                       //Create the computer's table
        Battleships.banner();                                             //Print the game banner
        int x = Battleships.modeSelection();                              //Ask for a game mode
        if (x == 1){                                                      //Game mode 1
            System.out.print("\nBoats available:\n");
            System.out.print("\n*****   ****   ***   **   **\n\n");
            Battleships.mode1(playerTable, computerTable);
        }
        else if (x == 2){                                                 //Game mode 2
            System.out.print("\nBoats available:\n");
            System.out.print("\n****   ***   **   **   **\n");
            Battleships.mode2(playerTable, computerTable);
        }
        else if (x == 3){                                                 //Game mode 3
            System.out.print("\nBoats available:\n");
            System.out.print("\n***   **   **   **   **\n\n");
            Battleships.mode3(playerTable, computerTable);
        }
        else{                                                             //Game mode 4
            System.out.print("\nBoats available:\n");
            System.out.print("\n**   **   **   **   **\n\n");
            Battleships.mode4(playerTable, computerTable);
        }
    }

    public static void banner(){
        System.out.println(",-----.          ,--.   ,--. ,--.           ,--.    ,--.             ");
        System.out.println("|  |) /_ ,--,--,-'  '-,-'  '-|  |,---. ,---.|  ,---.`--',---. ,---.  ");
        System.out.println("|  .-.  ' ,-.  '-.  .-'-.  .-|  | .-. (  .-'|  .-.  ,--| .-. (  .-'                 |         BY           |");
        System.out.println("|  '--' \\ '-'  | |  |   |  | |  \\   --.-'  `|  | |  |  | '-' .-'  `)                |     DIEGO RUIZ P.    |");
        System.out.println("`------' `--`--' `--'   `--' `--'`----`----'`--' `--`--|  |-'`----'  ");
        System.out.println("                                                       `--'          ");
    }

    public static int modeSelection(){
        int election = -1;
        System.out.println("\n\tWhich mode would you like to chose?");                //Ask the player to choose a game mode
        System.out.println("\n\t1 - Classic (3 different boats and 2 equals)\t\t2 - Intermediate (2 different boats and 3 equals)\n\n\t3- Advanced (1 different boats and 4 equals)\t\t4 - Complicated (5 equal boats) \n");
        do{                                                                              //While the player have not chose a mode...
            try {
                System.out.print("Election: ");
                election = Integer.parseInt(teclado.nextLine());                         //Store the player's election
            }catch (NumberFormatException ex){                                           //If the Integer.parseInt() fails because the input has a letter or a symbol...
                System.out.println("Invalid data "+ex.getMessage());                   //Notify the not valid input
            }
        }while (election < 1 || election > 4);                                           //While the election is not one the program asked for (1,2,3,4)...
        System.out.println("\nPerfect. This your election: "+ election);        //Shows the election the player have chosen
        return election;
    }

    public static void mode1(int [][] playerTable, int[][] computerTable){
        Boat boatp0 = new Boat(5);
        Boat boatp1 = new Boat(4);
        Boat boatp2 = new Boat(3);
        Boat boatp3 = new Boat(2);
        Boat boatp4 = new Boat(2);
        Boat boatc0 = new Boat(5);
        Boat boatc1 = new Boat(4);
        Boat boatc2 = new Boat(3);
        Boat boatc3 = new Boat(2);
        Boat boatc4 = new Boat(2);
        PlayersBoats playerBoats = new PlayersBoats();
        PlayersBoats computerBoats = new PlayersBoats();
        playerBoats.addBoat(boatp0);
        playerBoats.addBoat(boatp1);
        playerBoats.addBoat(boatp2);
        playerBoats.addBoat(boatp3);
        playerBoats.addBoat(boatp4);
        computerBoats.addBoat(boatc0);
        computerBoats.addBoat(boatc1);
        computerBoats.addBoat(boatc2);
        computerBoats.addBoat(boatc3);
        computerBoats.addBoat(boatc4);
        play(playerTable,computerTable,playerBoats,computerBoats);
    }

    public static void mode2(int [][] playerTable, int[][] computerTable){
        Boat boatp0 = new Boat(4);
        Boat boatp1 = new Boat(3);
        Boat boatp2 = new Boat(2);
        Boat boatp3 = new Boat(2);
        Boat boatp4 = new Boat(2);
        Boat boatc0 = new Boat(4);
        Boat boatc1 = new Boat(3);
        Boat boatc2 = new Boat(2);
        Boat boatc3 = new Boat(2);
        Boat boatc4 = new Boat(2);
        PlayersBoats playerBoats = new PlayersBoats();
        PlayersBoats computerBoats = new PlayersBoats();
        playerBoats.addBoat(boatp0);
        playerBoats.addBoat(boatp1);
        playerBoats.addBoat(boatp2);
        playerBoats.addBoat(boatp3);
        playerBoats.addBoat(boatp4);
        computerBoats.addBoat(boatc0);
        computerBoats.addBoat(boatc1);
        computerBoats.addBoat(boatc2);
        computerBoats.addBoat(boatc3);
        computerBoats.addBoat(boatc4);
        play(playerTable, computerTable, playerBoats, computerBoats);
    }

    public static void mode3(int [][] playerTable, int[][] computerTable){
        Boat boatp0 = new Boat(3);
        Boat boatp1 = new Boat(2);
        Boat boatp2 = new Boat(2);
        Boat boatp3 = new Boat(2);
        Boat boatp4 = new Boat(2);
        Boat boatc0 = new Boat(3);
        Boat boatc1 = new Boat(2);
        Boat boatc2 = new Boat(2);
        Boat boatc3 = new Boat(2);
        Boat boatc4 = new Boat(2);
        PlayersBoats playerBoats = new PlayersBoats();
        PlayersBoats computerBoats = new PlayersBoats();
        playerBoats.addBoat(boatp0);
        playerBoats.addBoat(boatp1);
        playerBoats.addBoat(boatp2);
        playerBoats.addBoat(boatp3);
        playerBoats.addBoat(boatp4);
        computerBoats.addBoat(boatc0);
        computerBoats.addBoat(boatc1);
        computerBoats.addBoat(boatc2);
        computerBoats.addBoat(boatc3);
        computerBoats.addBoat(boatc4);
        play(playerTable, computerTable, playerBoats, computerBoats);
    }

    public static void mode4(int [][] playerTable, int[][] computerTable){
        Boat boatp0 = new Boat(2);
        Boat boatp1 = new Boat(2);
        Boat boatp2 = new Boat(2);
        Boat boatp3 = new Boat(2);
        Boat boatp4 = new Boat(2);
        Boat boatc0 = new Boat(2);
        Boat boatc1 = new Boat(2);
        Boat boatc2 = new Boat(2);
        Boat boatc3 = new Boat(2);
        Boat boatc4 = new Boat(2);
        PlayersBoats playerBoats = new PlayersBoats();
        PlayersBoats computerBoats = new PlayersBoats();
        playerBoats.addBoat(boatp0);
        playerBoats.addBoat(boatp1);
        playerBoats.addBoat(boatp2);
        playerBoats.addBoat(boatp3);
        playerBoats.addBoat(boatp4);
        computerBoats.addBoat(boatc0);
        computerBoats.addBoat(boatc1);
        computerBoats.addBoat(boatc2);
        computerBoats.addBoat(boatc3);
        computerBoats.addBoat(boatc4);
        play(playerTable, computerTable, playerBoats, computerBoats);
    }

    public static void play(int[][] playerTable, int[][] computerTable, PlayersBoats playerBoats, PlayersBoats computerBoats){
        boolean playerTurn, computerTurn;
        Battleships.showTable(playerTable, computerTable);
        establishBoats(playerTable, playerBoats, computerTable);
        establishComputerBoats(computerTable, computerBoats);
        while (playerBoats.getSunkenNum() != 5 && computerBoats.getSunkenNum() != 5){
            do {
                playerTurn = playerTurn(computerTable, playerTable, computerBoats);
            }while (playerTurn);
            if (computerBoats.getSunkenNum() != 5){
                do {
                    computerTurn = computerTurn(playerTable, playerBoats);
                }while (computerTurn);
                Battleships.showTable(playerTable, computerTable);
            }
        }
    }

    public static boolean playerTurn(int [][] computerTable, int[][] playerTable, PlayersBoats computerBoats){
        Boat touchedBoat = null;
        String letters = "ABCDEFGHIJ";
        boolean sunken = false, turn = false;
        int row;
        String pickedLetter;
        System.out.print("Introduce a row [A..J]: ");
        pickedLetter = teclado.next();
        row = Battleships.readLetterPosition(pickedLetter);
        pickedLetter = String.valueOf(letters.charAt(row - 1));
        int column = Battleships.readNumberPosition(1,10);
        if (computerTable[row -1][column -1] == 1){
            computerTable[row -1][column -1] = 2;
            for (int i = 0; i < computerBoats.getPlacedNum() && !turn; i++){
                for (int j = 0; j < computerBoats.getPlacedBoats()[i].getBoatLength(); j++){
                    if (computerBoats.getPlacedBoats()[i].getRowPosition()[j] == row -1 && computerBoats.getPlacedBoats()[i].getColumnPosition()[j] == column -1){
                        touchedBoat = computerBoats.getPlacedBoats()[i];
                        touchedBoat.tocar();
                        if (touchedBoat.getTouched() == touchedBoat.getBoatLength()){
                            computerBoats.sunkBoat();
                            sunken = true;
                        }
                        turn = true;
                        break;
                    }
                }
            }
            if (sunken){
                System.out.println("¡FINALLY! SUNKEN BOAT LENGTH: "+ touchedBoat.getBoatLength()+" AT ("+ pickedLetter +", "+ column +"), YOUR TURN AGAIN!");
            }else {
                System.out.println("¡BOAT HIT AT ("+ pickedLetter +", "+ column +"), YOUR TURN AGAIN!");
            }
            Battleships.showTable(playerTable, computerTable);
            if (computerBoats.getSunkenNum() == 5){
                System.out.println("\n¡CONGRATULATIONS, YOU WIN THE COMPUTER!");
                turn = false;
            }
        }
        else if (computerTable[row -1][column -1] == 0){
            computerTable[row -1][column -1] = 3;
            System.out.println("¡NOTHING HIT AT ("+ pickedLetter +", "+ column +")!");
        }
        else if (computerTable[row -1][column -1] == 2 || computerTable[row -1][column -1] == 3){
            System.out.println("¡YOU HAVE ALREADY HIT THIS POSITION, TRY ANOTHER ONE!");
            turn = true;
            Battleships.showTable(playerTable, computerTable);
        }
        return turn;
    }

    public static boolean computerTurn(int [][] playerTable, PlayersBoats playerBoats){
        int rowComputer, columnComputer, cnt = 0;
        boolean sunk = false, turn = false, cnt1 = false, cnt2 = false, cnt3 = false;
        Boat touchedBoat = null;
        String letters = "ABCDEFGHIJ";
        char letterRow;
        if (!playerBoats.isHit()){
            letterRow = (char) (Math.random()*10+'A');
            rowComputer = readLetterPosition(String.valueOf(letterRow));
            columnComputer = (int) (Math.random()*(11 - 1)) + 1;
        }else{
            rowComputer = playerBoats.getRowHit();
            columnComputer = playerBoats.getColumnHit();
            while (playerTable[rowComputer -1][columnComputer -1] == 2 || playerTable[rowComputer -1][columnComputer -1] == 3){
                if (cnt == 0 && rowComputer+1 != 11){
                    rowComputer++;
                    cnt1 = true;
                }else if(cnt == 1 && columnComputer+1 != 11){
                    if (cnt1){
                        rowComputer--;
                    }
                    columnComputer++;
                    cnt2 = true;
                }else if(cnt == 2 && columnComputer-1 != 0){
                    if (cnt2  && columnComputer-2 != 0){
                        columnComputer--;
                        columnComputer--;
                    }else if (cnt1){
                        rowComputer--;
                        columnComputer--;
                    }else{
                        columnComputer--;
                    }
                    cnt3 = true;
                }else if(cnt == 3 && rowComputer-1 != 0){
                    if (cnt3){
                        columnComputer++;
                        rowComputer--;
                    }else if(cnt2){
                        columnComputer--;
                        rowComputer--;
                    }else if(cnt1){
                        rowComputer--;
                        rowComputer--;
                    }else{
                        rowComputer--;
                    }
                }else if (cnt > 3){
                    letterRow = (char) (Math.random()*10+'A');
                    rowComputer = readLetterPosition(String.valueOf(letterRow));
                    columnComputer = (int) (Math.random()*(11 - 1)) + 1;
                }
                cnt++;
            }
            letterRow = letters.charAt(rowComputer-1);
        }
        if (playerTable[rowComputer -1][columnComputer -1] == 1){
            playerTable[rowComputer -1][columnComputer -1] = 2;
            for (int i = 0; i < playerBoats.getPlacedNum() && !turn; i++){
                for (int j = 0; j < playerBoats.getPlacedBoats()[i].getBoatLength(); j++){
                    if (playerBoats.getPlacedBoats()[i].getRowPosition()[j] == rowComputer -1 && playerBoats.getPlacedBoats()[i].getColumnPosition()[j] == columnComputer -1){
                        touchedBoat = playerBoats.getPlacedBoats()[i];
                        touchedBoat.tocar();
                        if (touchedBoat.getTouched() == touchedBoat.getBoatLength()){
                            playerBoats.sunkBoat();
                            sunk = true;
                        }
                        turn = true;
                        break;
                    }
                }
            }
            if (sunk){
                System.out.println("¡THE COMPUTER SUNK A BOAT OF LENGTH: "+ touchedBoat.getBoatLength()+" AT ("+ letterRow +", "+ columnComputer +"), PLAYS AGAIN!");
                playerBoats.setHit(false);
            }else {
                System.out.println("¡THE COMPUTER HIT A BOAT AT ("+ letterRow +", "+ columnComputer +"), PLAYS AGAIN!");
                playerBoats.setHit(true);
                playerBoats.setRowHit(rowComputer);
                playerBoats.setColumnHit(columnComputer);
            }
            if (playerBoats.getSunkenNum() == 5){
                System.out.println("¡THE COMPUTER WON, MORE LUCK NEXT TIME!");
                turn = false;
            }
        }
        else if (playerTable[rowComputer -1][columnComputer -1] == 0){
            if (playerBoats.isHit() && cnt > 4){
                playerBoats.setHit(false);
            }
            playerTable[rowComputer -1][columnComputer -1] = 3;
            System.out.println("¡THE COMPUTER MISS AT ("+ letterRow +", "+ columnComputer +")!");
        }
        else if (playerTable[rowComputer -1][columnComputer -1] == 2 || playerTable[rowComputer -1][columnComputer -1] == 3){
            turn = true;
        }
        return turn;
    }

    public static void showTable(int [][] playerTable, int[][] computerTable){
        String letters = "ABCDEFGHIJ";
        System.out.println("Player Table\t\t\t\t\t\t Computer Table");
        System.out.println("\t  1 2 3 4 5 6 7 8 9 10\t\t\t\t  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < playerTable.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < playerTable[i].length; j++) {
                if (j == 0){
                    System.out.print(letters.charAt(i)+" ");
                }
                if(playerTable[i][j] == 0){
                    System.out.print("^ ");
                }
                else if (playerTable[i][j] == 1){
                    System.out.print("O ");
                }
                else if (playerTable[i][j] == 2){
                    System.out.print("X ");
                }
                else if (playerTable[i][j] == 3) {
                    System.out.print("* ");
                }
            }
            System.out.print("\t\t\t\t");
            for (int j = 0; j < computerTable[i].length; j++) {
                if (j == 0){
                    System.out.print(letters.charAt(i)+" ");
                }
                if(computerTable[i][j] == 0 || computerTable[i][j] == 1) {
                    System.out.print("^ ");
                }else if (computerTable[i][j] == 2){
                    System.out.print("X ");
                }
                else if (computerTable[i][j] == 3) {
                    System.out.print("* ");
                }
            }
            if (i != computerTable.length-1){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void establishBoats(int[][] table, PlayersBoats playerBoats, int[][] computerTable){
        int counter = 0, position = -1, boatToPlace = -1, option = -1, row;
        boolean gotBoat = false;
        String letterReaded;
        Boat boatActual = null;
        while (counter != 5){
            System.out.print("\nIntroduce a row to place your boat [A..J]: ");
            letterReaded = teclado.next();
            row = Battleships.readLetterPosition(letterReaded);
            int column = Battleships.readNumberPosition(1,10);
            do {
                try {
                    System.out.print("\n¿Length of the boat you want to place? ");
                    boatToPlace = Integer.parseInt(teclado.next());
                }catch (NumberFormatException ex){
                    System.out.print("Invalid data "+ex.getMessage());
                }
            }while (boatToPlace == -1);
            for (int i = 0; i < playerBoats.getBoatsNum(); i++){
                if (playerBoats.getBarcos()[i].getBoatLength() == boatToPlace){
                    boatActual = playerBoats.getBarcos()[i];
                    position = i;
                    gotBoat = true;
                    break;
                }
            }
            if (gotBoat){
                System.out.print("\n¿What direction should it take?");
                System.out.print("\n1 - Pointing North\t\t\t2 - Pointing South\n3 - Pointing West\t\t\t4 - Pointing East");
                do {
                    try {
                        System.out.print("\nElection: ");
                        option = Integer.parseInt(teclado.next());
                    }catch (NumberFormatException ex){
                        System.out.println("Invalid data "+ex.getMessage());
                    }
                }while (option == -1);
                boolean check = Battleships.checkPosition(table, option, row, column, boatToPlace,"player", boatActual);
                if (check){
                    playerBoats.moveBoat(position);
                    counter++;
                    if (counter == 5){
                        System.out.println("\nYou have placed: "+ counter +" out of 5 boats");
                    }
                    else {
                        System.out.println("\nYou have placed: "+ counter +" out of 5 boats\n");
                    }
                }
            }
            else{
                System.out.println("\nThere are not more boats of this length: "+ boatToPlace +"\n");
            }
            gotBoat = false;
            boatToPlace = -1;
            option = -1;
            Battleships.showTable(table, computerTable);
        }
    }

    public static void establishComputerBoats(int[][] table, PlayersBoats computerBoats){
        int counter = 0, position = -1;
        Boat actualBoat = null;
        boolean haveBoat = false;
        while (counter != 5){
            char letterRow = (char) (Math.random()*10+'A');
            int row = Battleships.readLetterPosition(String.valueOf(letterRow));
            int column = (int) (Math.random()*(11 - 1)) + 1;
            int boatToPlace = (int) (Math.random()*(6 - 1)) + 1;
            for (int i = 0; i < computerBoats.getBoatsNum(); i++){
                if (computerBoats.getBarcos()[i].getBoatLength() == boatToPlace){
                    actualBoat = computerBoats.getBarcos()[i];
                    position = i;
                    haveBoat = true;
                    break;
                }
            }
            if (haveBoat){
                int option = (int) (Math.random()*(5 - 1)) + 1;
                boolean check = Battleships.checkPosition(table, option, row, column, boatToPlace,"computer", actualBoat);
                if (check){
                    computerBoats.moveBoat(position);
                    counter++;
                }
            }
            haveBoat = false;
        }
    }

    public static int readLetterPosition(String letterOption){
        int option;
        String letters = "ABCDEFGHIJ";
        do {
            for (int i = 0; i < letters.length(); i++){
                if (String.valueOf(letters.charAt(i)).equals(letterOption)){
                    option = i+1;
                    return option;
                }
            }
            System.out.println("Remember to introduce a letter");
            System.out.print("\nIntroduce a row to place your boat [A..J]: ");
            letterOption = teclado.next();
        } while (true);
    }

    public static int readNumberPosition(int min, int max){
        int number = -1;
        do {
            try {
                System.out.print("Introduce a column to place your boat [1..10]: ");
                number = Integer.parseInt(teclado.next());
            }catch (NumberFormatException ex){
                System.out.println("Invalid data "+ex.getMessage());
            }
        } while(number < min || number > max);
        return number;
    }

    public static boolean checkPosition(int[][] table, int option, int row, int column, int boatToPlace, String belongs, Boat actualBoat){
        int isValid = 0;
        if (option == 1){
            if (row < boatToPlace){
                if (belongs.equals("player")){
                    System.out.println("\nBoat too big for this position, try to place it in other location\n");
                }
                return false;
            }
            else {
                if (table[row -1][column -1] != 1){
                    for(int j = row -1; j > row -1- boatToPlace; j--){
                        if(table[j][column -1] != 1){
                            isValid++;
                        }
                    }
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
                if (isValid == boatToPlace){
                    for(int j = row -1; j > row -1- boatToPlace; j--){
                        actualBoat.addRow(j);
                        actualBoat.addColumn(column -1);
                        table[j][column -1] = 1;
                    }
                    return true;
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
            }
        }
        if (option == 2){
            if (row -1+ boatToPlace > 10){
                if (belongs.equals("player")){
                    System.out.println("\nBoat too big for this position, try to place it in other location\n");
                }
                return false;
            }
            else {
                if (table[row -1][column -1] != 1){
                    for(int j = row -1; j < row -1+ boatToPlace; j++){
                        if(table[j][column -1] != 1){
                            isValid++;
                        }
                    }
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
                if (isValid == boatToPlace){
                    for(int j = row -1; j < row -1+ boatToPlace; j++){
                        actualBoat.addRow(j);
                        actualBoat.addColumn(column -1);
                        table[j][column -1] = 1;
                    }
                    return true;
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
            }
        }
        if (option == 3){
            if (column < boatToPlace){
                if (belongs.equals("player")){
                    System.out.println("\nBoat too big for this position, try to place it in other location\n");
                }
                return false;
            }
            else {
                if (table[row -1][column -1] != 1){
                    for(int j = column -1; j > column -1- boatToPlace; j--){
                        if(table[row -1][j] != 1){
                            isValid++;
                        }
                    }
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
                if (isValid == boatToPlace){
                    for(int j = column -1; j > column -1- boatToPlace; j--){
                        actualBoat.addRow(row -1);
                        actualBoat.addColumn(j);
                        table[row -1][j] = 1;
                    }
                    return true;
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
            }
        }
        if (option == 4){
            if (column -1+ boatToPlace > 10){
                if (belongs.equals("player")){
                    System.out.println("\nBoat too big for this position, try to place it in other location\n");
                }
                return false;
            }
            else {
                if (table[row -1][column -1] != 1){
                    for(int j = column -1; j < column -1+ boatToPlace; j++){
                        if(table[row -1][j] != 1){
                            isValid++;
                        }
                    }
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
                if (isValid == boatToPlace){
                    for(int j = column -1; j < column -1+ boatToPlace; j++){
                        actualBoat.addRow(row -1);
                        actualBoat.addColumn(j);
                        table[row -1][j] = 1;
                    }
                    return true;
                }
                else{
                    if (belongs.equals("player")){
                        System.out.println("\nThere is already a boat on this position\n");
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
