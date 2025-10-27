import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkOpeningHours;
    private List<Attraction> attractions = new ArrayList<>();

    public Park(String parkOpeningHours) {
        this.parkOpeningHours = parkOpeningHours;
    }

    public void addAttraction(String name, String attractionOpeningHours, int price) {
        attractions.add(new Attraction(name, attractionOpeningHours, price));
    }

    public class Attraction{
        private String name;
        private String attractionOpeningHours;
        private int price;

        public Attraction(String name, String attractionOpeningHours, int price) {
            this.name = name;
            this.attractionOpeningHours = attractionOpeningHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getAttractionOpeningHours() {
            return attractionOpeningHours;
        }

        public int getPrice() {
            return price;
        }
    }
}
