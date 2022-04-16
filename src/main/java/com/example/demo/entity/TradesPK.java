package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class TradesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String Trade_Id;

	Integer Version;

	public TradesPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradesPK(String trade_Id, Integer version) {
		super();
		Trade_Id = trade_Id;
		Version = version;
	}

	public String getTrade_Id() {
		return Trade_Id;
	}

	public void setTrade_Id(String trade_Id) {
		Trade_Id = trade_Id;
	}

	public Integer getVersion() {
		return Version;
	}

	public void setVersion(Integer version) {
		Version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Trade_Id == null) ? 0 : Trade_Id.hashCode());
		result = prime * result + ((Version == null) ? 0 : Version.hashCode());
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
		TradesPK other = (TradesPK) obj;
		if (Trade_Id == null) {
			if (other.Trade_Id != null)
				return false;
		} else if (!Trade_Id.equals(other.Trade_Id))
			return false;
		if (Version == null) {
			if (other.Version != null)
				return false;
		} else if (!Version.equals(other.Version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradesPK [Trade_Id=" + Trade_Id + ", Version=" + Version + "]";
	}

}
