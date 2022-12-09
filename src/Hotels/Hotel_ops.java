package Hotels;
import Main.Con_func;
import java.util.*;
import java.sql.*;

public class Hotel_ops {
    
    public static void create_hotel(Hotel hote){
        Connection con = Con_func.getConnection();
    final String SQL = "insert into hotels values(?,?,?)";
    try(PreparedStatement st = con.prepareStatement(SQL)){
        st.setString(1, hote.getHID());
        st.setString(2, hote.getHname());
        st.setInt(3, hote.getFID());
        int rowsAffected = st.executeUpdate();
        System.out.println(rowsAffected+" Hotel record created.");
    }catch(SQLException e){
        e.printStackTrace();
        }
    }

    public static void delete_hotel(String HID) {
        Connection con = Con_func.getConnection();
        final String SQL = "delete from hotels where hid = ?";
        try (PreparedStatement st = con.prepareStatement(SQL)) {
            st.setString(1, HID);
            int i = st.executeUpdate();
            if(i==1)System.out.println("Deleted");
            else System.out.println("Record not present");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update_hotel(Hotel hote){
            Connection con = Con_func.getConnection();
            final String SQL = "update hotels set Hname=?, FID=? where HID=?";
            try(PreparedStatement st = con.prepareStatement(SQL)){
                st.setString(1, hote.getHname());
                st.setFloat(2, hote.getFID());
                st.setString(3, hote.getHID());
                int rowsAffected = st.executeUpdate();
                System.out.println(rowsAffected+" Hotel record updated.");
                if(rowsAffected ==0) create_hotel(hote);
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    public static List<Hotel> getAllHotels(){
        List<Hotel> hotels = new ArrayList<>();
        Connection con = Con_func.getConnection();
        final String SQL = "select * from hotels";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Hotel hote = new Hotel(rs.getString("HID"),rs.getString("Hname"),rs.getInt("FID"));
                hotels.add(hote);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hotels;
    }

    public static List<Hotel> getHotelbyHID(String HID){
        List<Hotel> hotels = new ArrayList<>();
        Connection con = Con_func.getConnection();
        final String SQL = "select * from hotels where HID = ?";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setString(1,HID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Hotel hote = new Hotel(rs.getString("HID"),rs.getString("Hname"),rs.getInt("FID"));
                hotels.add(hote);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hotels;
    }
}