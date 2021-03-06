package com.nanum.nanumserver.Item.domain.repository;

import com.nanum.nanumserver.Item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findById(Long id);
}
