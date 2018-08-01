package co.com.bancolombia.certificacion.vulcanofiduciaria.questions;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.bancolombia.certificacion.vulcanofiduciaria.util.Sql_Execute;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Verificar implements Question <Integer>{
	
		

	@Override
	public Integer answeredBy(Actor actor) {
		String strQuery ="SELECT SDCUENTA, SDSDODSP FROM SCILIBRAMD/SCIFFSALDO WHERE SDCUENTA IN (40612400028, 113643701)";
		System.out.println(strQuery);
		Sql_Execute DAO = new Sql_Execute ();
		ResultSet rs = null;
		int saldo=0;
		try {
			rs = DAO.sql_Execute (strQuery);
			saldo = rs.getInt(1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Datos:"+ rs);
		return saldo;
		
		
				
		
	}
	
	public static Verificar aumentodeSaldo() {
		return new Verificar();
	}

	
			
	
	

}
