
public class c2a2q4_2021_AleksejsPolikarpovs {
    public static void main(String[] args) {
		
		
        Dinghy dinghy1 = new Dinghy();                                          // dinghy1 instance with default parameters
        System.out.println(dinghy1.toString());

        Vessel vessel1 = new Vessel("Yamamori", 133.5, "Japan", 1999);          // vessel1 instance
        System.out.println(vessel1.toString());

        Boat boat1 = new Boat("Cruiser", 56, "Germany", 2005, "wheel");         // boat1 with steering wheel type
        System.out.println(boat1.toString());

        Dinghy dinghy2 = new Dinghy("T-1000", 5, "USA");                        // dinghy2 instance with 3 parameters, rest will be set to default
        System.out.println(dinghy2.toString());

        dinghy2.setIsInflatable(true);                                          // set missing parameters inheriting from parent classes(inheritance)
        dinghy2.setSteeringType("tiller");
        dinghy2.setYearOfManufacture(1991);
        System.out.println(dinghy2.toString());
		
    }



}