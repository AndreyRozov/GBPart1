package Lesson06;

public class Animal {
    String name;
    public Animal(){

    }

    public Animal(String name) {
        this.name = name;
    }

    public void jump() {
        System.out.println("Животное подпрыгнуло");
    }
    public void run() {
        System.out.println("Животное пробежало");
    }
    public static class Cat extends Animal {

    }
}
