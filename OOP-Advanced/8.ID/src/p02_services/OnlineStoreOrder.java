package p02_services;

public class OnlineStoreOrder {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(NotificationService... notificationServices) {
        this.notificationServices = notificationServices;
    }

    public void process() {
        for(NotificationService ns : notificationServices){
            if(ns.isActive()){
                ns.sendNotification();
            }
        }
    }
}
