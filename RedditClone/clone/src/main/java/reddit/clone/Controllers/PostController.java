package reddit.clone.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.PostService;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.PostDTO;


@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody PostDTO dto) {
        return new ResponseEntity<>(postService.add(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getOne(id), HttpStatus.OK); }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PostDTO dto) {
        return new ResponseEntity<>(postService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(postService.delete(id), HttpStatus.OK);

    }
}
