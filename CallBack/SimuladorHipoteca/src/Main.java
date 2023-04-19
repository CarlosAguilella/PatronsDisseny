import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {
    interface CallBack{
        void capitalNulo();
        void plazoNulo();
        void todoBien(double resultat);
    }
    static void calcularCuota(double capital, double plazo, CallBack callBack) {
        double interes = 0;
        try {
            interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder().uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest")).GET().build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (Exception e) {
        }
        if (capital==0){
            callBack.capitalNulo();
        } else if (plazo == 0) {
            callBack.plazoNulo();
        } else {
            callBack.todoBien(capital*interes/12/(1-Math.pow(1+(interes/12),-plazo*12)));
        }
    }
}

class Cliente implements SimuladorHipoteca.CallBack {

    @Override
    public void capitalNulo() {
        System.out.println("ERROR: EL CAPITAL NO PUEDE SER NULO");
    }

    @Override
    public void plazoNulo() {
        System.out.println("ERROR: EL PLAZO NO PUEDE SER NULO");
    }

    @Override
    public void todoBien(double resultat) {
        System.out.println("LA CUTOA ES " + resultat);
    }
}
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        SimuladorHipoteca.calcularCuota(300,12,cliente);


    }
}