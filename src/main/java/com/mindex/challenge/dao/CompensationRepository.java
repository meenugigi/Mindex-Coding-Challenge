package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Compensation class.
 *
 * @author Meenu Gigi
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    /**
     * Finds the compensation given the employee.
     * @param employee whose compensation is required.
     * @return compensation of the provided employee
     */
    Compensation findByEmployee(Employee employee);

}
