package reddit.clone.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;
import reddit.clone.Services.Impl.CustomUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtil tokenUtils;

    private CustomUserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtil tokenHelper, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = (CustomUserDetailsService) userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String email;
        String authToken = tokenUtils.getToken(request);

        if (authToken != null) {
            email = tokenUtils.getEmailFromToken(authToken);


            if (email != null) {
                UserDetails userDetails = (UserDetails) userDetailsService.loadUserByUsername(email); //Override-ovano u ISerService koji extenduje UserDetailsService


                if (tokenUtils.validateToken(authToken, userDetails)) {
                    Collection<? extends GrantedAuthority> authorities = userDetailsService.getAuthoritiesFromUserDetails(userDetails);
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails, authorities);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
