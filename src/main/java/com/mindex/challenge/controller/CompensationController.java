package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for Compensation.
 *
 */
@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    /**
     * Function to create compensation.
     *
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation){
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }


    /**
     * Function to read compensation.
     *
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id){
        LOG.debug("Received compensation read request for Employee id [{}]", id);

        return compensationService.read(id);
    }
}
