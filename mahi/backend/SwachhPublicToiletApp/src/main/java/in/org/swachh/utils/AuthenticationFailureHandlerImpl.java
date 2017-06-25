package in.org.swachh.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest arg0,
                                        HttpServletResponse response, AuthenticationException authenticationException)
            throws IOException, ServletException {

        if (authenticationException instanceof BadCredentialsException)
            response.sendRedirect("Welcome?msg=invalidup");
        else if (authenticationException instanceof SessionAuthenticationException) {
            response.sendRedirect("Welcome?msg=ssession");
        }
    }


}
