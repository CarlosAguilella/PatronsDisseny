import javax.swing.*;

abstract class Notification {
    String destionation;

    public Notification(String destionation) {
        this.destionation = destionation;
    }

    public static Notification to(String destination) {
        if(destination.startsWith("+")) {
            return new SMSNotification(destination);
        } else if (destination.startsWith("h")) {
            return new PushNotification(destination);
        } else if (destination.contains("@")) {
            return new EmailNotification(destination);
        }else {
            throw new RuntimeException("Invalid Product type");
        }
    }

    abstract void send();
}

class EmailNotification extends Notification{

    public EmailNotification(String destionation) {
        super(destionation);
    }

    @Override
    void send() {
        System.out.println("Te han enviado un Email, a " + destionation + " pulsa aqui para abrirlo");
    }
}

class SMSNotification extends Notification{

    public SMSNotification(String destionation) {
        super(destionation);
    }

    @Override
    void send() {
        System.out.println("Te han enviado un SMS a " + destionation + ", pulsa aqui para abrirlo");
    }
}

class PushNotification extends Notification{

    public PushNotification(String destionation) {
        super(destionation);
    }

    @Override
    void send() {
        System.out.println("Has hecho un Push, pulsa aqui para verlo");
    }
}

public class Main {
    public static void main(String[] args) {
        Notification.to("gerard@benigaslo.com").send();
        Notification.to("http://benigaslo.com/gerard").send();
        Notification.to("+34 678 789 890").send();
    }
}
