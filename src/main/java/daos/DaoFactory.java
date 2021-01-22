package daos;

import daos.ListProducts;
import daos.Products;

public class DaoFactory {
    private static Products productsDao;

    public static Products getProductsDao() {
        // checking connection and that this is created first ( ? )
        if (productsDao == null) {
            productsDao = new ListProducts();
        }
        return productsDao;
    }
}