package com.example.soldLites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.net.server.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}