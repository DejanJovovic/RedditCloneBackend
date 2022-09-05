package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.FlairDTO;
import com.reddit.RedditClone.service.FlairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FlairDTO dto) {
        return new ResponseEntity<>(flairService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(flairService.delete(id), HttpStatus.OK);

    }
}
