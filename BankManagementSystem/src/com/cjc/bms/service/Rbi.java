package com.cjc.bms.service;

import java.sql.SQLException;

public interface Rbi {
	public  void createAccount() throws SQLException, Exception; 
	public void displayAllDetails() throws Exception;
	public void depositmoney() throws Exception;
	public void withdrawal() throws Exception;
	public void balanceCheck() throws Exception;
	
   } 
