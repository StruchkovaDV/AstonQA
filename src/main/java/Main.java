public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025","Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro Max", "15.09.2025", "Apple Inc.", "USA", 6299, true);
        productsArray[2] = new Product("Google Pixel 10 Pro", "10.10.2025", "Google LLC", "USA", 4999, false);
        productsArray[3] = new Product("Xiaomi Mi 15 Ultra", "20.03.2025", "Xiaomi Corp.", "China", 3299, true);
        productsArray[4] = new Product("OnePlus 14T", "05.06.2025", "OnePlus Tech", "China", 3899, true);

        for (Product product: productsArray){
            product.printInfo();
            System.out.println();
        }
    }
}
