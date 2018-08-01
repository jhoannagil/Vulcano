package co.com.bancolombia.certificacion.vulcanofiduciaria.util;

import co.com.bancolombia.certificacion.vulcanofiduciaria.model.CargaUtilTrama;

public class StringUtilidades {

	public static String generarEspaciosEnBlanco(int numeroEspacios) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < numeroEspacios; i++) {
			builder.append(" ");
		}
		return builder.toString();

	}

	public static String generarTrama(CargaUtilTrama cargaUtilTrama) {
		StringBuilder builder = new StringBuilder();
		builder.append(cargaUtilTrama.gettipId()).append(cargaUtilTrama.getnroId()).append(cargaUtilTrama.gettipCta())
				.append(cargaUtilTrama.getnroCta()).append(cargaUtilTrama.getfondo()).append(cargaUtilTrama.getnroEnc())
				.append(cargaUtilTrama.getvalor()).append(generarEspaciosEnBlanco(cargaUtilTrama.getequipo()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getusuario())).append(cargaUtilTrama.getfecha())
				.append(cargaUtilTrama.getsistemaOrigen()).append(cargaUtilTrama.getidJob())
				.append(cargaUtilTrama.getclaveTef()).append(cargaUtilTrama.getcomision())
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getplazo()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getindDeb()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.gettipIdTr()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getnumIdTr()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getclvTefDB()))
				.append(generarEspaciosEnBlanco(cargaUtilTrama.getindMovDep())).append(cargaUtilTrama.getvalorGMF())
				.append(cargaUtilTrama.gettipCtaPte()).append(cargaUtilTrama.getnunmeroCuentaPuente());

		return builder.toString();
	}
}
