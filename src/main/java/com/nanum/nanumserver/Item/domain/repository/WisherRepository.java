package com.nanum.nanumserver.Item.domain.repository;

import com.nanum.nanumserver.Item.domain.Wisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WisherRepository extends JpaRepository<Wisher, Long> {
    Optional<Wisher> findByWisherID(Long wisherID);
}
