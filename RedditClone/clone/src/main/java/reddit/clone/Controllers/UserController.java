package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.Impl.CustomUserDetailsService;
import reddit.clone.Services.UserService;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.LoginDTO;
import reddit.clone.model.dto.LoginResponseDTO;
import reddit.clone.model.dto.UserDTO;
import reddit.clone.security.TokenUtil;

@RestController
@RequestMapping("api/users")
public class UserController {


        @Autowired
        private TokenUtil tokenUtils;
        @Autowired
        private UserService userService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private CustomUserDetailsService customUserService;


        @PostMapping (path = "/login")
        public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
            User user = customUserService.findUserByUsername(loginDTO.getUsername());

            if(user == null || !passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())) {
                return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
            }

            String token = tokenUtils.generateToken(user.getEmail(), user.getRole().toString());
            LoginResponseDTO responseDTO = new LoginResponseDTO();
            responseDTO.setToken(token);
            return ResponseEntity.ok(responseDTO);

        }

        @PostMapping (path = "/register")
        public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
            User user = userService.register(userDTO);

            if(user == null) {
                return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(user, HttpStatus.OK);
        }



        @PostMapping(path = "/add")
        public ResponseEntity<?> add(@RequestBody UserDTO dto) {
            return new ResponseEntity<>(userService.add(dto), HttpStatus.OK);
        }

        @GetMapping(path = "/get-all")
        public ResponseEntity<?> getAll() {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        }

        @GetMapping(path = "/get-one/{id}")
        public ResponseEntity<?> getOne(@PathVariable Long id) {
            return new ResponseEntity<>(userService.getOne(id), HttpStatus.OK);
        }


        @PutMapping(path = "/{id}")
        public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO dto) {
            return new ResponseEntity<>(userService.update(id, dto), HttpStatus.OK);
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
            return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);

        }

    }
