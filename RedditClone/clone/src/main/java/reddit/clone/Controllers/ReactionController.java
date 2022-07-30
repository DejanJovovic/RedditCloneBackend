package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.ReactionService;
import reddit.clone.model.dto.PostDTO;
import reddit.clone.model.dto.ReactionDTO;
import reddit.clone.model.dto.ReportDTO;

@RestController
@RequestMapping("api/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody ReactionDTO dto) {
        return new ResponseEntity<>(reactionService.add(dto), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>(reactionService.update(id), HttpStatus.OK);

    }


    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(reactionService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(reactionService.getOne(id), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(reactionService.delete(id), HttpStatus.OK);

    }
}
