package com.cjc.bms.app.client;

import java.util.Scanner;

import com.cjc.bms.app.config.HibernateUtil;
import com.cjc.bms.app.servicei.RBI;
import com.cjc.bms.app.serviceimpl.SBI;
import com.mysql.cj.Session;

public class Test 
{
	public static void main(String[] args)
	{
		RBI bank=new SBI();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\n..Enter your CHOISE...\n");
			System.out.println("welcome to our bank");
			System.out.println("1.Create your Account");
			System.out.println("2.Display all details");
			System.out.println("3.Fix your Deposit");
			System.out.println("4.Enter amount for Withdrawal");
			System.out.println("5.Check your Balance");
			
			int choise=sc.nextInt();
			switch (choise) 
			{
			case 1: 
				bank.createAccount();
				break;
				
			case 2:
				bank.viewAccountDetails();
			    break;
				
			case 3:
				bank.depositAmount();
				break;
				
			case 4:
				bank.widrowAmount();
				break;
				
			case 5:
				bank.viewBalance();
				break;
				
				default:
					System.out.println("invalid choise");
					
				
			}
		}
	}

}
