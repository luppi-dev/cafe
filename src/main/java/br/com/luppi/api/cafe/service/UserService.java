package br.com.luppi.api.cafe.service;

import br.com.luppi.api.cafe.domain.User;
import br.com.luppi.api.cafe.dto.NewUserRequest;
import br.com.luppi.api.cafe.repository.UserRepository;
import br.com.luppi.api.cafe.utils.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void create(NewUserRequest request) {
        byte[] salt = CryptoUtils.generateSalt();
        byte[] hash = CryptoUtils.hashWithBcrypt(request.getPassword(), salt);
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setExposedID(UUID.randomUUID());
        user.setHash(hash);
        user.setSalt(salt);
        repository.save(user);
    }

}
