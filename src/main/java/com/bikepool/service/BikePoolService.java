package com.bikepool.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by rampal on 5/11/17.
 */
public interface BikePoolService {
    List<String> getCities();
}
