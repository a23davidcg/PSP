package org.example;

public class BalloonBlower implements Runnable{
    @Override
    public void run() {
        //blow up three balloons at same time and add them to StorageBalloons using while(true)
        //and print message about blown up ballon
        StorageBalloons storage = new StorageBalloons();
        int balloonNumber = 0;

        while(true){
            storage.addBalloon(balloonNumber);
            System.out.println("Blown up balloon " + balloonNumber);
            //whait random time above 1 to 10
            try {
                Thread.sleep((long) (Math.random() * 10 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balloonNumber++;

            //show how much balloons are in storage
            if(balloonNumber == 3){
                System.out.println("There are " + balloonNumber + " balloons in storage");
            }




        }
    }
}
