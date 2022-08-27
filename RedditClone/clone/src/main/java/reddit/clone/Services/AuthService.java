package reddit.clone.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reddit.clone.Repository.UserRepository;
import reddit.clone.model.domain.Admin;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.RegisterRequest;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new Admin();

        LocalDate localDate = LocalDate.now();
        user.setRegistrationDate(localDate);
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);
    }

}
