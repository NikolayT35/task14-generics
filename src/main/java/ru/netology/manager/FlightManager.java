package ru.netology.manager;

import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

public class FlightManager {
    private FlightRepository repository;

    public FlightManager(FlightRepository repository) {

        this.repository = repository;
    }

    public void add(Flight item) {

        repository.save(item);
    }

    public void removeById(int id) {

        repository.removeById(id);
    }

    public Flight[] getAll(String from, String to, Comparator<Flight> comparator) {
        Flight[] result = new Flight[0];
        for (Flight flight : repository.findAll()) {
            if (flight.matches(from, to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;

    }
}
