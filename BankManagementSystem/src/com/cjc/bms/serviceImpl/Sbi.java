package com.cjc.bms.serviceImpl;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import com.cjc.bms.app.model.Account;
import com.cjc.bms.service.Rbi;

public class Sbi implements Rbi {
	       Account ac= new Account();
	       
           Scanner sc=new Scanner(System.in);
      
	@Override
	public void createAccount() throws SQLException,Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanage", "root", "root");
		    
	    System.out.println("Enter account No:");
	    ac.setAccNo(sc.nextInt());
	    
	    System.out.println("Enter AccHolder name:");
	    ac.setName(sc.next());
	    
	    System.out.println("Enter valid mobile No:");
	    ac.setMobNo(sc.nextLong());
	    
	    System.out.println("Enter aadhar No:");
	    ac.setAdharNo(sc.nextLong());
	    
	    System.out.println("Enter your gender:");
	    ac.setGender(sc.next());
	    
	    System.out.println("Enter your age:");
	    ac.setAge(sc.nextByte());
	    
	    System.out.println("Enter balance");
	    ac.setBalance(sc.nextDouble());
	
		String sql="insert into project1 values("+ac.getAccNo()+",'"+ac.getName()+"',"+ac.getMobNo()+","+ac.getAdharNo()+",'"
				+ac.getGender()+"',"+ac.getAge()+","+ac.getBalance()+","+ac.getAmount()+")";
	   

	   java.sql.Statement smt=con.createStatement();
	   smt.execute(sql);
	   System.out.println("data added successfully");
	}
	    	
               	
	@Override
	public void displayAllDetails() throws Exception,SQLException {
		System.out.println("Account no"+ac.getAccNo());
		System.out.println("Name"+ac.getName());
		System.out.println("Mob no"+ac.getMobNo());
		System.out.println("adhar no"+ac.getAdharNo());
		System.out.println("gender"+ac.getGender());
		System.out.println("age"+ac.getAge());
		System.out.println("balance"+ac.getBalance());
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanage", "root", "root");
		String sql="select * from project1";
		java.sql.Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getLong(3));
			System.out.println(rs.getLong(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getByte(6));
			System.out.println(rs.getDouble(7));
			System.out.println("data added successfully");
		}
		System.out.println("display all details successfully!");
	}
	
	

	@Override
	public void depositmoney() throws Exception,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanage", "root", "root");
		displayAllDetails();
		System.out.println("Enter Account number");
		ac.setAccNo(sc.nextInt());
	    String sql1="select Balance from project1 where AccNo="+ac.getAccNo();
	    java.sql.Statement smt1=con.createStatement();
	    ResultSet rs=smt1.executeQuery(sql1);
	    while(rs.next())
	    {
	    	double currentbalance=rs.getDouble("balance");
	    	System.out.println("Enter deposit money amount");
	    	double amount=sc.nextDouble();
	    	
	    	double totalbalance = currentbalance+amount;
	    	System.out.println("deposit money:"+totalbalance);
	    	String sql="update project1 set Balance="+totalbalance+"where AccNo="+ac.getAccNo();
	    	java.sql.Statement smt=con.createStatement();
	    	smt.execute(sql);
	    	System.out.println("deposit money succeefully");
	    }
	}

	
	
	@Override
	public void withdrawal() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanage", "root", "root");
		//displayAllDetails();
		System.out.println("enter account no");
		ac.setAccNo(sc.nextInt());
		String sql="select balance from project1 where AccNo="+ac.getAccNo();
	    java.sql.Statement smt=con.createStatement();
	    ResultSet rs=smt.executeQuery(sql);	
	    if(rs.next())
	    {
	    System.out.println("TotalBalance:"+rs.getInt(1));
		System.out.println("Enter amount to withdrawal");
		double wamount=sc.nextDouble();
		
		String sql1="update project1 set balance=+balance-"+wamount+"where AccNo="+ac.getAccNo();
			java.sql.Statement smt1=con.createStatement();
			smt1.execute(sql1);
		}
	         System.out.println("money withdrawal successfully");
	}
		
		
	

	@Override
	public void balanceCheck() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanage", "root", "root");
		//displayAllDetails();
		System.out.println("enter account no");
		ac.setAccNo(sc.nextInt());
		String sql="select balance from project1 where AccNo="+ac.getAccNo();
	    java.sql.Statement smt=con.createStatement();
	    ResultSet rs=smt.executeQuery(sql);	
	    
	    while(rs.next())
	    {
	    	System.out.println("TotalBalance:"+rs.getInt(1));
	    }
	    System.out.println("balance check successfully");
}
	}

		
		




		
	

