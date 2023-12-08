package com.docfee.admin.utng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docfee.admin.utng.model.TokensNotificaciones;
import java.util.List;
import java.util.Optional;


@Repository
public interface ITokensNotificacionesRepository extends JpaRepository<TokensNotificaciones, Integer>{
    Optional<TokensNotificaciones> findByAuth(String auth);
}
