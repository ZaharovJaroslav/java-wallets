package ru.jaroslav_zakharov.wallets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jaroslav_zakharov.wallets.model.Wallet;

@Repository
public interface WalletsRepository extends JpaRepository<Wallet, Long> {
}
