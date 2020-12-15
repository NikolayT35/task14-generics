package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight implements Comparable<Flight> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int durationInMinutes;

    public boolean matches(String from, String to) {
        if (this.getFrom().equalsIgnoreCase(from) &&
                this.getTo().equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) &&
                Objects.equals(to, flight.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to);
    }

    @Override
    public int compareTo(Flight o) {

        return price - o.price;
    }
}
