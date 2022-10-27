package br.com.elebasi.who_owes_me.repository;

import br.com.elebasi.who_owes_me.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
