package com.feature.toggle.simpledate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SimpleDateToggleRepository extends JpaRepository<SimpleDateToggle, Long> {

    @Query("SELECT e " +
            "FROM SimpleDateToggle e " +
            "WHERE e.toggleId = :toggleId " +
            "AND e.startDate <= :currentDate " +
            "AND e.endDate >= e.startDate " +
            "AND e.endDate >= :currentDate")
    Optional<SimpleDateToggle> findByToggleIdAndDateRage(String toggleId, LocalDateTime currentDate);
}
