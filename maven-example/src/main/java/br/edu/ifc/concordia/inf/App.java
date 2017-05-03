package br.edu.ifc.concordia.inf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.edu.ifc.concordia.inf.models.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		StandardServiceRegistry serviceRegistry =
				new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		Metadata metadata = new MetadataSources( serviceRegistry )
				.addAnnotatedClass(User.class)
				.buildMetadata();
		SessionFactory factory = metadata.buildSessionFactory();
		Session session = factory.openSession();
		
		User user = new User();
		user.setName("Renato");
		user.setEmail("renato@exemplo.com");
		user.setPassword("12345");
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.persist(user);
			transaction.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		
		System.out.printf("ID Atribuido: %d\n", user.getId());
		session.close();
		factory.close();
	}
}
