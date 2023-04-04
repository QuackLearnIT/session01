package fa.training.dao.impl;

import fa.training.dao.AccountDao;
import fa.training.entity.Account;
import fa.training.util.XmlConnectionConfig;
import org.hibernate.Session;

import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Optional<Account> findById(String empAccount) {
        try (Session session = XmlConnectionConfig.getSession()) {
            Account account = session.get(Account.class, empAccount);
            return Optional.ofNullable(account);
        }
    }
}