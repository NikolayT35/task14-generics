package ru.netology.comparator;

import ru.netology.domain.Flight;

import java.util.Comparator;

public class FlightByDurationAscComparator implements Comparator<Flight> {
    public int compare(Flight o1, Flight o2) {
        return o1.getDurationInMinutes() - o2.getDurationInMinutes();
    }
}
