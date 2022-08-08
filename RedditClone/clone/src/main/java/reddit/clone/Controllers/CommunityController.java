package reddit.clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.CommunityService;
import reddit.clone.model.domain.Community;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.CommunityDTO;

@RestController
@RequestMapping("api/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody CommunityDTO dto) {
        return new ResponseEntity<>(communityService.add(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(communityService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(communityService.getOne(id), HttpStatus.OK); }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CommunityDTO dto) {
        return new ResponseEntity<>(communityService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(communityService.delete(id), HttpStatus.OK);

    }

}
