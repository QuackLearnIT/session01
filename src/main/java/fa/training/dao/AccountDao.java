package fa.training.dao;

import fa.training.entity.Account;

import java.util.Optional;

public interface AccountDao {

    Optional<Account> findById(String account);
}
