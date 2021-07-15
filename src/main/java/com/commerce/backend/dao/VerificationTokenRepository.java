package com.commerce.backend.dao;

import com.commerce.backend.model.entity.VerificationToken;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
    @Query(value="select distinct on(id, expiry_date, user_id) * From verification_token vt where user_id = ?1 order by user_id ,expiry_date desc  limit 1", nativeQuery =true)
    Optional<VerificationToken> findByUserId(Long id);
}
