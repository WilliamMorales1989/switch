package com.ec.tvcable.switchaprov.jpa;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: InterfazAprovisionamiento
 * 
 */
@Entity
@Table(name="interfaz_aprovisionamiento")
@NamedQuery(name = "buscarPorAprovisionamiento", query = "select ia from InterfazAprovisionamiento ia where ia.system = :system and ia.activityType = :activityType order by ia.order")
public class InterfazAprovisionamiento implements Serializable {

	private static final long serialVersionUID = 7750068823505377154L;

	@Id
	@Column(name = "ia_id")
	private Long id;

	@Column(name = "ia_system")
	private String system;

	@Column(name = "ia_controller")
	private String controller;

	@Column(name = "ia_activity_type")
	private String activityType;

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

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
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
