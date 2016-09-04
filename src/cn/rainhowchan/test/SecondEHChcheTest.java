package cn.rainhowchan.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.rainhowchan.onetomany.User;
import cn.rainhowchan.utils.HibernateUtils;

public class SecondEHChcheTest {
	
	@Test
	public void testCache(){
		
		Session session1 = HibernateUtils.getSession();
		Transaction tx1 = session1.beginTransaction();
	
		User user1=(User) session1.get(User.class, 1);
		User user2=(User) session1.get(User.class, 1);
		System.out.println(user1==user2);
		tx1.commit();
		session1.close();
		
		Session session2 = HibernateUtils.getSession();
		Transaction tx2 = session2.beginTransaction();
	
		User user3=(User) session2.get(User.class, 1);
		System.out.println(user1==user3);
		User user4=(User) session2.get(User.class, 1);
		System.out.println(user3==user4);
		tx2.commit();
		session2.close();
		
		
		
		
		
	}
}
