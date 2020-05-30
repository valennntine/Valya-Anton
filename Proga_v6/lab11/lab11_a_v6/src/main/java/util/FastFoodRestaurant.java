package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class FastFoodRestaurant {
    private ArrayList<CashboxQueue> cashboxQueues;
    private Person lastPersonThread = null;

    public FastFoodRestaurant(ArrayList<CashboxQueue> cashboxQueues) {
        this.cashboxQueues = cashboxQueues;

        for(CashboxQueue cashboxQueue: this.cashboxQueues) {
            for(Person person: cashboxQueue.getQueue()) {
                person.setFastFoodRestaurant(this);
            }
        }
    }

    public ArrayList<CashboxQueue> getCashboxQueues() {
        return cashboxQueues;
    }

    public int getMinQueueIndex() {
        return this.cashboxQueues.stream()
                .min(Comparator.comparingInt(CashboxQueue::getQueueLength)).get().getQueueId();
    }

    public int getMinQueueSize() {
        return this.cashboxQueues.stream()
                .map(CashboxQueue::getQueueLength)
                .min(Integer::compare).get();
    }

    public void updatePersonThread(int personId) {
        for (CashboxQueue cashboxQueue: this.cashboxQueues) {
            if (cashboxQueue.getIdsInQueue().contains(personId)) {
                int idInQueue = cashboxQueue.getIdsInQueue().indexOf(personId);
                Person newPerson = new Person("", personId);
                newPerson.setFastFoodRestaurant(this);

                cashboxQueue.getQueue().set(idInQueue, newPerson);

                break;
            }
        }
    }

    public void updateQueues(ArrayList<Person> lastPeopleInQueues) {
        for(Person lastPerson: lastPeopleInQueues) {
            if(this.lastPersonThread != null) {
                try {
                    this.lastPersonThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lastPerson.setName("mythread-" + lastPerson.getPersonId());
            this.lastPersonThread = lastPerson;
            lastPerson.start();
        }

        for(Person person: lastPeopleInQueues) {
            this.updatePersonThread(person.getPersonId());
        }
    }

    public ArrayList<Person> getAllLastPeople() {
        return this.cashboxQueues.stream()
                .map(cashboxQueue -> cashboxQueue.getQueue().get(cashboxQueue.getQueueLength() - 1))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean peopleThreadsAreFinished(ArrayList<Person> lastPeople) {
        return lastPeople.stream().noneMatch(Thread::isAlive);
    }

    public void addCustomer(Person newPerson) {
        newPerson.setFastFoodRestaurant(this);
        this.cashboxQueues.get(this.getMinQueueIndex()).addToEnd(newPerson);
    }

    public void removeCustomer() {
        this.cashboxQueues.get(new Random().nextInt(this.cashboxQueues.size())).removeFirst();
    }

    public int getNextPersonId() {
        int nextId = 0;

        for(CashboxQueue cashboxQueue: this.cashboxQueues) {
            nextId += cashboxQueue.getQueueLength();
        }

        return nextId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(CashboxQueue cashboxQueue: this.cashboxQueues) {
            stringBuilder.append(cashboxQueue.getQueueId()).append(" | ");

            for(Person person: cashboxQueue.getQueue()) {
                stringBuilder.append(person.getPersonId()).append(" ");
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
