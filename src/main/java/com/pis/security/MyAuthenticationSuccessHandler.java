package com.pis.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	protected MyAuthenticationSuccessHandler() {
		super();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse arg1, Authentication arg2) throws IOException,
			ServletException {
		handle(arg0, arg1, arg2);
		clearAuthenticationAttributes(arg0);
	}

	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			// logger.debug("Response has already been committed. Unable to redirect to "
			// + targetUrl);
			System.out.println("tu");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Builds the target URL according to the logic defined in the main class
	 * Javadoc.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		boolean isMajster = false;
		boolean isStrojnik = false;
		boolean isVelinar = false;
		boolean isVeduciVapenky = false;
		boolean isAdmin = false;
		Collection<? extends GrantedAuthority> authorities = authentication
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_MAJSTER")) {
				isMajster = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_STROJNIK")) {
				isStrojnik = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_VELINAR")) {
				isVelinar = true;
				break;
			} else if (grantedAuthority.getAuthority().equals(
					"ROLE_VEDUCIVAPENKY")) {
				isVeduciVapenky = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isMajster) {
			return "/add-maerz-form-majster";
		} else if (isStrojnik) {
			return "/add-maerz-form-strojnik";
		} else if (isVelinar) {
			return "/add-maerz-form-velinar";
		} else if (isVeduciVapenky) {
			return "/add-maerz-form-veduci";
		} else if (isAdmin) {
			return "/login";
		} else {
			throw new IllegalStateException();
		}
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
