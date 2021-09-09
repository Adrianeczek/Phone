package pl.adrian_zukowski_innogy;

import java.util.*;

public abstract class iPhone implements Phone{

    boolean isTurnOn = false;

    private Map<String, Integer> contacts = new HashMap<>();

    @Override
    public void turnOffThePhone() {
        System.out.println("Turned the Phone off");
        isTurnOn = false;
    }

    @Override
    public void turnOnThePhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Turned the Phone on\nWelcome in " + getClass());
        System.out.println("Select a number.");
        System.out.println("1.Turn off the phone");
        System.out.println("2.Call to...");
        System.out.println("3.Choose a game");
        System.out.println("4.Send a message");
        System.out.println("5.Choose an Application");
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> turnOffThePhone();
            case 2 -> callTo();
            case 3 -> playGames();
            case 4 -> sendMessage();
            case 5 -> choseApp();
        }

    }

    @Override
    public void callTo() {
        Scanner scanner = new Scanner(System.in);
        contacts.put("Marta Jenkins", 693647857);
        contacts.put("Bartek Kowalski", 546938546);
        contacts.put("Jagoda Nowak", 597123956);
        contacts.put("Dominika Kwiatek", 865736234);
        contacts.put("Jeny Fox", 965437143);
        System.out.println("Choose a number to call");
        System.out.println(contacts);
        int a = scanner.nextInt();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Calling to " + contacts.keySet() + " on " + a);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void playGames() {
        Games games = new Games();
        games.guessTheNumber();
    }

    @Override
    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        Set<String> strings = contacts.keySet();
        Collection<Integer> values = contacts.values();
        System.out.println("Choose contact");
        for (String string: strings) {
            for (Integer value:values) {
                System.out.println(string + " " + value);
            }
        }
        String person = scanner.nextLine();
        System.out.println("Wrtie your message to" + person);
        while (true) {
            String message = scanner.nextLine();
            if (message.isEmpty()) {
                System.out.println("You can't send an empty message");
                continue;
            } else if (!message.isEmpty()) {
                System.out.println("You sent a message to " + person);
                System.out.println(message);
                break;
            }
        }
    }

    @Override
    public void choseApp() {

    }
}
