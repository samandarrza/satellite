package com.company;

import com.company.model.Satellite;
import com.company.service.FileReaderService;
import com.company.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final FileReaderService fileReaderService;
    private final FilterService filterService;
    @Autowired
    public Main(FileReaderService fileReaderService, FilterService filterService) {
        this.fileReaderService = fileReaderService;
        this.filterService = filterService;
    }
    @Override
    public void run(String... args) throws Exception {
        String filePath = "satellite_data.txt";
        List<Satellite> allSatellites = fileReaderService.readSatelliteData(filePath);
        List<Satellite> filteredSatellites = filterService.filterByStatus(allSatellites, "OK");

        for (Satellite satellite : filteredSatellites) {
            displaySatelliteInfo(satellite);
        }
    }

    private void displaySatelliteInfo(Satellite satellite) {
        System.out.println("Satellite ID: " + satellite.getSatelliteId());
        System.out.println("Yer: En " + satellite.getLatitude() + ", Uzunluq " + satellite.getLongitude());
        System.out.println("Zaman: " + satellite.getTimestamp());
        System.out.println("Status: " + satellite.getStatus());
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
