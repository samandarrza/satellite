// FileReaderService.java
package com.company.service;

import com.company.model.Satellite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileReaderService {
    public List<Satellite> readSatelliteData(String filePath) {
        List<Satellite> satellites = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                Satellite satellite = new Satellite();
                satellite.setSatelliteId(Integer.parseInt(parts[0]));
                satellite.setLatitude(Double.parseDouble(parts[1]));
                satellite.setLongitude(Double.parseDouble(parts[2]));
                satellite.setTimestamp(parts[3]);
                satellite.setStatus(parts[4]);
                satellites.add(satellite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return satellites;
    }
}