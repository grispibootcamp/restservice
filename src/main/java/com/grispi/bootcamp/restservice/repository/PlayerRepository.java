package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
