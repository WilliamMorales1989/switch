package com.ec.tvcable.switch_aprov;

import java.util.List;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switch_aprov.jpa.TransactionSpResponse;
import com.ec.tvcable.switch_aprov.servicio.ems.EMS;
import com.ec.tvcable.switch_aprov.servicio.ems.EMSResponse;
import com.ec.tvcable.switch_aprov.servicio.ems.EMS_Type;
import com.ec.tvcable.switch_aprov.servicio.ems.Header;

@Service(EMS.class)
public class EMSBean implements EMS {
	
	@Inject
	@Reference
	private TvInterfaceService tvInterfaceService;

	@Inject
	@Reference
	private IntrawayInterfaceService interfaz600;

	@Inject
	@Reference
	private InterfazResolver interfazResolver;

	private EMSResponse response = new EMSResponse();

	@Reference
	@Inject
	private TransactionResponseService transactionResponseService;

	@Override
	public EMSResponse EMS(EMS_Type ejecutaComando) {
		Header header = ejecutaComando.getHeader();

		Operation operation = new Operation(header.getTarget(), header.getFunction());

		List<String> interfaces = interfazResolver.resolveInterfaces(operation);

		StringBuffer responseMessage = new StringBuffer(80);
		
		List<InterfaceInvocationResponse> responses = invokeService(interfaces, ejecutaComando);
		
		for (InterfaceInvocationResponse iir : responses) {
			responseMessage.append(iir.getDetailMessage());
		}
		
		TransactionSpResponse transactionResponse = new TransactionSpResponse();
		transactionResponse.setDetMensaje(response.getErrorMessage());
		transactionResponseService.store(transactionResponse);

		response.setErrorMessage(responseMessage.toString());

		return response;
	}

	private List<InterfaceInvocationResponse> invokeService(List<String> interfaces, EMS_Type comandoEms) {
		
		if ("INT".equals(comandoEms.getHeader().getTarget())) {
			return interfaz600.invokeInterfaces(comandoEms);
		}
		if ("TV".equals(comandoEms.getHeader().getTarget())) {
			System.out.println("llama: " + interfaces.size());
			return tvInterfaceService.invokeInterfaces(new ComandoEmsInterfaces(comandoEms, interfaces));
		}
		return null;
	}

}