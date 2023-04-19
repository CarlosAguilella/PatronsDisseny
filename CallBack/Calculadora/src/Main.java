class Calculadora {
    interface CallBack {
        void posible(int resultat);
        void noPosible();
    }

    void divide(int a, int b, CallBack callBack) {
        System.out.println("El resultado de la division es...");
        if (b==0){
            callBack.noPosible();
        } else {
            callBack.posible(a/b);
        }
    }
}
class Profesor implements Calculadora.CallBack{

    @Override
    public void posible(int resultat) {
        System.out.println("ES POSIBLE LA DIVIOS: " + resultat);
    }

    @Override
    public void noPosible() {
        System.out.println("ES IMMMMMMPOSIBLE LA DIVIOS");
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Profesor profesor = new Profesor();
        calculadora.divide(9,4, profesor);
    }
}