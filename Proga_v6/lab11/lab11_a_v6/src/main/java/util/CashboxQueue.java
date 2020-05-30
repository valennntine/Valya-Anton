package util;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CashboxQueue {
    private ArrayList<Person> queue;
    private int queueId;

    public CashboxQueue(ArrayList<Person> queue, int queueId) {
        this.queue = queue;
        this.queueId = queueId;
    }

    public ArrayList<Person> getQueue() {
        return this.queue;
    }

    public int getQueueId() {
        return queueId;
    }

    public int getQueueLength() {
        return this.queue.size();
    }

    public ArrayList<Integer> getIdsInQueue() {
        return this.queue.stream()
                .map(Person::getPersonId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void removeFirst() {
        this.queue.remove(0);
    }

    public void removeLast() {
        this.queue.remove(this.queue.size() - 1);
    }

    public void addToEnd(Person newPerson) {
        this.queue.add(newPerson);
    }
}
