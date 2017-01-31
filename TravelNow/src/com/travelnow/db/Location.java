package com.travelnow.db;

import java.sql.*;
import java.util.*;

public class Location {
	
	public static HashMap<Integer, String> countryHMap = new HashMap<Integer, String>();
	public static HashMap<Integer, String> stateHMap = new HashMap<Integer, String>();
	public static HashMap<Integer, String> cityHMap = new HashMap<Integer, String>();
	
	private static Connection getConnection() throws Exception{
		Connection connDes2 = DBConnection.getDSNConnection("Indexing","sa","Pwd4db@114");
		return connDes2;
	}
	
	public static HashMap<Integer, String> getCountries() {
		ResultSet crs = null;
		Statement cstmt = null;
		try {
			cstmt  = getConnection().createStatement();
			crs=cstmt.executeQuery("SELECT ID, COUNTRY_NAME FROM COUNTRY ORDER BY COUNTRY_NAME");
			while(crs.next()){
				Location.countryHMap.put(crs.getInt("ID"), crs.getString("COUNTRY_NAME"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return countryHMap;		
	}

	public static HashMap<Integer, String> getStates(int CountryId) {
		ResultSet crs = null;
		Statement cstmt = null;
		try {
			cstmt  = getConnection().createStatement();
			crs=cstmt.executeQuery("SELECT ID, STATE_NAME FROM STATE WHERE COUNTRY_ID="+CountryId+" ORDER BY STATE_NAME");
			while(crs.next()){
				Location.stateHMap.put(crs.getInt("ID"), crs.getString("STATE_NAME"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stateHMap;		
	}
	
	
	
	public static HashMap<Integer, String> getCities(int StateId) {
		ResultSet crs = null;
		Statement cstmt = null;
		try {
			cstmt  = getConnection().createStatement();
			crs=cstmt.executeQuery("SELECT ID, CITY_NAME FROM CITY WHERE STATE_ID="+StateId+" ORDER BY CITY_NAME");
			while(crs.next()){
				Location.cityHMap.put(crs.getInt("ID"), crs.getString("CITY_NAME"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cityHMap;		
	}
	
	
	
	
	
	/*public static void main(String[] args) {
		int cid=0;
		Location.getCountries();
		Map.Entry me=null;
		Set iterator = Location.countryHMap.entrySet();
		Iterator i = iterator.iterator();
		while(i.hasNext()){
			me = (Map.Entry)i.next();
			
			System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
			
						
		}
		
		Location.getStates(101);
		
		iterator = Location.stateHMap.entrySet();
		i = iterator.iterator();
		while(i.hasNext()){
			me = (Map.Entry)i.next();
			
			System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
			
						
		}
		
		
		
		Location.getCities(17);
		iterator = Location.cityHMap.entrySet();
		i = iterator.iterator();
		while(i.hasNext()){
			me = (Map.Entry)i.next();
			
			System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
			
						
		}

	}*/

}
