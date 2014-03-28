/**
 * 
 */
package com.ec.tvcable.switchaprov.exception;

/**
 * @author pablo
 * 
 */
public class ExceptionProcessor {

	private Throwable exception;

	public ExceptionProcessor(Throwable exception) {
		super();
		this.exception = exception;
	}

	public String buildDetailMessage() {
		StringBuilder sb = new StringBuilder(120);
		Throwable e = exception;
		while (e != null) {
			sb.append(String.format("%s : %s | ", e,
					e.getMessage() == null ? "" : e.getMessage()));
			e = e.getCause();
		}
		return sb.toString();
	}
}