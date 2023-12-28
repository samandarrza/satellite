package com.company.service;

import com.company.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class FilterService {
    public List<Satellite> filterByStatus(List<Satellite> satellites, String status) throws Exception {
        List<Satellite> filteredSatellites = new ArrayList<>();
        try {
            filteredSatellites = satellites.stream()
                    .filter(satellite -> satellite.getStatus().equals(status))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new NullPointerException("NullPointerException occurred: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("An unexpected error occurred: " + e.getMessage());
        }
        return filteredSatellites;
    }
}
