package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.FlairService;
import reddit.clone.model.dto.FlairDTO;
import reddit.clone.model.dto.UserDTO;

@RestController
@RequestMapping("api/flairs")
public class FlairController {

    @Autowired
    private FlairService flairService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@RequestBody FlairDTO dto) {
        return new ResponseEntity<>(flairService.add(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(flairService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(flairService.getOne(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>(flairService.update(id), HttpStatus.OK);
    }
}
