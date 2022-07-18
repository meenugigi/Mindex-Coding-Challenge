package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test class for Reporting Structure
 *
 * @author Meenu Gigi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {


    private String readReportingStructureUrl;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee testEmployee;

    @Before
    public void setup() {
        String employeeUrl = "http://localhost:" + port + "/employee";
        String employeeIdUrl = "http://localhost:" + port + "/employee/{id}";
        readReportingStructureUrl = "http://localhost:" + port + "reportingStructure/{id}";
    }

    /**
     * Test method to check read functionalities of Reporting Structure class
     *
     */
    @Test
    public void testRead() {

        testEmployee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        ReportingStructure expectedReportingStructure = new ReportingStructure(testEmployee, 4);


        // Read checks
        ReportingStructure actualReportingStructure = restTemplate.getForEntity(readReportingStructureUrl,
                ReportingStructure.class, testEmployee.getEmployeeId()).getBody();
        assertNotNull(actualReportingStructure);
        assertEquals(expectedReportingStructure, actualReportingStructure);
    }


}
