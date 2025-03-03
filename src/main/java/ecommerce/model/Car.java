package ecommerce.model;

public class Car {

    private Long id;
    private String manufacturer;
    private String model;
    private double price;
    private int speed;
    private int maxspeed;
    private int transmission;
    private int engine;
    private String color;
    private String gearshift;
    private int seats;
    private String fuel;
    private String consume;
    private double acceleration;
    private String description;
    private String plate;

    public Car() {

    }

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public int getTransmission() {
        return transmission;
    }

    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGearshift() {
        return gearshift;
    }

    public void setGearshift(String gearshift) {
        this.gearshift = gearshift;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlate(){
        return this.plate;
    }

    public void setPlate(String plate){
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                ", maxspeed=" + maxspeed +
                ", transmission=" + transmission +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", gearshift='" + gearshift + '\'' +
                ", seats=" + seats +
                ", fuel='" + fuel + '\'' +
                ", consume='" + consume + '\'' +
                ", acceleration='" + acceleration + '\'' +
                ", description='" + description + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }
}
