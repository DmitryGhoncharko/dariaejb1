package by.webproj.carshowroom.securiy;

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import javax.ejb.Singleton;


@Slf4j
public class BcryptWithSaltHasherImpl implements PasswordHasher {
    private static final String SALT = BCrypt.gensalt();

    @Override
    public boolean checkIsEqualsPasswordAndPasswordHash(String password, String passwordHash) {
        log.info("Passwords was equals ##checkIsEqualsPasswordAndPasswordHash method##");
        return BCrypt.checkpw(password, passwordHash);
    }

    @Override
    public String hashPassword(String password) {
        log.info("Password was hashed");
        return BCrypt.hashpw(password, SALT);
    }
}
