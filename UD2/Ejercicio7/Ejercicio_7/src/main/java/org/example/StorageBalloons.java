package org.example;

public class StorageBalloons {

    //that class can have max 10 balloons numbered 1 to 10

    int[] balloons = new int[10];

    //method to add a balloon to the storage

    public void addBalloon(int balloonNumber){

        balloons[balloonNumber] = 1;

    }

    //method to prick a balloon from the storage

    public void prickBalloon(int balloonNumber){
        balloons[balloonNumber] = 0;
    }

    //method to check if there are any balloons in the storage

    public boolean isBalloonInStorage(){
        for(int i = 0; i < balloons.length; i++){
            if(balloons[i] == 1){
                return true;
            }
        }
        return false;
    }


}
