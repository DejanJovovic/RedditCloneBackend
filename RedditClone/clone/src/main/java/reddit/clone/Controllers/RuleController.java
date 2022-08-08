package reddit.clone.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.RuleService;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.RuleDTO;

@RestController
@RequestMapping("api/rules")
public class RuleController {

    private RuleService ruleService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody RuleDTO dto) {
        return new ResponseEntity<>(ruleService.add(dto), HttpStatus.OK);
    }



    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(ruleService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(ruleService.getOne(id), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RuleDTO dto) {
        return new ResponseEntity<>(ruleService.update(id, dto), HttpStatus.OK);
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(ruleService.delete(id), HttpStatus.OK);

    }
}
