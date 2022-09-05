package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.BannedDTO;
import com.reddit.RedditClone.service.BannedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/banned")
public class BannedController {

    @Autowired
    private BannedService bannedService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@RequestBody BannedDTO dto) {
        return new ResponseEntity<>(bannedService.add(dto), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BannedDTO dto) {
        return new ResponseEntity<>(bannedService.update(id, dto), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bannedService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(bannedService.getOne(id), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(bannedService.delete(id), HttpStatus.OK);

    }

}
