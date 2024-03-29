package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test class for Compensation
 *
 * @author Meenu Gigi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {


    private String readCompensationUrl;
    private String createCompensationUrl;

    @Autowired
    private CompensationService compensationService;

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
        readCompensationUrl = "http://localhost:" + port + "/compensation/{id}";
        createCompensationUrl = "http://localhost:" + port + "/compensation";

    }

    /**
     * Test method to check create and read functionalities of compensation class
     *
     */
    @Test
    public void testCreateRead() {

        testEmployee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        Compensation testCompensation = new Compensation(testEmployee, "999,999,999 USD", Instant.parse("2020-10-20T00:00:00Z"));


        // Create checks
        Compensation createdCompensation = restTemplate.postForEntity(createCompensationUrl, testCompensation,
                Compensation.class).getBody();
        assertNotNull(createdCompensation);
        assertEquals(testCompensation, createdCompensation);


        // Read checks
        Compensation readCompensation = restTemplate.getForEntity(readCompensationUrl, Compensation.class, createdCompensation.getEmployee().getEmployeeId()).getBody();
        assertNotNull(readCompensation);
        assertEquals(createdCompensation, readCompensation);
    }

}

