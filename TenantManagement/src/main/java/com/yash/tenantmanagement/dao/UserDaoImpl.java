package com.yash.tenantmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.LoginDto;

/**
* This is a UserDao Implementation containing methods like saveUser and getUserById
* @author amit joshi
*/

@Repository
public class UserDaoImpl implements UserDaoInt {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		return (User)session.createQuery("FROM User where email = :email")
				.setParameter("email",email)
				.uniqueResult();
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public void deleteUser(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		if(user!=null) {
			session.delete(user);
		}	
	}

	@Override
	public User getUserById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public List<User> getAllUsers(int page,int size,String sort) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.asc(sort));
		criteria.setFirstResult(page*size);
		criteria.setMaxResults(size);
		
		return criteria.list();
	}

	@Override
	public List<User> searchUser(String username, String address) {
	      Session session = sessionFactory.getCurrentSession();
	      Criteria criteria = session.createCriteria(User.class);
	      criteria.add(Restrictions.like("username", "%"+username+"%"));
	      criteria.add(Restrictions.like("address","%"+address+"%"));
	      return criteria.list();
	}

}
