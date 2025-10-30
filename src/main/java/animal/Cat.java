package animal;

public class Cat extends Animal {
    private static int count = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        count++;
        satiety = false;
    }

    @Override
    public void run(int distance){
        if(distance > 200){
            System.out.println("Кот не может столько пробежать! Расстояние должно быть <= 200");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance){
        System.out.println("Коты не умеют плавать");
    }

    public void eat(Bowl bowl, int portion){
        int food = bowl.eatFood(portion);
        if (food > 0) {
            satiety = true;
        }
    }

    public static int getCount() {
        return count;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
