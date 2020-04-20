package ir.ac.kntu.gameLogic;

import ir.ac.kntu.*;
import ir.ac.kntu.Soldier;

import java.util.LinkedList;

public class GameLogic {

    public static LinkedList<Soldier> blueTeam = new LinkedList<>();
    public static LinkedList<Soldier> redTeam = new LinkedList<>();

    public static void starter(int corridorSize) throws InterruptedException {

        blueTeam.clear();
        redTeam.clear();

        for(int i=0;i<corridorSize;i++){
            Soldier soldier;
            if(RandomHelper.nextInt(100)>30){
                AssaultRifle assaultRifle= new AssaultRifle();
                soldier=new Soldier(i+1,true,assaultRifle);
            }
            else{
                SniperRifle sniperRifle = new SniperRifle();
                soldier=new Soldier(i+1,true,sniperRifle);
            }
            blueTeam.add(soldier);
        }

        for(int i=0;i<corridorSize;i++){
            Soldier soldier;
            if(RandomHelper.nextInt(100)>30){
                AssaultRifle assaultRifle= new AssaultRifle();
                soldier=new Soldier(i+1,false,assaultRifle);
            }
            else{
                SniperRifle sniperRifle = new SniperRifle();
                soldier=new Soldier(i+1,false,sniperRifle);
            }
            redTeam.add(soldier);
        }
        startRound(1,corridorSize);
    }

    public static void startRound(int roundNumber,int corridorSize) throws InterruptedException {
        int zoomChance,firstSoldierChoice,secondSoldierChoice;
        System.out.println("***************************************************");
        System.out.println("------------------{Round " + roundNumber + "}-------------------");

        do{
            firstSoldierChoice=RandomHelper.nextInt(corridorSize);
        }
        while (blueTeam.get(firstSoldierChoice).isDead());

        do{
            secondSoldierChoice=RandomHelper.nextInt(corridorSize);
        }
        while (redTeam.get(secondSoldierChoice).isDead());

        Soldier firstSoldier = blueTeam.get(firstSoldierChoice);
        Soldier secondSoldier = redTeam.get(secondSoldierChoice);

        firstSoldierChoice++;
        secondSoldierChoice++;

        System.out.print("Blue solider number "+firstSoldierChoice+" has a");

        if (firstSoldier.getGun().getClass().getSimpleName().equals("SniperRifle")) {
            System.out.print(" sniper rifle");
            if (RandomHelper.nextBoolean()) {
                ((SniperRifle) firstSoldier.getGun()).setZoom(true);
                System.out.print(" with zoom on and is using");
                zoomChance=RandomHelper.nextInt(10)+5;
                firstSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+zoomChance);
                if (RandomHelper.nextBoolean()) {
                    firstSoldier.getGun().setHighCalibre(true);
                    System.out.print(" 7mm ammo better watch out\n");
                    firstSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                    firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
                }
                else {
                    firstSoldier.getGun().setHighCalibre(false);
                    System.out.print(" 5mm ammo\n");
                    firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
                }
            }
            else {
                ((SniperRifle) firstSoldier.getGun()).setZoom(false);
                System.out.print(" without zoom and is using");
                if (RandomHelper.nextBoolean()) {
                    firstSoldier.getGun().setHighCalibre(true);
                    System.out.print(" 7mm ammo\n");
                    firstSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                    firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
                }
                else {
                    firstSoldier.getGun().setHighCalibre(false);
                    System.out.print(" 5mm ammo\n");
                    firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
                }
            }
        }
        else {
            System.out.print(" assault rifle and is using ");
            if (RandomHelper.nextBoolean()) {
                firstSoldier.getGun().setHighCalibre(true);
                System.out.print(" 7mm ammo\n");
                firstSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
            }
            else {
                firstSoldier.getGun().setHighCalibre(false);
                System.out.print(" 5mm ammo\n");
                firstSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
            }
        }

        System.out.print("Red solider number "+secondSoldierChoice+" has a");

