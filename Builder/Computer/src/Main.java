class Computer {
    String HDD, RAM;
    boolean isGraphicsCardEnabled, isBluetoothEnabled;

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    static class Builder {
        String HDD, RAM;
        boolean isGraphicsCardEnabled, isBluetoothEnabled;

        public Builder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        Builder setIsGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        Builder setIsBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        Computer build() {
            Computer computer = new Computer();
            computer.isGraphicsCardEnabled = this.isGraphicsCardEnabled;
            computer.isBluetoothEnabled = this.isBluetoothEnabled;
            computer.HDD=this.HDD;
            computer.RAM=this.RAM;
            return computer;
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("HDD1", "RAM1")
                .setIsGraphicsCardEnabled(true)
                .setIsBluetoothEnabled(true)
                .build();
        System.out.println(computer);
    }
}