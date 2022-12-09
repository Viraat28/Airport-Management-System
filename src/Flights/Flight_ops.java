package Flights;
import Main.Con_func;
import java.util.*;
import java.sql.*;

public class Flight_ops {

    public static void create_flight(Flight flig){
        Connection con = Con_func.getConnection();
    final String SQL = "insert into flights values(?,?,?,?,?)";
    try(PreparedStatement st = con.prepareStatement(SQL)){
        st.setInt(1, flig.getFID());
        st.setString(2, flig.getFname());
        st.setString(3, flig.getStart());
        st.setString(4, flig.getDestination());
        st.setInt(5, flig.getPID());
        st.executeUpdate();
        System.out.println(" Flight record created ");
    }catch(SQLException e){
        e.printStackTrace();
        }
    }

    public static void delete_flight(int FID) {
        Connection con = Con_func.getConnection();
        final String SQL = "delete from flights where fid = ?";
        try (PreparedStatement st = con.prepareStatement(SQL)) {
            st.setInt(1, FID);
            int i = st.executeUpdate();
            if(i==1)System.out.println("Deleted");
            else System.out.println("Record not present");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update_flight(Flight flig){
        Connection con = Con_func.getConnection();
        final String SQL = "update flights set Fname=?, start=?,destination=?,PID=? where FID=?";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setString(1, flig.getFname());
            st.setString(2, flig.getStart());
            st.setString(3, flig.getDestination());
            st.setInt(4, flig.getPID());
            st.setInt(5, flig.getFID());
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" Flight record updated.");
            if(rowsAffected ==0) create_flight(flig);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Flight> getAllFlights(){
        List<Flight> flights = new ArrayList<>();
        Connection con = Con_func.getConnection();
        final String SQL = "select * from flights";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Flight flig = new Flight(rs.getInt("FID"),rs.getString("Fname"),rs.getString("start"),rs.getString("destination"),rs.getInt("PID"));
                flights.add(flig);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flights;
    }

    public static List<Flight> getFlightbyFID(int FID){
        List<Flight> flights = new ArrayList<>();
        Connection con = Con_func.getConnection();
        final String SQL = "select * from flights where FID = ?";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setInt(1,FID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Flight flig = new Flight(rs.getInt("FID"),rs.getString("Fname"),rs.getString("start"),rs.getString("destination"),rs.getInt("PID"));
                flights.add(flig);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flights;
    }

    public static List<Flight> getFlightbyFname(String Fname){
        List<Flight> flights = new ArrayList<>();
        Connection con = Con_func.getConnection();
        final String SQL = "select * from flights where Fname = ?";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setString(1,Fname);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Flight flig = new Flight(rs.getInt("FID"),rs.getString("Fname"),rs.getString("start"),rs.getString("destination"),rs.getInt("PID"));
                flights.add(flig);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flights;
    }

}