        if (secondSoldier.getGun().getClass().getSimpleName().equals("SniperRifle")) {
            System.out.print(" sniper rifle");
            if (RandomHelper.nextBoolean()) {
                ((SniperRifle) secondSoldier.getGun()).setZoom(true);
                System.out.print(" with zoom on and is using");
                zoomChance=RandomHelper.nextInt(10)+5;
                secondSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+zoomChance);
                if (RandomHelper.nextBoolean()) {
                    secondSoldier.getGun().setHighCalibre(true);
                    System.out.print(" 7mm ammo better watch out\n");
                    secondSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                    secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
                }
                else {
                    secondSoldier.getGun().setHighCalibre(false);
                    System.out.print(" 5mm ammo\n");
                    secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
                }
            }
            else {
                ((SniperRifle) secondSoldier.getGun()).setZoom(false);
                System.out.print(" without zoom and is using");
                if (RandomHelper.nextBoolean()) {
                    secondSoldier.getGun().setHighCalibre(true);
                    System.out.print(" 7mm ammo\n");
                    secondSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                    secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
                }
                else {
                    secondSoldier.getGun().setHighCalibre(false);
                    System.out.print(" 5mm ammo\n");
                    secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
                }
            }
        }
        else {
            System.out.print(" assault rifle and is using ");
            if (RandomHelper.nextBoolean()) {
                secondSoldier.getGun().setHighCalibre(true);
                System.out.print(" 7mm ammo\n");
                secondSoldier.getGun().setDamage(firstSoldier.getGun().getDamage()+10);
                secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()-10);
            }
            else {
                secondSoldier.getGun().setHighCalibre(false);
                System.out.print(" 5mm ammo\n");
                secondSoldier.getGun().setHitRate(firstSoldier.getGun().getHitRate()+15);
            }
        }
        Thread.sleep(1000);
        boolean firstSoldierHit= RandomHelper.nextInt(100) < firstSoldier.getGun().getHitRate();
        boolean secondSoldierHit= RandomHelper.nextInt(100) < secondSoldier.getGun().getHitRate();
        if(RandomHelper.nextBoolean()){
            //first soldier attacked first
            System.out.print("Blue soldier attacked first");
            if(firstSoldierHit){
                System.out.print(" and dealt "+firstSoldier.getGun().getDamage()+" damage\n");
                secondSoldier.setHealth(secondSoldier.getHealth()-firstSoldier.getGun().getDamage());
                if(secondSoldier.getHealth()<=0){
                    System.out.println("Red soldier died");
                    secondSoldier.setDead(true);
                }
                if(!secondSoldier.isDead()){
                    System.out.print("Red soldier lived and attacked");
                    if(secondSoldierHit){
                        System.out.print(" and dealt "+secondSoldier.getGun().getDamage()+" damage\n");
                        firstSoldier.setHealth(firstSoldier.getHealth()-secondSoldier.getGun().getDamage());
                        if(firstSoldier.getHealth()<=0){
                            System.out.println("Blue soldier died");
                            firstSoldier.setDead(true);
                        }
                    }
                    else{
                        System.out.print(" but failed to hit\n");
                    }
                }
            }
            else{
                System.out.print(" but failed to hit\n");
                System.out.print("Red soldier attacked");
                if(secondSoldierHit){
                    System.out.print(" and dealt "+secondSoldier.getGun().getDamage()+" damage\n");
                    firstSoldier.setHealth(firstSoldier.getHealth()-secondSoldier.getGun().getDamage());
                    if(firstSoldier.getHealth()<=0){
                        System.out.println("Blue soldier died");
                        firstSoldier.setDead(true);
                    }
                }
                else{
                    System.out.print(" but also failed to hit lol\n");
                }
            }
        }
        else {
            //second soldier attacked first
            System.out.print("Red soldier attacked first");
            if(secondSoldierHit){
                System.out.print(" and dealt "+secondSoldier.getGun().getDamage()+" damage\n");
                firstSoldier.setHealth(secondSoldier.getHealth()-secondSoldier.getGun().getDamage());
                if(firstSoldier.getHealth()<=0){
                    System.out.println("Blue soldier died");
                    firstSoldier.setDead(true);
                }
                if(!firstSoldier.isDead()){
                    System.out.print("Blue soldier lived and attacked");
                    if(firstSoldierHit){
                        System.out.print(" and dealt "+firstSoldier.getGun().getDamage()+" damage\n");
                        secondSoldier.setHealth(secondSoldier.getHealth()-firstSoldier.getGun().getDamage());
                        if(secondSoldier.getHealth()<=0){
                            System.out.println("Red soldier died");
                            secondSoldier.setDead(true);
                        }
                    }
                    else{
                        System.out.print(" but failed to hit\n");
                    }
                }
            }
            else{
                System.out.print(" but failed to hit\n");
                System.out.print("Blue soldier attacked");
                if(firstSoldierHit){
                    System.out.print(" and dealt "+firstSoldier.getGun().getDamage()+" damage\n");
                    secondSoldier.setHealth(secondSoldier.getHealth()-firstSoldier.getGun().getDamage());
                    if(secondSoldier.getHealth()<=0){
                        System.out.println("Red soldier died");
                        secondSoldier.setDead(true);
                    }
                }
                else{
                    System.out.print(" but also failed to hit lol\n");
                }
            }
        }

        if(firstSoldier.getGun().getClass().getSimpleName().equals("SniperRifle")){
            ((SniperRifle) firstSoldier.getGun()).setZoom(false);
            firstSoldier.getGun().setDamage(20);
            firstSoldier.getGun().setHitRate(60);
        }
        else{
            firstSoldier.getGun().setDamage(10);
            firstSoldier.getGun().setHitRate(50);
        }

        if(secondSoldier.getGun().getClass().getSimpleName().equals("SniperRifle")){
            ((SniperRifle) secondSoldier.getGun()).setZoom(false);
            secondSoldier.getGun().setDamage(20);
            secondSoldier.getGun().setHitRate(60);
        }
        else{
            secondSoldier.getGun().setDamage(10);
            secondSoldier.getGun().setHitRate(50);
        }

        if(firstSoldier.isDead()){
            System.out.println("B"+firstSoldierChoice+" died :(");
        }
        else{
            System.out.println("B"+firstSoldierChoice+" has "+firstSoldier.getHealth()+" hp");
        }
        if(secondSoldier.isDead()){
            System.out.println("R"+secondSoldierChoice+" died :(");
        }
        else{
            System.out.println("R"+secondSoldierChoice+" has "+secondSoldier.getHealth()+" hp");
        }
        System.out.println("----------------{End of Round " + roundNumber + "}----------------");
        Thread.sleep(1000);
        gameRunner(roundNumber,corridorSize);
    }

    public static void gameRunner(int roundNumber,int corridorSize) throws InterruptedException {
        boolean blueTeamDead=true,redTeamDead=true;
        for(int i=0;i<blueTeam.size();i++){
            if(!blueTeam.get(i).isDead()){
                blueTeamDead=false;
                break;
            }
        }
        for(int i=0;i<redTeam.size();i++){
            if(!redTeam.get(i).isDead()){
                redTeamDead=false;
                break;
            }
        }
        if(blueTeamDead){
            System.out.println("**************RED TEAM VICTORY**************");
        }
        else if(redTeamDead){
            System.out.println("**************BlUE TEAM VICTORY**************");
        }
        else{
            startRound(roundNumber+1,corridorSize);
        }
    }
}
