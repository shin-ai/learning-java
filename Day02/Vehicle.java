package Day02;

public class Vehicle {
    private int wheels;
    private int speed;
    private int engineCapacity;
    private String engineType;
    private String brand;
    private String model;
    private String name;
    private boolean isStarted = false;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public void start() {
        this.isStarted = true;
    }

    public void acceleration(int speed){
        if (!this.isStarted){
            System.out.println("You haven't started the car!");
        } else {
            this.speed += speed;
            System.out.println("The vehicle is now moving at " + this.speed + " km/h.");
        }
    }

    public void brake() {
        if (this.speed <= 0) {
            System.out.println("The vehicle is already stopped.");
        } else {
            this.speed -= 10;
            if (this.speed < 0) {
                this.speed = 0;  // Prevent negative speed
            }
            System.out.println("The vehicle slowed down. Current speed: " + this.speed + " km/h.");
        }
    }

    public void stop() {
        this.speed = 0;
    }

    public void turnOff() {
        if (!this.isStarted) {
            System.out.println("The vehicle is already off.");
        } else {
            this.isStarted = false;
            System.out.println("The vehicle has been turned off.");
        }
    }

    public void rev() {
        System.out.println("Stutututu");
    }
}
