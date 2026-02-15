package com.feature.toggle.mapchache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapCacheToggleRepository extends JpaRepository<MapCacheToggle, Long> {
    Optional<MapCacheToggle> findByToggleId(String toggleId);
}
