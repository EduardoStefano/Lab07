package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class BlackOut {
	
	private LocalDateTime dataInizioBlackOut;
	private LocalDateTime dataFineBlackOut;
	private int nercId;
	private int areaId;
	private int customerAffected;
	private int eventTypeId;
	private Long oreGuasto;
	private int anno;
	
	public BlackOut(){
		
	}

	public LocalDateTime getDataInizioBlackOut() {
		return dataInizioBlackOut;
	}

	public void setDataInizioBlackOut(LocalDateTime dataInizioBlackOut) {
		this.dataInizioBlackOut = dataInizioBlackOut;
	}

	public LocalDateTime getDataFineBlackOut() {
		return dataFineBlackOut;
	}

	public void setDataFineBlackOut(LocalDateTime dataFineBlackOut) {
		this.dataFineBlackOut = dataFineBlackOut;
	}

	public int getNercId() {
		return nercId;
	}

	public void setNercId(int nercId) {
		this.nercId = nercId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getCustomerAffected() {
		return customerAffected;
	}

	public void setCustomerAffected(int customerAffected) {
		this.customerAffected = customerAffected;
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	
	public Long ritornaDurata() {
		return this.oreGuasto;
	}
	
	public int getAnno() {
		return this.anno;
	}

	public BlackOut(LocalDateTime dataInizioBlackOut, LocalDateTime dataFineBlackOut, int nercId, int areaId,
			int customerAffected, int eventTypeId) {
		this.dataInizioBlackOut = dataInizioBlackOut;
		this.dataFineBlackOut = dataFineBlackOut;
		this.nercId = nercId;
		this.areaId = areaId;
		this.customerAffected = customerAffected;
		this.eventTypeId = eventTypeId;
		this.anno = dataInizioBlackOut.getYear();
		Duration dtemp = Duration.between(dataFineBlackOut, dataInizioBlackOut);
		this.oreGuasto = dtemp.toHours();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaId;
		result = prime * result + ((dataFineBlackOut == null) ? 0 : dataFineBlackOut.hashCode());
		result = prime * result + ((dataInizioBlackOut == null) ? 0 : dataInizioBlackOut.hashCode());
		result = prime * result + eventTypeId;
		result = prime * result + nercId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackOut other = (BlackOut) obj;
		if (areaId != other.areaId)
			return false;
		if (dataFineBlackOut == null) {
			if (other.dataFineBlackOut != null)
				return false;
		} else if (!dataFineBlackOut.equals(other.dataFineBlackOut))
			return false;
		if (dataInizioBlackOut == null) {
			if (other.dataInizioBlackOut != null)
				return false;
		} else if (!dataInizioBlackOut.equals(other.dataInizioBlackOut))
			return false;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (nercId != other.nercId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nercId + " - " + dataInizioBlackOut + " - " + dataFineBlackOut;
	}
	

}
