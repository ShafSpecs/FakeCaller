package africa.semicolon.fakeCaller.data.repositories;

import africa.semicolon.fakeCaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements iUserRepository {
    private int counter;
    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        int userId = user.getId();
        for (User value : users) {
            if (value.getId() == userId) {
                user.setFirstName(value.getFirstName());
                user.setLastName(value.getLastName());
                user.setEmail(value.getEmail());
                user.setPhoneNumber(value.getPhoneNumber());
                user.setContacts(value.getContacts());

                return value;
            }
        }
        counter++;
        user.setId(counter);
        users.add(user);
        return user;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        counter--;
    }

    @Override
    public void delete(int id) {
        User foundUser = findById(id);
        users.remove(foundUser);
        counter--;
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int count() {
        return counter;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users){
            if(user.getEmail().equalsIgnoreCase(email))
                return user;
        }

        return null;
    }
}