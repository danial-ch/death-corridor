package ir.ac.kntu;

import java.util.Scanner;

public class Main {
    public static void main(String []args) throws InterruptedException {
        starter();
    }

    public static void starter() throws InterruptedException {
        while (true){
            Scanner input= new Scanner(System.in);
            System.out.println("Enter number of corridors for each side to begin the game");
            System.out.println("Enter -1 to exit the game");
            int size=input.nextInt();
            if(size==-1){
                break;
            }
            else{
                ir.ac.kntu.gameLogic.GameLogic.starter(size);
            }
        }
    }
}
