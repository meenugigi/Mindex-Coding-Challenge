package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Provider class for Compensation.
 * Implements the CompensationService interface.
 *
 * @author Meenu Gigi
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compensationRepository;


    /**
     * Function to create compensation.
     * @param compensation
     * @return the created compensation
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation for [{}]", compensation);
//        retrieving employee details
        Employee emp = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(emp);
        compensationRepository.insert(compensation);
        return compensation;
    }


    /**
     * Function to read compensation for employee.
     * @param id       the employeeID
     * @return the compensation
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation for Employee id [{}]", id);
//        Employee emp = employeeService.read(id);
        Compensation compensation = compensationRepository.findByEmployee(employeeService.read(id));
        if(compensation == null){
            throw new RuntimeException("Null compensation for employee with id " +id);
        }
        return compensation;
    }
}
