import java.util.Objects;

public class TextBox {
    int ancho, alto;
    String texto;


    @Override
    public String toString() {
        return
                "┏" + "━".repeat(ancho) + "┓\n" +
                        ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                        (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                        ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                        "┗" + "━".repeat(ancho) + "┛\n";
    }

    public static class Builder {
        int ancho, alto;
        String texto;

        public Builder setAncho(int ancho) {
            this.ancho = ancho;
            return this;
        }

        public Builder setAlto(int alto) {
            this.alto = alto;
            return this;
        }

        public Builder setTexto(String texto) {
            this.texto = texto;
            return this;
        }

        public TextBox build(){
            TextBox textBox = new TextBox();

            textBox.texto = Objects.requireNonNullElse(this.texto, "");

            textBox.ancho = Math.max(this.ancho, textBox.texto.length());

            if (textBox.texto.length() > 0 && this.alto <= 0) {
                textBox.alto = 1;
            } else textBox.alto = Math.max(this.alto, 0);

            return textBox;
        }
    }
}

class Main {
    public static void main(String[] args) {
        TextBox textBox = new TextBox.Builder()
                .setAncho(4)
                .setAlto(10)
                .setTexto("hofdsohosdhosdfh")
                .build();

        System.out.println(textBox);
    }
}