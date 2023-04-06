package com.mysport.football.service;
import java.util.List;
import com.mysport.football.entity.football;

public interface MatchService {
    football footballmatches(football Football);
    List<football> getAllMatches();
    football getMatchesbyLeague(long id);
    football updateMatches(football Football, long id);
    void deleteMatches(long id);
    }
