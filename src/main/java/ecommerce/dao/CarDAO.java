package ecommerce.dao;

import ecommerce.model.Car;
import ecommerce.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    
    public static void create(Car car) {
        Logger.sendInfo("Car created: "+car);

        Connection connection = Connector.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO cars"
                    +"(manufacturer, model, price, speed, maxspeed, transmission, engine, color, gearshift, seats, fuel, consume, acceleration, description)"
                    +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, car.getManufacturer());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());
            preparedStatement.setInt(4, car.getSpeed());
            preparedStatement.setInt(5, car.getMaxspeed());
            preparedStatement.setInt(6, car.getTransmission());
            preparedStatement.setInt(7, car.getEngine());
            preparedStatement.setString(8, car.getColor());
            preparedStatement.setString(9, car.getGearshift());
            preparedStatement.setInt(10, car.getSeats());
            preparedStatement.setString(11, car.getFuel());
            preparedStatement.setString(12, car.getConsume());
            preparedStatement.setDouble(13, car.getAcceleration());
            preparedStatement.setString(14, car.getDescription());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in create car method : " + exception.getMessage());
        }
        Logger.sendInfo("... EXITING...");
    }

    public static List<Car> readAll(){
        String query = "SELECT * FROM cars;";
        List<Car> carsList = new ArrayList<>();

        try {
            Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setManufacturer(resultSet.getString("manufacturer"));
            car.setModel(resultSet.getString("model"));
            car.setPrice(resultSet.getDouble("price"));
            car.setSpeed(resultSet.getInt("speed"));
            car.setMaxspeed(resultSet.getInt("maxspeed"));
            car.setTransmission(resultSet.getInt("transmission"));
            car.setEngine(resultSet.getInt("engine"));
            car.setColor(resultSet.getString("color"));
            car.setGearshift(resultSet.getString("gearshift"));
            car.setSeats(resultSet.getInt("seats"));
            car.setFuel(resultSet.getString("fuel"));
            car.setConsume(resultSet.getString("consume"));
            car.setAcceleration(resultSet.getDouble("acceleration"));
            car.setDescription(resultSet.getString("description"));
            carsList.add(car);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in read all cars method: " + exception.getMessage());
        }
        return carsList;
    }


    public static Car readCarById(long id) {
        Car car = null;
        Connection connection = Connector.connect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM cars WHERE cars.id = '"+id+"';");
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                car = new Car();

                car.setId(resultSet.getLong("id"));
                car.setManufacturer(resultSet.getString("manufacturer"));
                car.setModel(resultSet.getString("model"));
                car.setPrice(resultSet.getDouble("price"));
                car.setSpeed(resultSet.getInt("speed"));
                car.setMaxspeed(resultSet.getInt("maxspeed"));
                car.setTransmission(resultSet.getInt("transmission"));
                car.setEngine(resultSet.getInt("engine"));
                car.setColor(resultSet.getString("color"));
                car.setGearshift(resultSet.getString("gearshift"));
                car.setSeats(resultSet.getInt("seats"));
                car.setFuel(resultSet.getString("fuel"));
                car.setConsume(resultSet.getString("consume"));
                car.setAcceleration(resultSet.getDouble("acceleration"));
                car.setDescription(resultSet.getString("description"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError(exception.getMessage());
        }
        return car;
    }

    public static List<Car> readCarByModel(String model) {
        String query = "SELECT * FROM cars WHERE cars.model = '" + model + "';";
        List<Car> carsList = new ArrayList<>();

        try {
            Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong("id"));
                car.setManufacturer(resultSet.getString("manufacturer"));
                car.setModel(resultSet.getString("model"));
                car.setPrice(resultSet.getDouble("price"));
                car.setSpeed(resultSet.getInt("speed"));
                car.setMaxspeed(resultSet.getInt("maxspeed"));
                car.setTransmission(resultSet.getInt("transmission"));
                car.setEngine(resultSet.getInt("engine"));
                car.setColor(resultSet.getString("color"));
                car.setGearshift(resultSet.getString("gearshift"));
                car.setSeats(resultSet.getInt("seats"));
                car.setFuel(resultSet.getString("fuel"));
                car.setConsume(resultSet.getString("consume"));
                car.setAcceleration(resultSet.getDouble("acceleration"));
                car.setDescription(resultSet.getString("description"));
                carsList.add(car);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in read all cars method: " + exception.getMessage());
        }
        return carsList;
    }

     public static List<Car> readCarByBrand(String brand) {
         String query = "SELECT * FROM cars WHERE cars.manufacturer = '" + brand + "';";
         List<Car> carsList = new ArrayList<>();

         try {
             Connection connection = Connector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();

             while (resultSet.next()) {
                 Car car = new Car();
                 car.setId(resultSet.getLong("id"));
                 car.setManufacturer(resultSet.getString("manufacturer"));
                 car.setModel(resultSet.getString("model"));
                 car.setPrice(resultSet.getDouble("price"));
                 car.setSpeed(resultSet.getInt("speed"));
                 car.setMaxspeed(resultSet.getInt("maxspeed"));
                 car.setTransmission(resultSet.getInt("transmission"));
                 car.setEngine(resultSet.getInt("engine"));
                 car.setColor(resultSet.getString("color"));
                 car.setGearshift(resultSet.getString("gearshift"));
                 car.setSeats(resultSet.getInt("seats"));
                 car.setFuel(resultSet.getString("fuel"));
                 car.setConsume(resultSet.getString("consume"));
                 car.setAcceleration(resultSet.getDouble("acceleration"));
                 car.setDescription(resultSet.getString("description"));
                 carsList.add(car);
             }

             preparedStatement.close();
             resultSet.close();
             connection.close();
         } catch (Exception exception) {
             Logger.sendError("Error in read all cars method: " + exception.getMessage());
         }
         return carsList;
     }

    public static long getMaxId() {

        String query =  "SELECT id FROM cars WHERE id=(SELECT max(id) FROM cars);";
        long id = 0;

        try {
            Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getLong("id");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in getCostumerId" + exception.getMessage());
        }
        return id;
    }

    public static boolean update(Car car) {
        Logger.sendInfo("...UPDATE...");

        boolean isUpdated = false;

        Connection connection = Connector.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cars SET "
                            +"manufacturer = ?, "
                            +"model = ?, "
                            +"price = ?, "
                            +"speed = ?, "
                            +"maxspeed = ?, "
                            +"transmission = ?, "
                            +"engine = ?, "
                            +"color = ?, "
                            +"gearshift = ?, "
                            +"seats = ?, "
                            +"fuel = ?, "
                            +"consume = ?, "
                            +"acceleration = ?, "
                            +"description = ? "
                            +"WHERE id = "+car.getId()+";");
            preparedStatement.setString(1, car.getManufacturer());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());
            preparedStatement.setInt(4, car.getSpeed());
            preparedStatement.setInt(5, car.getMaxspeed());
            preparedStatement.setInt(6, car.getTransmission());
            preparedStatement.setInt(7, car.getEngine());
            preparedStatement.setString(8, car.getColor());
            preparedStatement.setString(9, car.getGearshift());
            preparedStatement.setInt(10, car.getSeats());
            preparedStatement.setString(11, car.getFuel());
            preparedStatement.setString(12, car.getConsume());
            preparedStatement.setDouble(13, car.getAcceleration());
            preparedStatement.setString(14, car.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();
            isUpdated = rowsAffected > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        Logger.sendInfo("... EXITING ...");
        return isUpdated;
    }

    public static boolean delete(long id) {
    boolean isDeleted = false;

        Connection connection = Connector.connect();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM cars WHERE id = ?;");
        preparedStatement.setLong(1, id);

        int rowsAffected = preparedStatement.executeUpdate();
        isDeleted = rowsAffected > 0;

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return isDeleted;
    }

    /** public static Car loginCostumer(String model, String password) {
     Car car = null;
     Connection connection = Connector.connect();
     try{
     PreparedStatement preparedStatement = connection.prepareStatement
     ("SELECT * FROM car WHERE car.model = '"+model+"' AND car.password = '"+password+"';");
     ResultSet resultSet = preparedStatement.executeQuery();

     // name, model
     if(resultSet.next()) {
     car = new Costumer();
     car.setName(resultSet.getString("name"));
     car.setEmail(resultSet.getString("model"));
     }
     resultSet.close();
     preparedStatement.close();
     connection.close();
     } catch (Exception exception) {
     Logger.sendError(exception.getMessage());
     }
     return car;

     } */

}
