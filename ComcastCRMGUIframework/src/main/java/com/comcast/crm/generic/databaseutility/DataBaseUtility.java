package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;



public class DataBaseUtility {
	Connection con ;
	public void getDbconnection() throws Throwable {
		try {
	    Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);	  
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root"   ,"root");
		}catch (Exception e) {	 
		}
	}
		 public void closeDbconnection() {
		try {
			con.close();
		}catch (Exception e) {
		}
		 } 
	
	public ResultSet executeConSelectQuery(String query) throws Throwable {
		ResultSet res = null;
		try{
			Statement stat = con.createStatement();
		 res = stat.executeQuery(query);
		}catch (Exception e) {}
			return res;
	}
		public int executeNonselectQuery(String query) {
			int res1=0;
			try{Statement stat = con.createStatement();
			 res1 = stat.executeUpdate(query);
			}catch (Exception e) {
					}
			return res1;
		}
	}


