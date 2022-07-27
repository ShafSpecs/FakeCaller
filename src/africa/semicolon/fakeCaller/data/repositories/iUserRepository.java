package africa.semicolon.fakeCaller.data.repositories;

import africa.semicolon.fakeCaller.data.models.User;

import java.util.List;

public interface iUserRepository {
    User save(User user);

    void delete(User user);

    void delete(int id);

    User findById(int id);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findAll();

    int count();

    User findByEmail(String email);
}