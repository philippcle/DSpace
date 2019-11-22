/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

/**
 * This class will filter shibboleth requests to try and authenticate them
 *
 * @author Giuseppe Digilio (giuseppe dot digilio at 4science dot it)
 */
public class ShibbolethAuthenticationFilter extends StatelessLoginFilter {

    public ShibbolethAuthenticationFilter(String url, AuthenticationManager authenticationManager,
            RestAuthenticationService restAuthenticationService) {
        super(url, authenticationManager, restAuthenticationService);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        super.successfulAuthentication(req, res, chain, auth);
        chain.doFilter(req, res);
    }

}