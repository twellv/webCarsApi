package ecommerce;

import ecommerce.dao.Connector;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ProductDAOTest {
/**
    @Test
    public void testProduct() throws SQLException {
        Connection connection = Connector.connect();
        PreparedStatement preparedStatement1 = connection.prepareStatement(
                "DELETE FROM product WHERE name = 'Lost Ark 20';");
        preparedStatement1.execute();
        preparedStatement1.close();
        connection.close();

        Product product = new Product();
        product.setName("Lost Ark 15");
        product.setDescription("Credito de R$15 em Lost Ark");
        product.setPrice(11.9);
        product.setQuantity(17);
        ProductDAO.create(product);

        Product readedProduct = ProductDAO.readByName(product.getName());
        assertNotNull(readedProduct);

        assertEquals(product.getName(), readedProduct.getName());
        assertEquals(product.getDescription(), readedProduct.getDescription());
        assertEquals(product.getPrice(), readedProduct.getPrice(), 0.0001);
        assertEquals(product.getQuantity(), readedProduct.getQuantity());

        readedProduct.setName("Lost Ark 20");
        readedProduct.setDescription("Credito de R$20,00 em Lost Ark");
        readedProduct.setPrice(17.71);
        readedProduct.setQuantity(36);
        ProductDAO.update(readedProduct);

        Product productAtt = ProductDAO.read(readedProduct.getId());
        assertEquals(readedProduct.getName(), productAtt.getName());
        assertEquals(readedProduct.getDescription(), productAtt.getDescription());
        assertEquals(readedProduct.getPrice(), productAtt.getPrice(), 0.0001);
        assertEquals(readedProduct.getQuantity(), productAtt.getQuantity());

        ProductDAO.delete(productAtt.getId());
        assertNull(ProductDAO.read(productAtt.getId()));
    }
*/
}
