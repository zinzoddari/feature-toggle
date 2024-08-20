package com.feature.toggle.simplelocalcahce.toggle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimpleCacheToggleRepository extends JpaRepository<SimpleCacheToggle, Long> {
    Optional<SimpleCacheToggle> findByToggleId(String toggleId);
}
