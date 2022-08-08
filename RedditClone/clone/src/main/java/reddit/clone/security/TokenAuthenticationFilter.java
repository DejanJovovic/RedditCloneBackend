package reddit.clone.security;

import org.springframework.web.filter.OncePerRequestFilter;
import com.isa.config.CustomUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userDetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userDetails.UserDetails.Service;
import org.springframework.web.filter.OncePerRequestFilter;

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
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String email;
        String authToken = tokenUtils.getToken(request);

        if (authToken != null) {
            email = tokenUtils.getEmailFromToken(authToken)


            if (email != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email); //Override-ovano u ISerService koji extenduje UserDetailsService


                if (tokenUtils.validateToken(authToken, userDetails)) {
                    Collection<? extends GrantedAuthority> authorities = userDetailsService.getAuthoritesFromUserDetails(userDetails);
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails, authorities);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentications(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
