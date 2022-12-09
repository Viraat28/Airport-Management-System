package Pilots;

abstract class ops_p{
    abstract int getPID();
    abstract String getName();
    abstract float getSalary();
}

public class Pilot extends ops_p{
    private int PID;
    private String name;
    private float salary;
    
    public Pilot(int PID, String name, float salary){
        this.PID = PID;
        this.name = name;
        this.salary = salary;
    }

    public Pilot(String piloLine){
         String values[] = piloLine.split(",");
         this.PID = Integer.valueOf(values[0]);
         this.name = values[1];
         this.salary = Float.valueOf(values[2]);
    }

    public int getPID(){
        return PID;
    }
    public void setPID(int PID){
        this.PID = PID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getSalary(){
        return salary;
    }
    public void setSalary(float salary){
        this.salary=salary;
    }
     @Override
     public String toString(){
         return "\nPID= "+ PID+", name="+name+", salary="+salary;
     }

}
