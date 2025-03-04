package ecommerce.dao;

import ecommerce.model.Car;
import ecommerce.service.CarService;
import ecommerce.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CarDAO {

    public HashMap<Car, Boolean> createCar(Car car) {
        HashMap<Car, Boolean> map = new HashMap<>();

        if(CarService.TEST_ENVIRONMENT){
            try(Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO car"
                            + "(manufacturer, model, plate)"
                            + "VALUES (?, ?, ?);")) {
                preparedStatement.setString(1, car.getManufacturer());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setString(3, car.getPlate());

                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    map.put(readCarById(getMaxId()), true);
                }
            } catch (SQLException e) {
                Logger.sendError("Error in createCar method:"+e.getMessage());
            }
        } else {
            try (Connection connection = Connector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO cars"
                        + "(manufacturer, model, price, speed, maxspeed, transmission, engine, color, gearshift, seats, fuel, consume, acceleration, description)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
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

                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    map.put(readCarById(getMaxId()), true);
                }
            } catch (SQLException e) {
                Logger.sendError("Error in createCar method:"+e.getMessage());
            }
        }
        return map;
    }

    public List<Car> findPaginated(int offset, int limit){
        String sql = "SELECT * FROM car LIMIT ? OFFSET ?";

        try(
                Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> carList = new ArrayList<>();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getLong("id"));
                car.setManufacturer(resultSet.getString("manufacturer"));
                car.setModel(resultSet.getString("model"));
                car.setPlate(resultSet.getString("plate"));
                carList.add(car);
            }
            return carList;
        } catch (SQLException e) {
            throw new RuntimeException("Was not possible to find the paginated item", e);
        }

    }

    public int countItems() {
        String sql = "SELECT COUNT(*) FROM car";
        try (Connection connection = Connector.connect_test_env();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("Was not possible to count the itens", e);
        }
    }

    public List<Car> listAll(){
        List<Car> carsList = new ArrayList<>();

        if(CarService.TEST_ENVIRONMENT){
            try (Connection connection = Connector.connect_test_env();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, manufacturer, model, plate FROM car");
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getLong("id"));
                    car.setManufacturer(resultSet.getString("manufacturer"));
                    car.setModel(resultSet.getString("model"));
                    car.setPlate(resultSet.getString("plate"));
                    carsList.add(car);
                }
            } catch(SQLException e) {
                Logger.sendError("Error in listAll method:"+e.getMessage());
            }
        } else {
            try (
                Connection connection = Connector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars");
                ResultSet resultSet = preparedStatement.executeQuery()
            ) {

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
            } catch(SQLException e) {
                Logger.sendError("Error in listAll method:"+e.getMessage());
            }
        }
        return carsList;
    }

    public Car readCarById(long id) {
        Car car = null;

        if(CarService.TEST_ENVIRONMENT){
            try(Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT id, manufacturer, model, plate FROM car WHERE id = ?;");
                ResultSet resultSet = preparedStatement.executeQuery()
            ){
                preparedStatement.setLong(1, id);

                if(resultSet.next()) {
                    car = new Car();
                    car.setId(resultSet.getLong("id"));
                    car.setManufacturer(resultSet.getString("manufacturer"));
                    car.setModel(resultSet.getString("model"));
                    car.setPlate(resultSet.getString("plate"));
                }
            }catch(SQLException e) {
                Logger.sendError("Error in readCarById method:"+e.getMessage());
            }
        }else{
            try(
                Connection connection = Connector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM car WHERE id = ?;");
                ResultSet resultSet = preparedStatement.executeQuery()
            ){
                preparedStatement.setLong(1, id);
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
            } catch (Exception e) {
                Logger.sendError("Error in readCarById method:"+e.getMessage());
            }
        }
        return car;
    }

    public long getMaxId() {
        String query = CarService.TEST_ENVIRONMENT?
                "SELECT id FROM car WHERE id=(SELECT max(id) FROM car);":
                "SELECT id FROM cars WHERE id=(SELECT max(id) FROM cars);";
        long id = 0;

        try (
            Connection connection = CarService.TEST_ENVIRONMENT?Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()
        ){
            while(resultSet.next()) id = resultSet.getLong("id");
        } catch (SQLException e) {
            Logger.sendError("Error in getMaxId method: " + e.getMessage());
        }
        return id;
    }

    public boolean update(Car car) {
        boolean isUpdated = false;

        if(CarService.TEST_ENVIRONMENT){
            try(
                Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE car SET "
                    +"manufacturer = ?, "
                    +"model = ? "
                    +"WHERE id = ?;")
            ){
                preparedStatement.setString(1, car.getManufacturer());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setLong(3, car.getId());

                int rowsAffected = preparedStatement.executeUpdate();
                isUpdated = rowsAffected > 0;

            } catch (SQLException e){Logger.sendError("Error in update method:"+e.getMessage());}
        } else {
            try (Connection connection = Connector.connect();
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
                        +"WHERE id = ?;")){
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
                preparedStatement.setLong(15, car.getId()
            );

                int rowsAffected = preparedStatement.executeUpdate();
                isUpdated = rowsAffected > 0;

            } catch (SQLException e) {
                Logger.sendError("Error in update method:"+e.getMessage());
            }
        }
        return isUpdated;
    }

    public boolean delete(long id) {
        boolean isDeleted = false;

        if(CarService.TEST_ENVIRONMENT){
            try(Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("DELETE FROM car WHERE id = ?;")
            ){
                preparedStatement.setLong(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                isDeleted = rowsAffected > 0;

            } catch(SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try(
                Connection connection = Connector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM cars WHERE id = ?;")
            ){
                preparedStatement.setLong(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                isDeleted = rowsAffected > 0;

            } catch(Exception e) {
                Logger.sendError("Error in delete method:"+e.getMessage());
            }
        }

        return isDeleted;
    }

}
