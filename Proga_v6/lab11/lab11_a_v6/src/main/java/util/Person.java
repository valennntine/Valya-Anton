package util;

import java.util.concurrent.locks.ReentrantLock;

public class Person extends Thread {
    private String name;
    private int id;
    private FastFoodRestaurant fastFoodRestaurant;

    private ReentrantLock locker;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;

        this.locker = new ReentrantLock();
    }

    public String getPersonName() {
        return name;
    }

    public int getPersonId() {
        return id;
    }

    public void setFastFoodRestaurant(FastFoodRestaurant fastFoodRestaurant) {
        this.fastFoodRestaurant = fastFoodRestaurant;
    }

    public CashboxQueue getCashboxQueue() {
        for (CashboxQueue cashboxQueue: this.fastFoodRestaurant.getCashboxQueues()) {
            if (cashboxQueue.getIdsInQueue().contains(this.id)) {
                return cashboxQueue;
            }
        }

        return null;
    }

    @Override
    public void run() {
        this.locker.lock();

        try {
            if (this.getCashboxQueue().getQueueLength() != this.fastFoodRestaurant.getMinQueueSize()) {
                this.fastFoodRestaurant.getCashboxQueues().get(this.fastFoodRestaurant.getMinQueueIndex()).addToEnd(
                        this.getCashboxQueue().getQueue().get(this.getCashboxQueue().getQueueLength() - 1)
                );
                this.getCashboxQueue().removeLast();
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            this.locker.unlock();
        }
    }
}
