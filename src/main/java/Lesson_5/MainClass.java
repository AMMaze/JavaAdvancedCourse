package Lesson_5;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    static final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
    static final Semaphore tunnel = new Semaphore(CARS_COUNT / 2);
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(tunnel), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl, cb);
        }
        ArrayList<Thread> carThreads = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            Thread thread = new Thread(cars[i]);
            carThreads.add(thread);
            thread.start();
        }
        try {
            cdl.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            for (Thread car: carThreads) {
                car.join();
            }
        } catch (InterruptedException| BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}