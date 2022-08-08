package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.CommentService;
import reddit.clone.Services.PostService;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.CommentDTO;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.add(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getOne(id), HttpStatus.OK); }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);

    }
}

