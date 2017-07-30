/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application;

import java.util.Date;
import org.hibernate.Session;
import com.models.util.HibernateUtil;
import com.models.DBUser;

/**
 *
 * @author fredwinrosales
 */
public class Main {
    
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(1);
		user.setUsername("batman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
	}
    
}
