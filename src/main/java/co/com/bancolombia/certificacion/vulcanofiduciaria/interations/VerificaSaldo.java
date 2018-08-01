package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.bancolombia.certificacion.vulcanofiduciaria.util.Sql_Execute;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;


public class VerificaSaldo implements Interaction {
	
	

	@Override
	public <T extends Actor> void performAs(T actor) {
			
		
	}
	
	String strQuery ="SELECT SDCUENTA, SDSDODSP FROM SCILIBRAMD/SCIFFSALDO WHERE SDCUENTA IN (40612400028, 113643701)";
	Sql_Execute DAO;
	ResultSet rs;
	
	public  ResultSet ejecutarQuery () throws SQLException {
	
	Sql_Execute DAO = new Sql_Execute ();
	ResultSet rs = DAO.sql_Execute (strQuery);
	return rs;
}
	


}
