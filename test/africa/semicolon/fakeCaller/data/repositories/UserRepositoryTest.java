package africa.semicolon.fakeCaller.data.repositories;

import africa.semicolon.fakeCaller.data.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    @Test
    public void saveTest() {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("Omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    void saveUser_findByIdTest() {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("Omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());

        User savedUser = userRepository.findById(1);
        assertEquals("Omaposh", savedUser.getUsername());
    }

    @Test
    public void deleteUser_findByIdTest() {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("Omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());

        User savedUser = userRepository.findById(1);
        assertEquals("Omaposh", savedUser.getUsername());
    }

    @Test
    public void deleteContact_findByContactTest() {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("Omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");
        userRepository.save(user);
        assertEquals(1, userRepository.count());

        User savedUser = userRepository.findById(1);
        assertEquals("Omaposh", savedUser.getUsername());

        userRepository.delete(user);
        assertEquals(0, userRepository.count());
    }

    @Test
    public void updateTest() {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");

        userRepository.save(user);
        User savedUser = userRepository.findById(1);
        assertEquals("omaposh", savedUser.getUsername());

        user.setFirstName("Joshua");
        user.setUsername("JS");
        user.setPassword("4540");
        user.setEmail("ucj@gmail.com");

        userRepository.save(user);
        assertEquals(1, userRepository.count());

        savedUser = userRepository.findById(1);
        assertEquals("JS", savedUser.getUsername());
    }

    @Test
    public void findAllUserTest(){
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setFirstName("Omotola");
        user.setUsername("omaposh");
        user.setPassword("1909");
        user.setEmail("divajayjenny@gmail.com");

        userRepository.save(user);
        User savedUser = userRepository.findById(1);
        assertEquals("omaposh", savedUser.getUsername());

        User user2 = new User();
        user2.setFirstName("Joshua");
        user2.setUsername("JS");
        user2.setPassword("4540");
        user2.setEmail("uj@gmail.com");

        userRepository.save(user2);
        savedUser = userRepository.findById(2);
        assertEquals("JS", savedUser.getUsername());

        User user3 = new User();
        user3.setFirstName("Rahman");
        user3.setUsername("shafspecs");
        user3.setPassword("7890");
        user3.setEmail("Blessing@gmail.com");

        userRepository.save(user3);
        savedUser = userRepository.findById(3);
        assertEquals("shafspecs", savedUser.getUsername());

        User user4 = new User();
        user4.setFirstName("Olaoluwa");
        user4.setUsername("jenny");
        user4.setPassword("8908");
        user4.setEmail("posh@gmail.com");

        userRepository.save(user4);
        savedUser = userRepository.findById(4);
        assertEquals("jenny", savedUser.getUsername());

        User user5 = new User();
        user5.setFirstName("Fashola");
        user5.setUsername("seyi");
        user5.setPassword("2345");
        user5.setEmail("fashola@gmail.com");

        userRepository.save(user5);
        savedUser = userRepository.findById(5);
        assertEquals("seyi", savedUser.getUsername());


        assertEquals(5, userRepository.findAll().size());
    }
}
