package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dataSets.UserDataSet;

public class UserDataSetDAO {
	private SessionFactory sessionFactory;
	
	public UserDataSetDAO(SessionFactory session){
		this.sessionFactory = session;
	}
	
	
	public void save(UserDataSet dataSet){
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.save(dataSet);
		trx.commit();
		session.close();
	}
	
	public UserDataSet read(long id){
		Session session = sessionFactory.openSession();
		return (UserDataSet)session.load(UserDataSet.class, id);
	}
}
