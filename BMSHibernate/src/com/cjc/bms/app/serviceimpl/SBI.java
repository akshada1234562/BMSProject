package com.cjc.bms.app.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import com.cjc.bms.app.config.HibernateUtil;
import com.cjc.bms.app.model.Account;
import com.cjc.bms.app.servicei.RBI;

public class SBI implements RBI 
{
	Account ac=new Account();
	Scanner sc=new Scanner(System.in);

	@Override
	public void createAccount() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		
		 System.out.println("Enter account no:");
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
		    
		    System.out.println("data added succeessfully");
		    session.save(ac);
		    session.beginTransaction().commit();
		}
		    
	

	@Override
	public void viewAccountDetails() {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
//		String hql="from account";
//		Query<Account> query=session.createQuery(hql,Account.class);
//		
//		java.util.List<Account> list=query.getResultList();
//		list.forEach((ac)->{
//			System.out.println(ac);
//		});
		System.out.println("Account no:"+ac.getAccNo());
		System.out.println("Name:"+ac.getName());
		System.out.println("Mob no:"+ac.getMobNo());
		System.out.println("adhar no:"+ac.getMobNo());
		System.out.println("gender:"+ac.getGender());
		System.out.println("age:"+ac.getAge());
		System.out.println("balance:"+ac.getBalance());
		System.out.println("display all details successfully");
		session.close();
		
		
	}

	@Override
	public void depositAmount() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter account no:");
		ac.setAccNo(sc.nextInt());
		System.out.println("Enter amount to deposit:");
		double amount=sc.nextDouble();
		double currentBalance=ac.getBalance();
		if(amount>0)
		{
			double totalBalance=currentBalance+amount;
			ac.setBalance(totalBalance);
			System.out.println("deposit money successfully");
		}
		else
		{
			System.out.println("deposit money successfully");
		}
		session.update(ac);
		session.beginTransaction().commit();
		session.close();
			
	
		
	}

	@Override
	public void widrowAmount() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter account no:");
		ac.setAccNo(sc.nextInt());
		System.out.println("Enter amount to withdraw:");
		double amount=sc.nextDouble();
		
		if(ac.getBalance()>=amount) {
			ac.setBalance(ac.getBalance()-amount);
			
			System.out.println("withdrawal money successful");
			System.out.println("Total balance:"+ac.getBalance());
		
		}
		else
		{
			System.out.println("Insufficient balance");
		}
		session.update(ac);
		session.beginTransaction().commit();
		session.close();

		
	}

	@Override
	public void viewBalance() {
		Session session =HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter account no:");
		ac.setAccNo(sc.nextInt());
		System.out.println("TotalBalance:"+ac.getBalance());
		session.beginTransaction().commit();
		session.close();
		
	}

}
