// Vessel is super-class of both Boat and Dinghy. Example of multilevel inheritance.

/**
 * Dinghy "is-a" type of small boat. So Dinghy inherits from Boat which inherits from super-class Vessel
 */
public class Dinghy extends Boat {

    private boolean isInflatable;


    public Dinghy(String name, double length, String make, int yearOfManufacture, String typeSteering, boolean isInflatable){
        super(name, length, make, yearOfManufacture, typeSteering);
        this.isInflatable = isInflatable;
    }

    public Dinghy(String name, double length, String make, int yearOfManufacture, String typeSteering){
        super(name, length, make, yearOfManufacture, typeSteering);
    }

    public Dinghy(String name, double length, String make, int yearOfManufacture){
        super(name, length, make, yearOfManufacture);
    }

    public Dinghy(String name, double length, String make){
        super(name, length, make);
    }

    public Dinghy(String name, double length){
        super(name, length);
    }

    public Dinghy(String name){
        super(name);
    }

    public Dinghy(){

    }


    public void setIsInflatable(boolean isInflatable){
        this.isInflatable = isInflatable;
    }

    public boolean getIsInflatable(){
        return isInflatable;
    }
    
    
    /**
     *
     * overridden method prints all characteristics of class
     * @return string with all characteristics
     */
    @Override
    public String toString(){
        return super.toString() + "Inflatable: " + ("" + this.isInflatable).substring(0, 1).toUpperCase() +
                ("" + this.isInflatable).substring(1).toLowerCase();
    }
}
