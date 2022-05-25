package com.nanum.nanumserver.Item.domain.repository;

import com.nanum.nanumserver.Item.domain.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, Long> {
}