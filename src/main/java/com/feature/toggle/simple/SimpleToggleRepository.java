package com.feature.toggle.simple;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleToggleRepository extends JpaRepository<SimpleToggle, Long> {
    SimpleToggle findByToggleId(String toggleId);
}
