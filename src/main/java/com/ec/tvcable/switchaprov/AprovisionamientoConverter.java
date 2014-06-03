/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switchaprov.service.tvpagada.Cabecera;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Comienzo;
import com.ec.tvcable.switchaprov.service.tvpagada.Detalle;
import com.ec.tvcable.switchaprov.service.tvpagada.Final;
import com.ec.tvcable.switchaprov.service.tvpagada.IdEventos;
import com.ec.tvcable.switchaprov.service.tvpagada.IdPaquete;
import com.ec.tvcable.switchaprov.service.tvpagada.IdPaquetes;
import com.ec.tvcable.switchaprov.service.tvpagada.TVpagada;

/**
 * @author pablo
 *
 */
public class AprovisionamientoConverter {
	
	private TransactionSpTvPagada transactionSp;
	
	public AprovisionamientoConverter(TransactionSpTvPagada transactionSp) {
		super();
		this.transactionSp = transactionSp;
	}

	public Comando toComandoTv() throws ConversionException {

		if (!transactionSp.isValid()) {
			throw new ConversionException("El registro de datos esta marcado como invalido");
		}

		Comando comando = new Comando();
		comando.setCabecera(createHeader(transactionSp));
		Detalle detalle = new Detalle();
		detalle.setTVpagada(createTvPagada(transactionSp));
		comando.setDetalle(detalle);
		return comando;
	}

	private TVpagada createTvPagada(TransactionSpTvPagada transactionSp) throws ConversionException {
		TVpagada tvPagada = new TVpagada();
		tvPagada.setAccion(transactionSp.getValorEnteroDe("Accion"));
		tvPagada.setAnyTime(transactionSp.getValorEnteroDe("AnyTime"));
		tvPagada.setCItem(transactionSp.getValorEnteroDe("cItem"));
		tvPagada.setCodigoCanal(transactionSp.getValorEnteroDe("CodigoCanal"));

		Comienzo comienzo = new Comienzo();
		comienzo.setFechaIni(transactionSp.getComienzoEventoFechaIni());
		comienzo.setTiempoIni(transactionSp.getComienzoEventoTiempoIni());
		tvPagada.setComienzo(comienzo);

		tvPagada.setContenidoSexual(transactionSp.getValorEnteroDe("ContenidoSexual"));
		tvPagada.setContenidoViolento(transactionSp.getValorEnteroDe("ContenidoViolento"));
		tvPagada.setCostoEvento(transactionSp.getValorEnteroDe("CostoEvento"));
		tvPagada.setCredito(transactionSp.getValorEnteroDe("Credito"));
		tvPagada.setDatoC1(transactionSp.getDatoC1());
		tvPagada.setDatoC2(transactionSp.getDatoC2());
		tvPagada.setDescEvento(transactionSp.getDescEvento());
		tvPagada.setDuracionEvento(transactionSp.getValorEnteroDe("DuracionEvento"));
		tvPagada.setEstadoC(transactionSp.getEstadoC());

		Final fechaFinal = new Final();
		fechaFinal.setFechaFin(transactionSp.getFinalEventoFechaFin());
		fechaFinal.setTiempoFin(transactionSp.getFinalEventoTiempoFin());
		tvPagada.setFinal(fechaFinal);

		tvPagada.setFormaPago(transactionSp.getFormaPago());
		tvPagada.setIdAccount(transactionSp.getValorEnteroDe("IdAccount"));

		IdEventos idEventos = new IdEventos();
		idEventos.setCantE(transactionSp.getValorEnteroDe("IdEventos"));
		tvPagada.setIdEventos(idEventos);
		
		IdPaquetes idPaquetes = new IdPaquetes();
		IdPaquete idPaquete = new IdPaquete();
		System.out.println("transactionSp.getIdPaquetes()="+transactionSp.getIdPaquetes());
		List<String> paquetes = new ArrayList<String>(Arrays.asList(transactionSp.getIdPaquetes().split(",")));
		System.out.println("paquetes.size():"+paquetes.size());
		for (int i=0; i<paquetes.size(); i++){
			System.out.println("paquetes.get(i):"+paquetes.get(i));
			idPaquete.setIdPaquete(Integer.parseInt(paquetes.get(i)));
			idPaquetes.getIdPaquete().add(idPaquete);
		}
		idPaquetes.setCantP(paquetes.size());		
		tvPagada.setIdPaquetes(idPaquetes);

		tvPagada.setIdServicio(transactionSp.getValorEnteroDe("IdServicio"));
		tvPagada.setInterstitial(transactionSp.getValorEnteroDe("Interstitial"));
		tvPagada.setLenguaje(transactionSp.getValorEnteroDe("Lenguaje"));
		tvPagada.setMpaa(transactionSp.getValorEnteroDe("Mpaa"));
		tvPagada.setPaquete(transactionSp.getValorEnteroDe("Paquete"));
		tvPagada.setPrecioEvento(transactionSp.getValorEnteroDe("PrecioEvento"));
		tvPagada.setRating(transactionSp.getValorEnteroDe("Rating"));
		tvPagada.setTiempoCompra(transactionSp.getValorEnteroDe("TiempoCompra"));
		tvPagada.setTiempoDisplay(transactionSp.getValorEnteroDe("TiempoDisplay"));
		tvPagada.setTiempoLibre(transactionSp.getValorEnteroDe("TiempoLibre"));
		tvPagada.setTipoA(transactionSp.getValorEnteroDe("TipoA"));
		tvPagada.setTipoC(transactionSp.getValorEnteroDe("TipoC"));
		tvPagada.setTipoPromocion(transactionSp.getValorEnteroDe("TipoPromocion"));
		tvPagada.setUbicacion(transactionSp.getValorEnteroDe("Ubicacion"));
		return tvPagada;
	}

	private Cabecera createHeader(TransactionSpTvPagada transactionSp) throws ConversionException {
		Cabecera cabecera = new Cabecera();
		cabecera.setIDEmpresa(transactionSp.getValorEnteroDe("IdEmpresa"));
		cabecera.setInterface(transactionSp.getValorEnteroDe("DeviceId"));
		cabecera.setNegocio(transactionSp.getValorEnteroDe("Negocio"));
		cabecera.setSecuencia(transactionSp.getValorEnteroDe("Secuencia"));
		return cabecera;
	}


}
