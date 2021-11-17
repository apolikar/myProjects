/*
	I will go in to detail with this class example.
	Later I will comment only unique lines (like method overriding and when class inherits from super-class or otherwise)
*/
public class Vessel {                                                                               // Vessel is super-class, Boat and Dinghy is sub-classes inherits from Vessel

    private String name;                                                                            // private super-class instance variables(fields) will be inherited by sub-classes((super) in their own constructors)
    private double length;
    private String make;
    private int yearOfManufacture;

    /**
     * constructors will validate value
     * if validation fails it will set value to "Unknown" or -1
     */
    public Vessel(String name, double length, String make, int yearOfManufacture){                  // parameterized overloaded constructors
        this.name = name.length() > 0 ? name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase() : "Unknown";
        this.length = length > 0 ? length : -1;
        this.make = make.length() > 0 ? make.substring(0, 1).toUpperCase() +
                make.substring(1).toLowerCase() : "Unknown";
        this.yearOfManufacture = yearOfManufacture > 0 ? yearOfManufacture : -1;
    }

    public Vessel(String name, double length, String make){
        this(name, length, make, -1);
    }

    public Vessel(String name, double length){
        this(name, length, "Unknown", -1);
    }

    public Vessel(String name){
        this(name, -1, "Unknown", -1);
    }

    public Vessel(){                                                                                 // no-args(default) constructor. If parameterized constructor is not provided it will be created automatically to successfully compile code
        this("Unknown", -1, "Unknown", -1);                                                          // in our case we set default parameters for no-args constructor
    }

    public String getName() {                                                                        // getter to get characteristic(private) of object outside class(public)
        return name;                                                                                 // returns name
    }

    public void setName(String name) {                                                               // setter to set characteristic(private) to some value outside class(public)
        this.name = name;                                                                            // change value of characteristic
    }

    public double getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * method prints all characteristics of class
     * @return string with all characteristics
     */
    public String toString(){
        return "\n" + "Name: " + this.name + "\n" + "Length: " + (int)this.length + "\n" +
                "Make: " + this.make + "\n" + "Year Of Manufacture: " +
                this.yearOfManufacture + "\n";
    }
}