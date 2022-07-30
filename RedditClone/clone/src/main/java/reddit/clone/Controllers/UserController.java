package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.model.dto.UserDTO;


public class UserController {

    @RestController
    @RequestMapping("api/users")
    public class UserService {

        @Autowired
        private UserService userService;

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
        public ResponseEntity<?> update(@PathVariable Long id) {
            return new ResponseEntity<>(userService.update(id), HttpStatus.OK);
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
            return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);

        }

    }
}
