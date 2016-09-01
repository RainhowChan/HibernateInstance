package cn.rainhowchan.test;

import org.hibernate.Session;
import org.junit.Test;

import cn.rainhowchan.domain.Book;
import cn.rainhowchan.utils.HibernateUtils;

public class BookTest {
	@Test
	public void test1(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Book book=new Book();
		book.setName("thinking in java");
		book.setPrice(123d);
		
		session.save(book);
		session.getTransaction().commit();
		session.close();
		System.out.println(book);
		
	}
	
	@Test
	public void test2(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Book b1=(Book) session.get(Book.class, 1);
		System.out.println(b1);
		
		Book b2=(Book) session.get(Book.class, 1);
		System.out.println(b2);
	
		session.getTransaction().commit();
		session.close();
	}
		
	@Test
	public void test3(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Book book=new Book();
		book.setName("精通Hibernate");
		book.setPrice(65d);
		session.save(book);
		book.setName("精通Struts");
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test4(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Book book = (Book) session.get(Book.class, 1);
		book.setName("Java Web");
//		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void test5(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Book book=new Book();
		book.setName("精通JQuery");
		book.setPrice(65d);
		session.save(book);
		book.setName("精通Struts");
//		session.evict(book);
//		session.clear();
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void test6(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Book book = (Book) session.get(Book.class, 2);
		book.setName("JavaScript");
		session.refresh(book);
		session.getTransaction().commit();
		session.close();
	}
}
