package co.henry.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
@Component("CustomLogin")
@Log
public class CustomLoginSuccessHandler 
implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
			log.info("===============");
			log.info("login handler");
			List<String> roleNames= new ArrayList<String>();
			authentication.getAuthorities().forEach(auth->
												{roleNames.add(auth.getAuthority());
												});
			String path =request.getContextPath();
			if(roleNames.contains("ROLE_ADMIN")) {
				response.sendRedirect(path+"admin/admin.jsp");
				
			}else if(roleNames.contains("ROLE_USER")) {
				response.sendRedirect(path+"user/user.jsp");
			}else {
				response.sendRedirect("top.jsp");
			}
	}

}
