package animal;

public class Animal {
    private String name;
    private static int animalsCount;

    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public void run(int distance){
        if(distance <= 0) {
            System.out.println("Расстояние должно быть > 0.");
            return;
        }
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance){
        if(distance > 0) {
            System.out.println("Расстояние должно быть > 0.");
            return;
        }
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public String getName() {
        return name;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }
}
