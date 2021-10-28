package com.example.Controller;

import com.example.Services.ICoronavirusStatsServices;

import com.example.Services.CoronavirusStatsServicesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Coronavirus stats controller.
 */
@RestController
@CrossOrigin(origins = "*")
public class CoronavirusStatsController {

    /**
     * The Cs.
     */
    @Autowired
    ICoronavirusStatsServices cs;

    /**
     * Gets all cases.
     *
     * @return the all cases
     */
    @RequestMapping(value="/cases", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCases() {
        try {
            return new ResponseEntity<>(cs.getAllCases(), HttpStatus.ACCEPTED);
        } catch (CoronavirusStatsServicesException e) {
            if (e.getMessage().equals("Cases not found")){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Gets cases by country.
     *
     * @param country the country
     * @return the cases by country
     */
    @RequestMapping(value="/cases/{country}", method = RequestMethod.GET)
    public ResponseEntity<?> getCasesByCountry(@PathVariable (name="country") String country) {
        try {
            return new ResponseEntity<>(cs.getCasesByCountry(country), HttpStatus.ACCEPTED);
        }catch (CoronavirusStatsServicesException e) {
            if (e.getMessage().equals("Cases not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}