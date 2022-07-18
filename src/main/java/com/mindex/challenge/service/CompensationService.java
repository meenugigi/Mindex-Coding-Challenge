package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/**
 * Service Provider interface for Compensation.
 *
 * @author Meenu Gigi
 */
public interface CompensationService {

    Compensation create(Compensation compensation);

    Compensation read(String id);
}
