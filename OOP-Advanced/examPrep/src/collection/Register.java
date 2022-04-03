package collection;

public interface Register<T> {

    void enqueueEmergency(T emergencyCenter);

    T dequeueEmergency();

    Boolean isEmpty();

    int getSize();
}
