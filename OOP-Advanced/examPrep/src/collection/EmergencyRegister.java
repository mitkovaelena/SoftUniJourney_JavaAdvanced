package collection;

import java.util.LinkedList;
import java.util.List;

public class EmergencyRegister<T> implements Register<T> {

    private List<T> emergencyQueue;

    public EmergencyRegister() {
        this.emergencyQueue = new LinkedList<>();
    }


    public void enqueueEmergency(T emergencyCenter) {
        this.emergencyQueue.add(emergencyCenter);
    }

    public T dequeueEmergency() {
        T removedElement = this.emergencyQueue.remove(0);

        return removedElement;
    }

    public Boolean isEmpty() {
        return this.emergencyQueue.size() == 0;
    }

    public int getSize() {
        return this.emergencyQueue.size();
    }
}
