package com.mysport.football.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mysport.football.entity.football;
import com.mysport.football.service.MatchService;


@RestController
@RequestMapping("/api/pl")
public class matchController {
    
    private MatchService matchService;

    public matchController(MatchService matchService) {
        this.matchService = matchService;
    }
@PostMapping
public ResponseEntity<football> footballmatches(@RequestBody football Football){
    return new ResponseEntity<football>(matchService.footballmatches(Football), HttpStatus.CREATED);
}
    @GetMapping
    public List<football> getAllMatches(){
        return matchService.getAllMatches();
    }
    @GetMapping("{id}")
    public ResponseEntity<football> getbyId(@PathVariable("id") long matchid){
        return new ResponseEntity<football>(matchService.getMatchesbyLeague(matchid), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<football> updateId(@PathVariable ("id") long id, 
                                                    @RequestBody football football){
        return new ResponseEntity<football>(matchService.updateMatches(football, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable ("id") long id){
        matchService.deleteMatches(id);
        return new ResponseEntity<String>("team record deleted", HttpStatus.OK);
    }
}
