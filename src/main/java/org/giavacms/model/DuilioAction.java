package org.giavacms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.giavacms.enums.ServiceType;

@Entity
public class DuilioAction implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date data;
	private User user;
	private ServiceType serviceType;
	private List<DuilioParam> duilioParams;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@OneToMany
	public List<DuilioParam> getDuilioParams() {
		return duilioParams;
	}

	public void setDuilioParams(List<DuilioParam> duilioParams) {
		this.duilioParams = duilioParams;
	}
}
