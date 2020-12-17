package project;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class TestVehicle {
public static void main(String[] args) throws SQLException {
	Vehicle veh=new Vehicle();
	VehicleDao veh_dao=new VehicleDao();
	Object[] button = {  "New Vehicle", "Find", "Update", "Delete","Show All" };

	int x = JOptionPane.showOptionDialog(null, "please select a button ", "(ALIBANYALI) Vehicle App",
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, button[4]);

	switch(x) 
	{
	case 0:
	try {
	
	veh_dao.addVehicle(veh);
} catch (SQLException e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}//add
		break;
	case 1:
		String aa=JOptionPane.showInputDialog(" type the id: ");
		int A =Integer.parseInt(aa);
		System.out.println(veh_dao.findVehicleId(A));
	    break;
	
	case 2:
		veh_dao.updateVehicle(veh);
		
		break;
	case 3:
		veh_dao.deleteVehicle(veh);
		break;
	case 4:
		try {
			
					ArrayList<Vehicle> printVehicle = veh_dao.printVehicle();
					for (Vehicle v : printVehicle) {
						System.out.println(v);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		break;
	
	
	}
	
	
}
}
