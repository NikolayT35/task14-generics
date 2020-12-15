package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.FlightByDurationAscComparator;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(new FlightRepository());
    private Flight first = new Flight(1, 11348, "VKO", "IKT", 5227);
    private Flight second = new Flight(2, 27883, "DME", "KTM", 4755);
    private Flight third = new Flight(3, 10212, "VKO", "IKT", 5300);
    private Flight fourth = new Flight(4, 10924, "VKO", "IKT", 5227);
    private Flight fifth = new Flight(2, 27883, "DME", "KTM", 4800);
    private FlightByDurationAscComparator comparator = new FlightByDurationAscComparator();


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void getAllIfOne() {

        Flight[] actual = manager.getAll("DME", "KTM", new FlightByDurationAscComparator());
        Flight[] expected = new Flight[]{second, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfSome() {

        Flight[] actual = manager.getAll("VKO", "IKT", new FlightByDurationAscComparator());
        Flight[] expected = new Flight[]{first, third, fourth};

        assertArrayEquals(expected, actual);
    }
}