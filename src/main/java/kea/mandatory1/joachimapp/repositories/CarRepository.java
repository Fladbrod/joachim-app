package kea.mandatory1.joachimapp.repositories;

import kea.mandatory1.joachimapp.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
