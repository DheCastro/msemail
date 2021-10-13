package br.com.dhecastro.msemail.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dhecastro.msemail.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
}
