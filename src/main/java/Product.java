public class Product {

    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean reservationStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public void printInfo() {
        System.out.println("name: " + name + ", \n" +
                "production date: " + productionDate + ", \n" +
                "manufacturer: " + manufacturer + ", \n" +
                "country of origin: " + countryOfOrigin + ", \n" +
                "price: " + price + ", \n" +
                "reservation status: " + reservationStatus + ".");
    }
}
