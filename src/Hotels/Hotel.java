package Hotels;

abstract class ops_h{
    abstract String getHID();
    abstract String getHname();
}

public class Hotel extends ops_h{
    private String HID;
    private String Hname;
    private int FID;

    public Hotel(String HID, String Hname,int FID){
        this.HID = HID;
        this.Hname = Hname;
        this.FID = FID;
    }

    public Hotel(String hoteLine){
        String values[] = hoteLine.split(",");
        this.HID = values[0];
        this.Hname = values[1];
        this.FID = Integer.valueOf(values[2]);
    }

    public String getHID(){
        return HID;
    }
    public void setHID(String HID){
        this.HID = HID;
    }

    public String getHname() {
        return Hname;
    }
    public void setHname(String Hname) {
        this.Hname = Hname;
    }
    public int getFID(){
        return FID;
    }
    public void setFID(int FID){
        this.FID = FID;
    }

    @Override
    public String toString(){
        return "\nHID= "+ HID+", Hname="+Hname+", FID="+FID;
    }
}
