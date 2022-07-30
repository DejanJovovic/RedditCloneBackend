package reddit.clone.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reddit.clone.Services.ReportService;
import reddit.clone.model.domain.Report;
import reddit.clone.model.dto.ReactionDTO;
import reddit.clone.model.dto.ReportDTO;

@RestController
@RequestMapping("api/reports")
public class ReportController {

    private ReportService reportService;

    @PostMapping(path ="/add")
    public ResponseEntity<?> add(@RequestBody ReportDTO dto) {
        return new ResponseEntity<>(reportService.add(dto), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>(reportService.update(id), HttpStatus.OK);

    }


    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(reportService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(reportService.getOne(id), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(reportService.delete(id), HttpStatus.OK);

    }
}
