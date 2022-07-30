package reddit.clone.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reddit.clone.Services.RuleService;
import reddit.clone.model.dto.RuleDTO;


public class RuleController {

    private RuleService ruleService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody RuleDTO dto) {
        return new ResponseEntity<>(ruleService.add(dto), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(ruleService.delete(id), HttpStatus.OK);

    }
}
