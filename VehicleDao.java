package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;





public class VehicleDao extends GenericDao {
	public void addVehicle(Vehicle veh) throws SQLException {
		String a=JOptionPane.showInputDialog(" type Brand : ");
		String b=JOptionPane.showInputDialog(" type Moudle: ");
		String c=JOptionPane.showInputDialog(" type Year : ");
		int C =Integer.parseInt(c);
		String d=JOptionPane.showInputDialog(" type VenNumber : ");
		veh.setVehBrand(a);
		veh.setVehMoudle(b);
		veh.setVehYear(C);
		veh.setVehVennum(d);
		PreparedStatement ps = getPreparedStatement("INSERT INTO vehicle (veh_brand,veh_moudle,veh_year,veh_vennum) VALUES(?,?,?,?)");
		ps.setString(1, veh.getVehBrand());
		ps.setString(2, veh.getVehMoudle());
		ps.setInt(3, veh.getVehYear());
		ps.setString(4, veh.getVehVennum());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Added sucsessfully");
		try {
			
			ArrayList<Vehicle> printVehicle = printVehicle();
			for (Vehicle v : printVehicle) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public Vehicle findVehicleId(int id) throws SQLException {
		PreparedStatement ps = getPreparedStatement("SELECT * FROM vehicle WHERE veh_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Vehicle veh = new Vehicle();
		while (rs.next()) {
			
			veh = setterVehicle(rs);
			
		}
		return veh;
	}
	private Vehicle setterVehicle(ResultSet rs) throws SQLException {
		Vehicle veh=new Vehicle();
		veh.setVehId(rs.getInt("veh_id"));
		veh.setVehBrand(rs.getString("veh_brand"));
		veh.setVehMoudle(rs.getString("veh_moudle"));
		veh.setVehYear(rs.getInt("veh_year"));
		veh.setVehVennum(rs.getString("veh_vennum"));
		return veh;
	}
	
	public ArrayList<Vehicle> printVehicle() throws SQLException {
		PreparedStatement ps = getPreparedStatement("SELECT * FROM vehicle");
		ResultSet rs = ps.executeQuery();
		ArrayList<Vehicle> printVehicle = new ArrayList<>();
		while (rs.next()) {
			printVehicle.add(setterVehicle(rs));
		}
		return printVehicle;
	}
	public void updateVehicle(Vehicle veh) throws SQLException {
		String A=JOptionPane.showInputDialog(" type id : ");
		int aa =Integer.parseInt(A);
		veh.setVehId(aa);
		findVehicleId(aa);
		String a=JOptionPane.showInputDialog(" type Brand : ");
		String b=JOptionPane.showInputDialog(" type Moudle: ");
		String c=JOptionPane.showInputDialog(" type Year : ");
		String d=JOptionPane.showInputDialog(" type VenNumber : ");
		int C =Integer.parseInt(c);
		veh.setVehBrand(a);
		veh.setVehMoudle(b);
		veh.setVehYear(C);
		veh.setVehVennum(d);
		
		PreparedStatement ps = getPreparedStatement("UPDATE Vehicle SET Veh_brand = ? , veh_moudle = ? ,veh_year = ?, veh_vennum = ? WHERE veh_id= ? ");
		
		ps.setString(1, veh.getVehBrand());
		ps.setString(2, veh.getVehMoudle());
		ps.setInt(3, veh.getVehYear());
		ps.setString(4, veh.getVehVennum());
		ps.setInt(5, veh.getVehId());
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Updated sucsessfully");
try {
			
			ArrayList<Vehicle> printVehicle = printVehicle();
			for (Vehicle v : printVehicle) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void deleteVehicle(Vehicle vehicle) throws SQLException {
		String b=JOptionPane.showInputDialog(" type id : ");
		vehicle.setVehId(Integer.parseInt(b));
		PreparedStatement ps = getPreparedStatement("DELETE FROM Vehicle WHERE veh_id= ?");
		ps.setInt(1, vehicle.getVehId());
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Deleted sucsessfully");
		}
}
