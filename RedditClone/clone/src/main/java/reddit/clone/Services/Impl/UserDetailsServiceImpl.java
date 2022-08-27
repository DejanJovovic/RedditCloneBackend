package reddit.clone.Services.Impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import reddit.clone.Services.UserService;
import reddit.clone.model.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("There is no user with this username" + username);

        }else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername().trim(),
                    user.getPassword().trim(),
                    grantedAuthorities);
            }
        }
    }
