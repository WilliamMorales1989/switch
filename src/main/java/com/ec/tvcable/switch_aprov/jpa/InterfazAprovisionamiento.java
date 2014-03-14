package com.ec.tvcable.switch_aprov.jpa;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: InterfazAprovisionamiento
 * 
 */
@Entity
@Table(name="INTERFAZ_APROVISIONAMIENTO")
@NamedQuery(name = "buscarPorAprovisionamiento", query = "select ia from InterfazAprovisionamiento ia where ia.target = :target and ia.function = :function order by ia.order")
public class InterfazAprovisionamiento implements Serializable {

	private static final long serialVersionUID = 7750068823505377154L;

	@Id
	@Column(name = "ia_id")
	private Long id;

	@Column(name = "ia_target")
	private String target;

	@Column(name = "ia_controller")
	private String controller;

	@Column(name = "ia_function")
	private String function;

	@Column(name = "ia_interfaceCode")
	private String interfaceCode;

	@Column(name = "ia_order")
	private Integer order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
