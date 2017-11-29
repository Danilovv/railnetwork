import service.LiveTimeSimulation;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final Thread myThread = new Thread(new LiveTimeSimulation());
        myThread.start();
    }

}


