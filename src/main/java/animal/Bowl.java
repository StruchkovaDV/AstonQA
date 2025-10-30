package animal;

public class Bowl {

    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public void addFood(int portion){
        food += portion;
    }

    public int eatFood(int portion){
        if(food - portion >= 0){
            food -= portion;
            return portion;
        } else {
            return 0;
        }
    }

    public int getFood() {
        return food;
    }
}
