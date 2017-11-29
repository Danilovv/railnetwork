package service;

import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import defaulStation.SaintPetersburgUndergroundRed;
import model.Train;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class LiveTimeSimulation implements Runnable {

    public void run() {
        new Initializer().work();

        final Train firstTrain = new Train(SaintPetersburgUndergroundBlue.PARNAS, SaintPetersburgUndergroundRed.AKADEMICHESKAJA);
        final Train secondTrain = new Train(SaintPetersburgUndergroundRed.AKADEMICHESKAJA, SaintPetersburgUndergroundBlue.PARNAS);

        final TrainOnline trainOnline = TrainOnline.getInstance();

        trainOnline.subscribe(firstTrain);
        trainOnline.subscribe(secondTrain);

        while (true) {
            trainOnline.letsMove();

            if(firstTrain.hasAccident(secondTrain))
                break;

            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();

                break;
            }
        }
    }
}
