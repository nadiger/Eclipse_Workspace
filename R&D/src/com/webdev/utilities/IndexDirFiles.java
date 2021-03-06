package com.webdev.utilities;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.webdev.dao.DBConnection;

// Referenced classes of package Doc:
//            UserScreenDocIndex

public class IndexDirFiles
{

	public static int aa;
	public static int dd;
	static int spc_count = -1;
	public String filename="",path="",filetype="",fileType="";

	public void Process(File aFile, PrintWriter outb) throws IOException, SQLException
	{
		filename="";path="";filetype="";fileType="";
		String saa = "";
		/*for(int i = 0; i < spc_count; i++)
			spcs = (new StringBuilder(String.valueOf(spcs))).append(" ").toString();*/


		//System.out.println((new StringBuilder(String.valueOf(spcs))).append("[FILE] ").append(aFile.getName()).toString());
		if(aFile.isFile()){
			filename = aFile.getName();
		}
		//System.out.println(cc);
		if(aFile.isDirectory())
		{
			//System.out.println((new StringBuilder(String.valueOf(spcs))).append("[DIR] ").append(aFile.getAbsoluteFile()).toString());
			path = (new StringBuilder(String.valueOf(aFile.getAbsoluteFile().toString()))).append("\n").toString();
			filename = (new StringBuilder(String.valueOf(filename))).append("|").append(saa).toString();
			File listOfFiles[] = aFile.listFiles();
			aa = listOfFiles.length;
			if(listOfFiles != null)
			{
				for(int i = 0; i < listOfFiles.length; i++)
					Process(listOfFiles[i], outb);

				for(dd = 0; dd < listOfFiles.length; dd++);
			} /*else
			{
				System.out.println((new StringBuilder(String.valueOf(spcs))).append(" [ACCESS DENIED]").toString());
			}*/
		} else
		{
			path = aFile.getAbsolutePath().toString();
			path= path.replace(filename, "");
			path = path.substring(0, path.length() - 1);
			/*path = (new StringBuilder(String.valueOf(filename))).append(",").append(path).append("\n").toString();
			outb.append(path);*/
			fileType = filename.substring(filename.lastIndexOf(".")+1,filename.length());
			insert(path,filename,fileType);
		}
		//spc_count--;
	}
	
	public void insert(String path, String filename, String fileType) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlStatement = "";
		try {
			sqlStatement =  "Insert Into Index1(filename,path,filetype) "
					+ "values(?,?,?)";
			pstmt = getConnection().prepareStatement(sqlStatement);
			pstmt.setString(1, filename);
			pstmt.setString(2, path);
			pstmt.setString(3, fileType);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static Connection getConnection() throws Exception{
		Connection connDes2 = DBConnection.getDSNConnection("Indexing","sa","Pwd4db@114");
		return connDes2;
	}


}