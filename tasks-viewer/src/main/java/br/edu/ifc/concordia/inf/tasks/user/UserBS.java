package br.edu.ifc.concordia.inf.tasks.user;

import java.util.UUID;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;

@RequestScoped
public class UserBS extends HibernateBusiness {

	public void register(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword(CryptManager.passwordHash(user.getPassword()));
		this.dao.persist(user);
	}
}
