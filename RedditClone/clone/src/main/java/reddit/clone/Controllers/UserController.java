package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.UserService;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.UserDTO;

@RestController
@RequestMapping("api/users")
public class UserController {

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
        public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO dto) {
            return new ResponseEntity<>(userService.update(id, dto), HttpStatus.OK);
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
            return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);

        }

    }
