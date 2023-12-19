package com.company.service;

import com.company.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FilterService {
    public List<Satellite> filterByStatus(List<Satellite> satellites, String status) {
        return satellites.stream()
                .filter(satellite -> satellite.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
