package com.cjc.bms.client;

import java.util.Scanner;

import com.cjc.bms.service.Rbi;
import com.cjc.bms.serviceImpl.Sbi;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner Sc=new Scanner(System.in);
		
		Rbi bank=new Sbi();
		while(true) {
		System.out.println("welcome to our bank");
		System.out.println("please check your option");
		System.out.println("1.Create your Account");
		System.out.println("2.Display all Details");
		System.out.println("3.fix your deposit");
		System.out.println("4.enter amount for withdrawal");
		System.out.println("5.check your balance");
		
		System.out.println("Enter your choise:");
		
		int choise=Sc.nextInt();
		if(choise==1)
		{
			bank.createAccount();
		}
		else if(choise==2)
		{
			bank.displayAllDetails();
		}
		else if(choise==3)
		{
			bank.depositmoney();
		}
		else if(choise==4)
		{
			bank.withdrawal();
		}
		else if(choise==5)
		{
			bank.balanceCheck();
		}
		else
		{
			System.out.println("Invalid choice");
		}
		
		
	}
	}
}

	 
	
	   
