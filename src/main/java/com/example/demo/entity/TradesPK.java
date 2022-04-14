package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class TradesPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String Trade_Id;

	Integer Version;
}
