package animal;

public class AnimalMain {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");

        Cat[] cats = new Cat[]{
                new Cat("Черныш"),
                new Cat("Пушок"),
                new Cat("Снежок"),
                new Cat("Леопольд"),
        };

        Bowl bowl = new Bowl(25);

        for(int i = 0; i < cats.length; i++){
            cats[i].eat(bowl, 10);
        }

        System.out.println("Сытость котов:");
        for (Cat cat: cats){
            String satiety;
            if(cat.isSatiety()){
                satiety = "сыт";
            } else {
                satiety = "голоден";
            }
            System.out.println(cat.getName() + ": " + satiety);
        }

        System.out.println("Еды осталось в миске: " + bowl.getFood());

        cats[0].run(150);
        cats[0].swim(5);

        dog1.run(450);
        dog1.run(700);
        dog1.swim(5);
        dog1.swim(20);

        System.out.println("Всего животных создано: " + Animal.getAnimalsCount());
        System.out.println("Котов создано: " + Cat.getCount());
        System.out.println("Собак создано: " + Dog.getCount());
    }
}
