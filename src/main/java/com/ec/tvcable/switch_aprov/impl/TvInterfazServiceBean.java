/**
 * 
 */
package com.ec.tvcable.switch_aprov.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switch_aprov.ComandoEmsInterfaces;
import com.ec.tvcable.switch_aprov.DatosTvPagada;
import com.ec.tvcable.switch_aprov.InterfaceInvocationResponse;
import com.ec.tvcable.switch_aprov.TvInterfaceService;
import com.ec.tvcable.switch_aprov.exception.ConversionException;
import com.ec.tvcable.switch_aprov.exception.DataQueryException;
import com.ec.tvcable.switch_aprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switch_aprov.servicio.ems.EMS_Type;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Cabecera;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Comando;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Comienzo;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Detalle;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Final;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.IdEventos;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.IdPaquetes;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Mensaje;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Respuesta;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.TVpagada;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.WsdlTvPagada;

/**
 * @author pablo
 * 
 */
@Service(TvInterfaceService.class)
public class TvInterfazServiceBean implements TvInterfaceService {

	@Reference
	@Inject
	private WsdlTvPagada wsdlTvPagada;

	@Reference
	@Inject
	private DatosTvPagada datosTvPagada;

	private Logger logger = Logger.getLogger(TvInterfazServiceBean.class);

	private Respuesta respuesta;
	private String actualInterface;

	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(ComandoEmsInterfaces comandoEmsInterfaces) {
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();

		try {
			Comando comando = createComando(comandoEmsInterfaces.getComandoEms());
			for (String interf : comandoEmsInterfaces.getInterfaces()) {
				System.out.println("inerf: " + interf);
				actualInterface = interf;
				comando.getCabecera().setInterface(Integer.parseInt(interf));
				respuesta = invokeAprovTvpagada(comando);
				responses.add(generateResponse());
				if (failedExecution())
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			genFailedResponse(e);
			responses.add(generateResponse());
		}
		return responses;
	}

	private boolean failedExecution() {
		return respuesta.getMensaje().getCodError() > 0;
	}

	public void genFailedResponse(Exception e) {
		respuesta = new Respuesta();
		Mensaje mensaje = new Mensaje();
		// TODO: Definir codigo de erorr
		mensaje.setCodError(100);
		mensaje.setDetMensaje(e.getMessage());

		respuesta.setMensaje(mensaje);
	}

	public Respuesta invokeAprovTvpagada(Comando comando) {
		return wsdlTvPagada.AprovTvPagada(comando);
	}

	@Override
	public InterfaceInvocationResponse generateResponse() {
		InterfaceInvocationResponse iir = new InterfaceInvocationResponse();
		iir.setInterfaz(actualInterface);
		Mensaje mensaje = respuesta.getMensaje();
		iir.setCodError(mensaje.getCodError());
		iir.setDetMensaje(mensaje.getDetMensaje());

		return iir;
	}

	private Comando createComando(EMS_Type comandoEms) throws ConversionException, DataQueryException {
		TransactionSpTvPagada transactionSp = null;
		transactionSp = datosTvPagada.findByDevice(comandoEms.getBody().getProcessId());

		if (!transactionSp.isValid()) {
			throw new ConversionException("El registro de datos esta marcado cono invalido");
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
		tvPagada.setIdConvertidor(transactionSp.getIdConvertidor());

		IdEventos idEventos = new IdEventos();
		idEventos.setCantE(transactionSp.getValorEnteroDe("IdEventos"));
		tvPagada.setIdEventos(idEventos);

		IdPaquetes idPaquetes = new IdPaquetes();
		idPaquetes.setCantP(transactionSp.getValorEnteroDe("IdPaquetes"));
		tvPagada.setIdPaquetes(idPaquetes);

		tvPagada.setIdServicio(transactionSp.getValorEnteroDe("IdServicio"));
		tvPagada.setInterstitial(transactionSp.getValorEnteroDe("Interstitial"));
		tvPagada.setLenguaje(transactionSp.getValorEnteroDe("Lenguaje"));
		tvPagada.setMpaa(transactionSp.getValorEnteroDe("Mpaa"));
		tvPagada.setPaquete(transactionSp.getValorEnteroDe("Paquete"));
		tvPagada.setPrecioEvento(transactionSp.getValorEnteroDe("PrecioEvento"));
		tvPagada.setRating(transactionSp.getValorEnteroDe("Rating"));
		tvPagada.setSerie(transactionSp.getSerie());
		tvPagada.setTiempoCompra(transactionSp.getValorEnteroDe("TiempoCompra"));
		tvPagada.setTiempoDisplay(transactionSp.getValorEnteroDe("TiempoDisplay"));
		tvPagada.setTiempoLibre(transactionSp.getValorEnteroDe("TiempoLibre"));
		tvPagada.setTipoA(transactionSp.getValorEnteroDe("TipoA"));
		tvPagada.setTipoC(transactionSp.getValorEnteroDe("TipoC"));
		tvPagada.setTipoD(transactionSp.getValorEnteroDe("TipoD"));
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