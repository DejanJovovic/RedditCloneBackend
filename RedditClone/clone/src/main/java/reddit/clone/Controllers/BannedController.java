package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.model.dto.BannedDTO;


@RestController
@RequestMapping("api/banned")
public class BannedController {

    @Autowired
    private BannedController bannedController;

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>(bannedController.update(id), HttpStatus.OK);
    }
}
