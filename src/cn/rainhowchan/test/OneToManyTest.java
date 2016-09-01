package cn.rainhowchan.test;

import org.hibernate.Session;
import org.junit.Test;

import cn.rainhowchan.onetomany.User;
import cn.rainhowchan.onetomany.Order;
import cn.rainhowchan.utils.HibernateUtils;

public class OneToManyTest {
	
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		
		User customer = new User();
		customer.setName("张三");
		
		Order o1 = new Order();
		o1.setAddress("北京");
		o1.setPrice(1000d);
		Order o2 = new Order();
		o2.setAddress("宜昌");
		o2.setPrice(5000d);
		
		o1.setUser(customer);
		o2.setUser(customer);
		
//		customer.getOrders().add(o1);
//		customer.getOrders().add(o2);
		
		session.save(customer);
		session.save(o1);
		session.save(o2);
		session.getTransaction().commit();
		session.close();
		
	}
}
