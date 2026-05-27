package laborator11.observer;

public class MainObserver {

    public static void main(String[] args) {

        YouTubeChannel channel =
                new YouTubeChannel("Webely Channel");

        MediaInterested user1 =
                new MediaInterested("Andrei");

        MediaInterested user2 =
                new MediaInterested("Maria");


        channel.addObserver(user1);
        channel.addObserver(user2);


        channel.uploadVideo("Observer Pattern Tutorial");

        System.out.println();


        channel.removeObserver(user2);


        channel.uploadVideo("Decorator Pattern Tutorial");
    }
}