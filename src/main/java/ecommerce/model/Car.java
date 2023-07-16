package ecommerce.model;

import java.util.Date;

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
    private String urlimage;


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

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlImage) {
        this.urlimage = urlImage;
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
                ", urlimage='" + urlimage + '\'' +
                '}';
    }
}
