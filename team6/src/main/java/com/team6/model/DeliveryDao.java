package com.team6.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DeliveryDao {

	@Autowired
	private SessionFactory factory;
	
	//新增
	public Delivery insert(Delivery delivery) {
		Session session = factory.openSession();   
		if(delivery != null) {
			session.persist(delivery);
			//不管都加flush()
			session.flush();
		}
		session.close();
		return delivery;
	}
	//查詢單筆
	public Delivery findById(Integer id) {
		Session session = factory.openSession();
		Delivery result = session.get(Delivery.class, id);
		session.close();
		return result;
	}
	
	//查詢全部
	public List<Delivery> FindAll(){
		Session session = factory.openSession();
		String hql = "FROM Delivery";
		Query<Delivery> query = session.createQuery(hql,Delivery.class);
		List<Delivery> list = query.list();
		session.close();
		return list;
	}
	//刪除
	public boolean deleteById(Integer id) {
	 	Session session = factory.openSession(); 
		Delivery result = session.get(Delivery.class, id);
		
		if(result != null) {
			session.remove(result);
			session.flush();
			session.close();
			return true;
		}
			session.close();
			return false;
	}

	
	
	//修改
	public Delivery update(Delivery delivery) {
	    Session session = factory.openSession();
	    if(delivery != null) {
	    	session.merge(delivery);
	    	session.flush();
	    }
	        session.close();
	        return delivery;
		}  
}

