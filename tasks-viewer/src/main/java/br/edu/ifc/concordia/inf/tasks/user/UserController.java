package br.edu.ifc.concordia.inf.tasks.user;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.AbstractController;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.view.Results;
import br.edu.ifc.concordia.inf.IndexController;

@Controller
public class UserController extends AbstractController {

	@Inject private UserBS bs;

	@Get("/register")
	@NoCache
	public void register() {
		
	}

	@Post("/register")
	@NoCache
	public void register(User user) {
		try {
			this.bs.register(user);
			this.result.redirectTo(IndexController.class).home();
		} catch (Exception ex) {
			LOGGER.error("Erro no cadastro", ex);
			this.result.use(Results.status()).badRequest(ex.getMessage());
		}
	}
}
