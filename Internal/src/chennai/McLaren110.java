package chennai;

import car_design_properties.CarProperties;

public class McLaren110 extends CarProperties {
    public McLaren110(int noOfDoors, String brand, boolean isSportsCar) {
        super(noOfDoors, brand, isSportsCar);
    }

    @Override
    public void mileage() {
        System.out.println("Mileage is 18 km per liter");
    }

    @Override
    public void braking() {
        System.out.println("breaking is good");

    }
}
