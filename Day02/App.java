package Day02;

public class App {
    public static void main(String[] args) {
        Vehicle motor = new Vehicle();
        motor.setName("Motor");
        motor.setBrand("Kawasaki");
        motor.setModel("ZX 25R");
        motor.setEngineType("4 Cilinder");
        motor.setEngineCapacity(250);
        motor.setWheels(2);

        motor.start();
        motor.acceleration(10);
        motor.acceleration(10);
        motor.brake();
        motor.turnOff();

        Car car = new Car();
        car.rev();

        MotorBike motorBike = new MotorBike();
        motorBike.rev();
    }
}
