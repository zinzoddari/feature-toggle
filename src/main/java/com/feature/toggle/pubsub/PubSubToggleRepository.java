package com.feature.toggle.pubsub;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PubSubToggleRepository extends JpaRepository<PubSubToggle, Long> {
    Optional<PubSubToggle> findByToggleId(String toggleId);
}
