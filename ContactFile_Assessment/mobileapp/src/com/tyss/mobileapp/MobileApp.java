package com.tyss.mobileapp;

import java.util.List;
import java.util.Scanner;

import com.tyss.mobileapp.dao.MobileDAO;
import com.tyss.mobileapp.dto.MobileBean;
import com.tyss.mobileapp.util.MobileContact;

public class MobileApp {
	public static void main(String[] args) {

		while (true) {
			System.out.println("Press 1 to Show all Contacts");
			System.out.println("Press 2 to search for contact by name");
			System.out.println("Press 3 to operate on contact");
			System.out.println("******************************************");

			Scanner scn = new Scanner(System.in);
			int ch = scn.nextInt();

			switch (ch) {
			case 1:
				MobileDAO dao1 = MobileContact.getMobileDAO();
				List<MobileBean> result = dao1.getAllContacts();
				for (MobileBean bean1 : result) {

					System.out.println("Name: " + bean1.getName());
					System.out.println("Number: " + bean1.getNumber());
					System.out.println("Group: " + bean1.getGroup());
					System.out.println("------------------------------------");
				}
				break;
			case 2:
				MobileDAO dao2 = MobileContact.getMobileDAO();
				System.out.println("Enter name");
				String name = scn.next();
				MobileBean bean = dao2.showOneDetail(name);
				if(bean!=null) {
					System.out.println("Name: "+bean.getName());
					System.out.println("Number: "+bean.getNumber());
					System.out.println("Group: "+bean.getGroup());
					System.out.println("------------------------------------");	
					System.out.println("press 1 to call");
					System.out.println("press 2 send msg");
					System.out.println("back to main menu");
					int number = scn.nextInt();
					switch(number) {
					case 1:System.out.println("calling");
					
						break;
					case 2: System.out.println("sending msg");
					break;
					case 3: break;
					}//switch 2
				}else {
					System.out.println("No Data Found for this name "+name);
				}
				break;
			case 3:System.out.println("press 1 to add ");
			System.out.println("2 to update");
			System.out.println("3 to delete");
			Scanner sc = new Scanner(System.in);
			int n=sc.nextInt();
			switch(n) {
			case 1:System.out.println("enter name");
				String name1=sc.next();
				System.out.println("enter number");
				int number = sc.nextInt();
				System.out.println("enter group");
				String group=sc.next();
				MobileBean bean3 = new MobileBean();
				bean3.setName(name1);
				bean3.setNumber(number);
				bean3.setGroup(group);
				MobileDAO dao3  = MobileContact.getMobileDAO();
				//int i= dao3.insertContact(dao3);
				System.out.println("enter name");
				System.out.println("rows updated");
				break;
			case 2: break;
			case 3 : break;
			
			}
		}
	}
}
}