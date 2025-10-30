package animal;

public class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int distance){
        if(distance > 500){
            System.out.println("Собака не может столько пробежать! Расстояние должно быть =< 500");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance){
        if(distance > 10){
            System.out.println("Собака не может столько проплыть! Расстояние должно быть =< 10");
            return;
        }
        super.swim(distance);
    }

    public static int getCount() {
        return count;
    }
}
