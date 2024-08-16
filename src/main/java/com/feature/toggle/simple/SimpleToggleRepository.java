package com.feature.toggle.simple;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimpleToggleRepository extends JpaRepository<SimpleToggle, Long> {
    Optional<SimpleToggle> findByToggleId(String toggleId);
}
