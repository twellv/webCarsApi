package ecommerce;

import ecommerce.dao.CarDAO;

import ecommerce.dao.Connector;
import ecommerce.util.FormatDateSimple;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CarDAOTest {
/**
    @Test
    public void testCostumerDAO() throws SQLException{
        Connection connection = Connector.connect();

        PreparedStatement preparedStatement = connection.prepareStatement(
        "DELETE FROM cars WHERE email='tilRammstein@gmail.com' AND cpf='33311-48';");
        preparedStatement.execute();
        preparedStatement.close();

        PreparedStatement preparedStatement2 = connection.prepareStatement(
                "DELETE FROM costumer WHERE email='chuckNoia@gmail.com' AND cpf='951753314-88';");
        preparedStatement2.execute();
        preparedStatement2.close();

        connection.close();

        String newDate = "1984-12-27";
        java.util.Date utilDate = FormatDateSimple.formatoDateSimples(newDate);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        //nome, email, senha, whatsapp, cpf, nascimento
        Costumer costumer = new Costumer();
        costumer.setName("Til");
        costumer.setEmail("tilRammstein@gmail.com");
        costumer.setPassword("rammstein123");
        costumer.setWhatsapp("85 9333-6666");
        costumer.setCpf("33311-48");
        costumer.setBirth(sqlDate);
        CarDAO.create(costumer);

        Costumer readCostumer = CarDAO.readCarByModel("tilRammstein@gmail.com");
        assertNotNull(readCostumer);

        assertEquals(costumer.getName(), readCostumer.getName());
        assertEquals(costumer.getEmail(), readCostumer.getEmail());
        assertEquals(costumer.getPassword(), readCostumer.getPassword());
        assertEquals(costumer.getWhatsapp(), readCostumer.getWhatsapp());
        assertEquals(costumer.getCpf(), readCostumer.getCpf());
        assertEquals(costumer.getBirth(), readCostumer.getBirth());

        readCostumer.setName("Chuck Noia");
        readCostumer.setEmail("chuckNoia@gmail.com");
        readCostumer.setPassword("chuck123");
        readCostumer.setWhatsapp("(85) 991274-1596");
        readCostumer.setCpf("951753314-88");

        String newBirth = "1990-12-20";
        java.util.Date newUtilDate = FormatDateSimple.formatoDateSimples(newBirth);
        java.sql.Date sqlDateBirth = new java.sql.Date(newUtilDate.getTime());
        costumer.setBirth(sqlDateBirth);
        CarDAO.update(readCostumer);

        Costumer costumerAtt = CarDAO.read(readCostumer.getId());

        //name, email, password, whatsapp, cpf, birth
        assertEquals(readCostumer.getName(), costumerAtt.getName());
        assertEquals(readCostumer.getEmail(), costumerAtt.getEmail());
        assertEquals(readCostumer.getPassword(), costumerAtt.getPassword());
        assertEquals(readCostumer.getWhatsapp(), costumerAtt.getWhatsapp());
        assertEquals(readCostumer.getCpf(), costumerAtt.getCpf());
        assertEquals(readCostumer.getBirth(), costumerAtt.getBirth());

        CarDAO.deleteCostumer(costumerAtt.getId());
        Costumer deletedCostumer = CarDAO.read(costumerAtt.getId());
        assertNull(deletedCostumer);
    }
*/
}
