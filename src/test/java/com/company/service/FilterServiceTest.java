package com.company.service;

import com.company.model.Satellite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest()

public class FilterServiceTest {

    public FilterService filterService;

    public List<Satellite> satellites;

    @BeforeEach
    public void setUp() {
        filterService = new FilterService();
        satellites = new ArrayList<Satellite>() {};
    }

    @Test
    public void whenStatusIsOk_thenShouldReturnThreeValues() throws Exception {
        Satellite satellite1 = new Satellite();
        satellite1.setStatus("OK");
        Satellite satellite2 = new Satellite();
        satellite2.setStatus("NOK");
        Satellite satellite3 = new Satellite();
        satellite3.setStatus("OK");

        Satellite satellite4 = new Satellite();
        satellite4.setStatus("OK");

        List<Satellite> satellites = new ArrayList<Satellite>() {
        };
        satellites.add(satellite1);
        satellites.add(satellite2);
        satellites.add(satellite3);
        satellites.add(satellite4);

        List<Satellite> result = filterService.filterByStatus(satellites, "OK");
        assert result.size() == 3;
    }

    @Test
    public void whenStatusIsOk_thenShouldReturnZeroValues() throws Exception {
        List<Satellite> result = filterService.filterByStatus(satellites, "OK");
        assert result.size() == 0;
    }

    @Test
    public void testFilterByStatus_NullStatus() {
        Satellite satellite1 = new Satellite();
        satellite1.setStatus("OK");
        Satellite satellite2 = new Satellite();
        satellite2.setStatus(null); // Simulating a null status

        satellites.add(satellite1);
        satellites.add(satellite2);

        // Asserting that the method should throw a NullPointerException
        assertThrows(NullPointerException.class, () -> filterService.filterByStatus(satellites, "OK"));
    }
}
