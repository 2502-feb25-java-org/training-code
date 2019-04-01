package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.TestMapping;
import com.revature.util.ConnectionUtil;

public class FoodDao {

	ConnectionUtil util = ConnectionUtil.getInstance();

	public TestMapping addFood(String food, String test) {
		TestMapping obj = new TestMapping();
		obj.setData(food);
		obj.setTest(test);

		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(obj);
			obj.setId(id);
			tx.commit();
		}
		finally {
			session.close();
		}
		
		return obj;
	}

}
