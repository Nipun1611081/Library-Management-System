package com.seclore.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	public static Connection getDBConnection() throws SQLException, FileNotFoundException{
		File file= new File (".\\src\\database.properties"); //for relative path
		FileReader fileReader= new FileReader(file);
		Properties properties= new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URL= properties.getProperty("URL");
		USERNAME= properties.getProperty("USERNAME");
		PASSWORD= properties.getProperty("PASSWORD");
		
		Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//System.out.println("Connection successful");
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
