package com.travelnow.db;

import java.sql.*;

@SuppressWarnings("unused")
public class DBConnection 
{
	static Connection connSrc = null;
	static Connection connDest = null;
	
	/*
	 *  Used to Get MS Access Connection
	 *  Returns Connection Object
	 */
	
	public static Connection getAccessConnection(String string) throws Exception
	{
		Connection con = null;
		try {
			System.out.println("MDB: "+string);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= " + string);
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/*
	 *  Used to Get MySQL Connection
	 *  Returns Connection Object
	 */
	
	public static Connection getMySqlConnection(String strHostName, String strDBName, String strPort, String strUserName, String strPassword) throws Exception
	{
		Connection con = null;
		String strURL = "";
		
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:4928/mobiledoc", "ecwDbUser","Pwd4db@114");
			strURL = "jdbc:mysql://" + strHostName + ":" + strPort + "/" + strDBName;
			con = DriverManager.getConnection(strURL, strUserName,strPassword);
			
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 *  Used to Get MySQL Connection
	 *  Returns Connection Object
	 */
	
	public static Connection getMSSQLConnection(String strHostName, String strDBName, String strPort, String strUserName, String strPassword) throws Exception
	{
		Connection con = null;
		String strURL = "";
		
		if(strPort.equals(""))
		{
			strPort = "1433";
		}
		
		try {
//			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://local/MANEWH", "sa","mobiledoc$1");
//			 strURL ="jdbc:sqlserver://"+strHostName+":"+strPort+";databaseName=" + strDBName ;
			 
			 
			 Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 strURL ="jdbc:sqlserver://"+strHostName+":"+strPort+";databaseName=" + strDBName ;
			// strURL ="jdbc:sqlserver://"+strHostName+";databaseName=" + strDBName ;
			 
				
			 con = DriverManager.getConnection(strURL, strUserName,strPassword);
				
			
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/*
	 *  Used to Get DSN Connection
	 *  Returns Connection Object
	 */
	
	public static Connection getDSNConnection(String strDSNName, String strUserName, String strPassword) throws Exception
	{
		Connection con = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:" + strDSNName , strUserName,strPassword);
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
