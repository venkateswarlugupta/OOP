package car_design_properties;

public abstract class CarProperties implements Performance{

    int noOfDoors;
    String brand;
    boolean isSportsCar;

    public CarProperties(int noOfDoors, String brand, boolean isSportsCar) {
        this.noOfDoors = noOfDoors;
        this.brand = brand;
        this.isSportsCar = isSportsCar;
    }

    @Override
    public void power() {
        System.out.println("Our car has super power");
    }
}
