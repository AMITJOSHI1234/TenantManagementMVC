package com.yash.tenantmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.tenantmanagement.domain.Property;
import com.yash.tenantmanagement.dto.PropertyDto;

/**
* This is a PropertyDao Implementation
* @author amit joshi
*/

@Repository
public class PropertyDaoImpl implements PropertyDaoInt {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	* Adding property in database
	*/
	@Override
	public void addProperty(Property property) {
		Session session = sessionFactory.getCurrentSession();
		session.save(property);
	}

	/**
	* Updating property in database
	*/
	@Override
	public void updateProperty(Property property) {
		Session session = sessionFactory.getCurrentSession();
		session.update(property);
	}

	/**
	* deleteing property from database
	*/
	@Override
	public void deleteProperty(Long propertyId) {
		Session session = sessionFactory.getCurrentSession();
		Property property = session.get(Property.class, propertyId);
		if(property!=null) {
			session.delete(property);
		}
	}

	/**
	* Getting property from database
	*/
	@Override
	public Property getPropertyById(Long propertyId) {
	Session session = sessionFactory.getCurrentSession();
	Property property = session.get(Property.class, propertyId);
	return property;
	}

	/**
	* Getting all properties
	*/
	@Override
	public List<Property> getAllProperties() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From Property",Property.class).getResultList();
	}

	@Override
	public List<Property> searchProperties(PropertyDto propertyDto) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Property.class);
		
		if(propertyDto.getAddress()!=null && !propertyDto.getAddress().isEmpty()) {
			criteria.add(Restrictions.like("address", propertyDto.getAddress()+"%"));
		}
		
		System.out.println(propertyDto.getPrice());
		if(propertyDto.getPrice()!=null) {
			criteria.add(Restrictions.eq("price", propertyDto.getPrice()));
		}
		
		if(propertyDto.getDescription()!=null) {
			criteria.add(Restrictions.like("description",propertyDto.getDescription()+"%"));
		}
		
		return criteria.list();
	}

	@Override
	public Property getPropertyImage(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Property.class, id);
	}

}
