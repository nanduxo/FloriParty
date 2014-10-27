package Util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servlet" })
public class JpaFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		EntityManager entityManager = JpaUtil.createEntityManager();

		JpaUtil.setEntityManager(request, entityManager);

		try {
			entityManager.getTransaction().begin();

			filterChain.doFilter(request, response);

			entityManager.getTransaction().commit();
		} catch (Exception exception) {
			if (entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();

		} finally {
			entityManager.close();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		JpaUtil.iniciarPersistenceUnit();
	}

	@Override
	public void destroy() {
		JpaUtil.fecharPersistenceUnit();
	}

}
