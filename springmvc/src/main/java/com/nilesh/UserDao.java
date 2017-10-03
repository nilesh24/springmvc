package com.nilesh;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
@Transactional(propagation=Propagation.REQUIRED)
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory = null;
	HibernateTemplate hb = null;
	
	@PostConstruct
	public void init(){
		hb= new HibernateTemplate(sessionFactory);
	}
	
	
	public void addUser(User user, Address addr){
		
		//hb.save(add);
		hb.save(user);
	}
	

}
