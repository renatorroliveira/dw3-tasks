package br.edu.ifc.concordia.inf;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.boilerplate.HibernateDAO;

@Controller
public class IndexController {

	private final Result result;
	private final HibernateDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(Result result, HibernateDAO dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/")
	public void home() {
		
		result.include("variable", "VRaptor!");
	}
}