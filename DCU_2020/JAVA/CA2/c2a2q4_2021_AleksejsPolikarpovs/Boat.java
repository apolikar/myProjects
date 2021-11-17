/**
 * class Boat is direct subclass of super-class Vessel
 * It inherits all the members (fields, methods)
 */
public class Boat extends Vessel {

    private final String[] STEERING_VARIATIONS = {"wheel", "tiller", "oars"};                           // list of steering variations
    private String steeringType = "Unknown";                                                            // default variable


    public Boat(String name, double length, String make, int yearOfManufacture, String typeSteering){
        super(name, length, make, yearOfManufacture);
        checkSteeringType(typeSteering);
    }

    public Boat(String name, double length, String make, int yearOfManufacture){
        super(name, length, make, yearOfManufacture);
    }

    public Boat(String name, double length, String make){
        super(name, length, make);
    }

    public Boat(String name, double length){
        super(name, length);
    }

    public Boat(String name){
        super(name);
    }

    public Boat(){

    }


    public void setSteeringType(String typeSteering){
        checkSteeringType(typeSteering);
    }

    public String getSteeringType(){
        return steeringType;
    }


    /**
     * private method to detect steering type
     * @param typeSteering array with all steering types
     */

    private void checkSteeringType(String typeSteering){
        for (String steering_variation : STEERING_VARIATIONS) {
            if (typeSteering.toLowerCase().contains(steering_variation)
                    && typeSteering.length() == steering_variation.length()) {
                this.steeringType = typeSteering.substring(0, 1).toUpperCase() +
                        typeSteering.substring(1).toLowerCase();
                break;
            }
        }
    }


    /**
     * overridden method prints all characteristics of class
     * @return string with all characteristics
     */
    @Override                                                                                          // method overrides super-class method
    public String toString(){
        return super.toString() + "Steering Type: " + this.steeringType + "\n";
    }
}