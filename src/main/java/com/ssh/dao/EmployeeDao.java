package com.ssh.dao;

import com.ssh.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public List<EmployeeEntity> getAll(){
        String hql="FROM EmployeeEntity";
        return getSession().createQuery(hql).list();
    }

    public void delete(Integer id){
        String hql = "delete from EmployeeEntity e where e.id= :id";
        getSession().createQuery(hql).setParameter("id",id).executeUpdate();
    }
}
