package Main;
import java.io.*;
import Flights.*;
import Hotels.*;
import Pilots.*;

public class App {
    public static void main(String[] args) {
        
        switch(args[0]){
            case "-h" :
            default   : System.out.println("Enter '-load' to load data");
                        System.out.println("Enter '-cp' to insert pilot details");
                        System.out.println("Enter '-up' to update pilot details");
                        System.out.println("Enter '-dp' to delete pilot details by pilot id");
                        System.out.println("Enter '-gp' to get all pilot details");
                        System.out.println("Enter '-gpbypid' to get pilot details by pilot ID");
                        System.out.println("Enter '-gpbysalary' to get pilot details whose salary is greater than given value");
                        System.out.println("Enter '-cf' to insert flight details");
                        System.out.println("Enter '-uf' to update flight details");
                        System.out.println("Enter '-df' to delete flight details by flight ID");
                        System.out.println("Enter '-gf' to get all flight details");
                        System.out.println("Enter '-gfbyfid' to get flight details by flight ID");
                        System.out.println("Enter '-ch' to insert hotel details");
                        System.out.println("Enter '-uh' to update hotel details");
                        System.out.println("Enter '-dh' to delete hotel details by hotel ID");
                        System.out.println("Enter '-gh' to get all hotel details");
                        System.out.println("Enter '-ghbyhid' to get hotel details by hotel ID");
                        System.out.println("Enter '-gfbyfname' to get flight details by flight name");
                            break;

            case "-load" : {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("D:\\SEM-3\\Final Project\\Project\\src\\Pilots\\pilots.csv"));
                    String piloLine;
                    while((piloLine = reader.readLine())!=null){
                        Pilot_ops.create_pilot(new Pilot(piloLine));
                    }
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("D:\\SEM-3\\Final Project\\Project\\src\\Flights\\flights.csv"));
                    String fligLine;
                    while((fligLine = reader.readLine())!=null){
                        Flight_ops.create_flight(new Flight(fligLine));
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("D:\\SEM-3\\Final Project\\Project\\src\\Hotels\\hotels.csv"));
                    String hoteLine;
                    while((hoteLine = reader.readLine())!=null){
                        Hotel_ops.create_hotel(new Hotel(hoteLine));
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }               
                    break;
            case "-cp" : {
                    int PID = Integer.parseInt(args[1]);
                    String name = args[2];
                    float salary = Float.parseFloat(args[3]);
                    Pilot pilo = new Pilot(PID, name, salary);
                    Pilot_ops.create_pilot(pilo);
                }
                    break;

                case "-cf" : {
                    int FID = Integer.parseInt(args[1]);
                    String Fname = args[2];
                    String start = args[3];
                    String destination = args[4];
                    int PID = Integer.parseInt(args[5]);
                    Flight flig = new Flight(FID, Fname, start, destination, PID);
                    Flight_ops.create_flight(flig);
                }
                    break;

                case "-ch" : {
                    String HID = args[1];
                    String Hname = args[2];
                    int FID = Integer.parseInt(args[3]);
                    Hotel hote = new Hotel(HID, Hname, FID);
                    Hotel_ops.create_hotel(hote);
                }
                    break;

                 case "-up" : {
                     int PID = Integer.valueOf(args[1]);
                     String name = args[2];
                     Float salary = Float.valueOf(args[3]);
                     
                     Pilot pilo = new Pilot(PID, name, salary);
                     Pilot_ops.update_pilot(pilo);
                 }   
                 break; 

                 case "-uf" : {
                    int FID = Integer.valueOf(args[1]);
                     String Fname = args[2];
                     String start = args[3];
                     String destination = args[4];
                     int PID = Integer.valueOf(args[5]);
                     Flight flig = new Flight(FID, Fname, start, destination, PID);
                     Flight_ops.update_flight(flig);
                 }
                        break;
                 case "-uh" : {
                     String HID = args[1];
                     String Hname = args[2];
                     int FID = Integer.valueOf(args[3]);
                     Hotel hote = new Hotel(HID, Hname, FID);
                     Hotel_ops.update_hotel(hote);
                 }
                    break;

                 case "-dp": {
                    Pilot_ops.delete_pilot(Integer.valueOf(args[1]));
                 }
                 break;

                case "-df" : {
                    Flight_ops.delete_flight(Integer.valueOf(args[1]));
                }
                    break;

                case "-dh" : {
                    Hotel_ops.delete_hotel(args[1]);
                }   
                break; 
                 case "-gp" : {
                     System.out.println(Pilot_ops.getAllPilots());
                 }
                 break;

                 case "-gf" : {
                    System.out.println(Flight_ops.getAllFlights());
                }
                break;

                case "-gh" : {
                    System.out.println(Hotel_ops.getAllHotels());
                }
                break;
                  
                case "-gpbypid" :{   
                    System.out.println(Pilot_ops.getPilotbyPID(Integer.valueOf(args[1])));
                 }
                break;
                 case "-gpbysalary" :{   
                    System.out.println(Pilot_ops.getPilotbySalary(Float.valueOf(args[1])));
                 }
                break;

                case "-gfbyfid" :{
                    System.out.println(Flight_ops.getFlightbyFID(Integer.valueOf(args[1])));
                }
                    break;

                case "-ghbyhid":{
                    System.out.println(Hotel_ops.getHotelbyHID(args[1]));
                }  
                break;

                case "-gfbyfname" :{
                    System.out.println(Flight_ops.getFlightbyFname(args[1]));
                }
                    break;
            
        }
        
    }
}
