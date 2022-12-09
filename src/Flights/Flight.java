package Flights;

abstract class ops_f{
    abstract int getFID();
    abstract String getFname();
}

public class Flight extends ops_f{
    private int FID;
    private String Fname;
    private String start;
    private String destination;
    private int PID;

    public Flight(int FID, String Fname, String start, String destination, int PID){
        this.FID = FID;
        this.Fname = Fname;
        this.start = start;
        this.destination = destination;
        this.PID = PID;
    }

    public Flight(String fligLine){
        String values[] = fligLine.split(",");
        this.FID = Integer.valueOf(values[0]);
        this.Fname = values[1];
        this.start = values[2];
        this.destination = values[3];
        this.PID = Integer.valueOf(values[4]);
    }

    public int getFID(){
        return FID;
    }
    public void setFID(int FID){
        this.FID = FID;
    }

    public String getFname(){
        return Fname;
    }
    public void setFname(String Fname){
        this.Fname = Fname;
    }
    public String getStart(){
        return start;
    }
    public void setStart(String start){
        this.start = start;
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public int getPID(){
        return PID;
    }
    public void setPID(int PID){
        this.PID = PID;
    }
    @Override
     public String toString(){
         return "\nFID= "+ FID+"    , name="+Fname+"    , Start="+start+"   , Destination="+destination+"   , Person ID="+PID;
     }

   
}
