import com.onlinestore.BookProduct;
import com.onlinestore.ClothingProduct;
import com.onlinestore.ElectronicProduct;
import com.onlinestore.Order;
import com.onlinestore.Product;

public class App {
    public static void main(String[] args) throws Exception {
        Order order = new Order();
        Product electronicProduct = new ElectronicProduct("Printer",755.0, "1524", 8.0);
        Product clothingProduct = new ClothingProduct(null, 0, null, null);
        Product bookProduct = new BookProduct("Java for beginners", 55.99, "7568", "Jason Stone");


        order.addProduct(electronicProduct);
        order.addProduct(clothingProduct);
        order.addProduct(bookProduct);

        System.out.println("Clothing product deleted successfully");
        double totalAmount = order.total();
        System.out.println("Product list :\n");

        for (Product product : order.products) {
            System.out.println(product.getDescription());
        }
        order.removeProduct(clothingProduct);

        System.out.println("Total : $" + totalAmount + "\n");
        System.out.println("New product list :\n");
        for (Product product : order.products) {
            System.out.println(product.getDescription());
        }


    }
}
