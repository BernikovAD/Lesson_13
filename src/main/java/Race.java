import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public static final int CARS_COUNT = 4;


    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
    public void startCar(){
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT+1);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        new Thread (()->{

        }).start ();
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cb);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            while (cb.getNumberWaiting () != CARS_COUNT){
                Thread.sleep (1000);
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            while (cb.getNumberWaiting () != CARS_COUNT){
                Thread.sleep (1000);
            }
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}