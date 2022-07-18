package com.mindex.challenge.service.impl;


import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service Provider class for Reporting Structure.
 * Implements the Reporting Structure interface.
 *
 * @author Meenu Gigi
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);


    @Autowired
    private EmployeeService employeeService;


    /**
     * Function to read reporting structure.
     * @param id    employeeID
     * @return the reporting structure read
     */
    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Reading reporting structure of employee with id [{}]", id);
//        retrieving the employee
        Employee employee = employeeService.read(id);
        int numTotalReports = getNumTotalReports(id);
//        creates a reporting structure with the employee and total number of reports
        ReportingStructure reportingStructure = new ReportingStructure(employee, numTotalReports);
        return reportingStructure;
    }


    /**
     * Function to calculate total number of reports.
     * @param id    the employeeID
     * @return the total number of reports for an employee
     */
    private int getNumTotalReports(String id){
        int totalReports = 0;
        Employee emp = employeeService.read(id);
        if(emp == null){
            throw new RuntimeException("Employee with id" + id + " not found!");
        }
//        creates a list with the records of direct reports for given employee
        List<Employee> directReports = emp.getDirectReports();
//        recursively calculate number of reports for each direct-report of the given employee
        if(directReports != null){
            for(Employee e: directReports){
                totalReports += 1 + getNumTotalReports(e.getEmployeeId());
            }
        }
        return totalReports;
    }
}
