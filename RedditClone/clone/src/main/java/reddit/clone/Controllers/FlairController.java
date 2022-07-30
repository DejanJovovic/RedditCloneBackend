package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.model.dto.FlairDTO;

@RestController
@RequestMapping("api/flairs")
public class FlairController {

    @Autowired
    private FlairController flairController;

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>(flairController.update(id), HttpStatus.OK);
    }
}
