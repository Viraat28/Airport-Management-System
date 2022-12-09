package Pilots;
import java.util.*;
import java.sql.*;
import Main.Con_func;


public class Pilot_ops {

        public static void create_pilot(Pilot pilo){
        Connection con = Con_func.getConnection();
        final String SQL = "insert into pilots values(?,?,?)";
        try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setInt(1, pilo.getPID());
            st.setString(2, pilo.getName());
            st.setFloat(3, pilo.getSalary());
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+ " pilot record created.");
        }catch(SQLException e){}
        }

        public static void delete_pilot(int PID) {
            Connection con = Con_func.getConnection();
            final String SQL = "delete from pilots where pid = ?";
            try (PreparedStatement st = con.prepareStatement(SQL)) {
                st.setInt(1, PID);
                int i = st.executeUpdate();
                if(i==1)System.out.println("Deleted");
                else System.out.println("Record not present");
            } catch (SQLException e) {
            }
        }

        public static void update_pilot(Pilot pilo){
            Connection con = Con_func.getConnection();
            final String SQL = "update pilots set name=?, salary=? where PID=?";
            try(PreparedStatement st = con.prepareStatement(SQL)){
            st.setString(1, pilo.getName());
            st.setFloat(2, pilo.getSalary());
            st.setInt(3, pilo.getPID());
                int rowsAffected = st.executeUpdate();
                System.out.println(rowsAffected+" pilot record updated.");
            if(rowsAffected ==0) create_pilot(pilo);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        public static List<Pilot> getAllPilots(){
            List<Pilot> pilots = new ArrayList<>();
            Connection con = Con_func.getConnection();
            final String SQL = "select * from pilots";
            try(PreparedStatement st = con.prepareStatement(SQL)){
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Pilot pilo = new Pilot(rs.getInt("PID"),rs.getString("Name"),rs.getFloat("salary"));
                    pilots.add(pilo);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return pilots;
        }

        public static List<Pilot> getPilotbyPID(int PID){
            List<Pilot> pilots = new ArrayList<>();
            Connection con = Con_func.getConnection();
            final String SQL = "select * from pilots where PID = ?";
            try(PreparedStatement st = con.prepareStatement(SQL)){
                st.setInt(1, PID);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Pilot pilo = new Pilot(rs.getInt("PID"),rs.getString("Name"),rs.getFloat("salary"));
                    pilots.add(pilo);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return pilots;
        }

        public static List<Pilot> getPilotbySalary(float salary){
            List<Pilot> pilots = new ArrayList<>();
            Connection con = Con_func.getConnection();
            final String SQL = "select * from pilots where salary > ?";
            try(PreparedStatement st = con.prepareStatement(SQL)){
                st.setFloat(1, salary);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Pilot pilo = new Pilot(rs.getInt("PID"),rs.getString("Name"),rs.getFloat("salary"));
                    pilots.add(pilo);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return pilots;
        }

}