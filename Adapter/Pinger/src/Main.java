import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class Pinger {
    interface Adapter {
        int strLenght();
        String valor(int i);
        boolean pare();
    }

    void ping(Adapter adapter) {
        for (int i = 0; i < adapter.strLenght(); i++) {
            try {
                String ip = adapter.valor(i);

                if (InetAddress.getByName(ip).isReachable(500)) {
                    System.out.println(ip + " is online");
                    if (adapter.pare()) break;
                } else {
                    System.out.println(ip + " is down");
                }

            } catch (IOException ignored) {
            }
        }
    }
}

public class Main {
    static int quantes = 0;
    public static void main(String[] args) {
        Pinger pinger = new Pinger();

        pinger.ping(new Pinger.Adapter() {
            @Override
            public int strLenght() {
                return 100;
            }

            @Override
            public String valor(int i) {
                quantes++;
                return "10.2.1." + (i + 10);
            }

            @Override
            public boolean pare() {
                System.out.println(quantes);
                if (quantes > 5) {
                    return true;
                }
                return false;
            }
        });
    }
}