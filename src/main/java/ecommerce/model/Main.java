package ecommerce.model;

import ecommerce.dao.CarDAO;
import ecommerce.dao.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws SQLException {
        /**
         TEST FOR [ C R E A T E ]  CARS

         Car ct1 = new Car();
         ct1.setManufacturer("Mazda");
         ct1.setModel("Rx7");
         ct1.setPrice(148.000);
         ct1.setSpeed(261);
         ct1.setMaxspeed(300);
         ct1.setTransmission(6);
         ct1.setEngine(380);
         ct1.setColor("Red");
         ct1.setGearshift("Auto");
         ct1.setSeats(2);
         ct1.setFuel("Gasoline");
         ct1.setConsume("1 mile/L");
         ct1.setUrlimage("this is not a String with some link right ?");
         CarDAO.create(ct1);

         ---------------------------------//---------------------------------

         TEST FOR [ R E A D - ALL ]  CARS

         CarDAO.readAll().forEach(c -> System.out.println(c));




         ---------------------------------//---------------------------------
         TEST FOR [ U P D A T E ]  CARS
         Car ct2 = CarDAO.readCarById(3);
         ct2.setManufacturer("Bmw");
         ct2.setModel("x5");
         ct2.setPrice(248.000);
         ct2.setSpeed(240);
         ct2.setMaxspeed(260);
         ct2.setTransmission(5);
         ct2.setEngine(300);
         ct2.setColor("white");
         ct2.setGearshift("Auto");
         ct2.setSeats(4);
         ct2.setFuel("Gasoline");
         ct2.setConsume("1 mile/L");
         ct2.setUrlimage("this is not a String with some link right ?");

         CarDAO.update(ct2);

         ---------------------------------//---------------------------------

         TEST FOR [ D E L E T E ]  CARS
         CarDAO.deleteCar(2);
         CarDAO.readAll().forEach(c -> System.out.println(c));


         */

    }
}
