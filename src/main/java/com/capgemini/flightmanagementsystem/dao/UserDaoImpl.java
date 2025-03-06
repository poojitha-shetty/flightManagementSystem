package com.capgemini.flightmanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagementsystem.bean.UserBean;
import com.capgemini.flightmanagementsystem.exception.LoginException;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory = null;
	
	
	@Override
	public boolean userRegister(UserBean userBean)
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
//			String type = "user";
//			userBean.setUserType(type);
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}	
		
//		
	@Override
	public UserBean login(int userId, String password) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from UserBean where user_id=:uid and user_password=:upwd";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("uid", userId);
			query.setParameter("upwd", password);
			UserBean user = (UserBean) query.getSingleResult();

			if (user == null) {
				System.out.println("Invalid credentials");
			} else {
				return user;
			}
		} catch (Exception e) {
			throw new LoginException();
		}
		entityManager.close();
		return null;
	}// end of login()



		
	}
	
	
	

