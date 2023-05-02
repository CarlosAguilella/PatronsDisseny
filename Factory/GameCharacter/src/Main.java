abstract class Character {
    protected String name;
    protected int health;
    protected int speed;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void attack();
    public abstract void die();

    public static Character factory(String tipo, String nom, int health, int speed) {
        if (tipo.equals("knight")){
            return new Knight(nom,health,speed);
        } else if (tipo.equals("wizard")) {
            return new Wizard(nom,health,speed);
        } else {
            throw new RuntimeException("Invalid Product type");
        }
    }
}

class Knight extends Character {

    public Knight(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Knight is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Knight is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Knight died...");
    }
}

class Wizard extends Character {

    public Wizard(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Wizard is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Wizard is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Wizard died...");
    }
}


public class Main {
    public static void main(String[] args) {

        // create a knight
        Character knight = Character.factory("knight", "Arthur", 100, 5);
        knight.move();
        knight.attack();
        knight.die();

        // create a wizard
        Character wizard = Character.factory("wizard", "Gandalf", 80, 7);
        wizard.move();
        wizard.attack();
        wizard.die();
    }
}