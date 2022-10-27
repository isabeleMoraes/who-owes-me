package br.com.elebasi.who_owes_me.repository;

import br.com.elebasi.who_owes_me.entity.LitleBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LitleBoxRepository extends JpaRepository<LitleBox, Long> {
    public Optional<LitleBox> findByTitle(String title);
}
