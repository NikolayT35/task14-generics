package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(new FlightRepository());
    private Flight first = new Flight(1, 11348, "VKO", "IKT", 5227);
    private Flight second = new Flight(2, 27883, "DME", "KTM", 4755);
    private Flight third = new Flight(3, 10212, "VKO", "IKT", 5300);
    private Flight fourth = new Flight(4, 10924, "VKO", "IKT", 5227);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void getAllIfOne() {

        Flight[] actual = manager.getAll("DME", "KTM");
        Flight[] expected = new Flight[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfSome() {

        Flight[] actual = manager.getAll("VKO", "IKT");
        Flight[] expected = new Flight[]{third, first, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfNone() {

        Flight[] actual = manager.getAll("VKO", "KTM");
        Flight[] expected = new Flight[0];

        assertArrayEquals(expected, actual);
    }
}