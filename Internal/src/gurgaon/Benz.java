




Fistly i would  give insights
of informal conversation






package gurgaon;

import car_design_properties.CarProperties;

public class Benz extends CarProperties {
    public Benz(int noOfDoors, String brand, boolean isSportsCar) {
        super(noOfDoors, brand, isSportsCar);
    }

    @Override
    public void mileage() {
        System.out.println("Benz has high comforts..so mileage is little less");
    }

    @Override
    public void braking() {
        System.out.println("Super braking");
    }
}
