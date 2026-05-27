package laborator11.observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {

    private String channelName;

    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {

        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void uploadVideo(String videoTitle) {

        System.out.println(channelName + " uploaded: " + videoTitle);

        notifyObservers("New video uploaded: " + videoTitle);
    }
}