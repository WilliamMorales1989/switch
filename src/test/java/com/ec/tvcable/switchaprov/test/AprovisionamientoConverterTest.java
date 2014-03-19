/**
 * 
 */
package com.ec.tvcable.switchaprov.test;

import org.junit.Assert;
import org.junit.Test;

import com.ec.tvcable.switchaprov.AprovisionamientoConverter;
import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;

/**
 * @author pablo
 * 
 */
public class AprovisionamientoConverterTest extends BaseTest {

	@Test
	public void noConvertirValoresVacios() {
		TransactionSpTvPagada transactionSp = createDatosTvPagada();
		transactionSp.setCredito(null);
		try {
			AprovisionamientoConverter converter = new AprovisionamientoConverter(transactionSp);
			Comando comandoTv = converter.toComandoTv();
			Assert.assertEquals(0, comandoTv.getDetalle().getTVpagada().getCredito());
		} catch (ConversionException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(expected = ConversionException.class)
	public void exceptionIfInvalid() throws ConversionException {
		TransactionSpTvPagada transactionSp = createDatosTvPagada();
		transactionSp.setIsValid("N");
		AprovisionamientoConverter converter = new AprovisionamientoConverter(transactionSp);
		converter.toComandoTv();
	}

	@Test(expected = ConversionException.class)
	public void exceptionIfNotNumber() throws ConversionException {
		TransactionSpTvPagada transactionSp = createDatosTvPagada();
		transactionSp.setContenidoViolento("NO");
		AprovisionamientoConverter converter = new AprovisionamientoConverter(transactionSp);
		converter.toComandoTv();
	}

}