class Multiplicador {
    interface Adapter {
        int param1();
        int param2();
    }
    int multiplica(Adapter adapter){
        return adapter.param1()* adapter.param2();
    }
}

public class Main {
    public static void main(String[] args) {
        Multiplicador multiplicador = new Multiplicador();

        int resultado = multiplicador.multiplica(new Multiplicador.Adapter() {
            @Override
            public int param1() {
                return 1000;
            }

            @Override
            public int param2() {
                return 2000;
            }
        });

        System.out.println(resultado);
    }
}

