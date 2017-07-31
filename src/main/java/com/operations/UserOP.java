/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.operations;

import com.models.DBUser;
import com.models.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fredwinrosales
 */
public class UserOP {
    
    private final Session session;
    private Query query;
    private Criteria criteria;
    
    public UserOP(){
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(DBUser.class);
    }
    
    public UserOP(
        int rownum,
        String username
    ){
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createSQLQuery(
                      "SELECT * FROM DBUSER "
                    + "WHERE rownum < :rownum "
                    + "AND username = :username"
        ).addEntity(
                DBUser.class
        ).setParameter(
                "rownum", rownum
        ).setParameter(
                "username", username
        );
    }

    
    public List<DBUser> doGetCriteria(){
        List<DBUser> list = 
                (List<DBUser>) criteria.list();
        return list;
    }
    
    public int countCriteria(){
        List<DBUser> list = 
                (List<DBUser>) criteria.list();
        return list.size();
    }
    
    public List<DBUser> doGet(){
        List result = query.list();
        List<DBUser> detalles = result;
        return detalles;
    }
    
    public int count(){
        List result = query.list();
        return result.size();
    }
    
    public void closeConection(){
        HibernateUtil.getSessionFactory().close();
    }
}
