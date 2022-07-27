package africa.semicolon.fakeCaller.services;

import africa.semicolon.fakeCaller.Exceptions.UserExistsException;
import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.data.repositories.UserRepository;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.fakeCaller.dtos.Responses.CreateContactResponse;
import africa.semicolon.fakeCaller.dtos.Responses.RegisterUserResponse;

public class UserService implements iUserService {
    private UserRepository userRepo = new UserRepository();
    private final User user = new User();

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        // check if email exists and throw exception

        //create a new user
        //copy fields  from request to new user
        //save new user into repository
        User savedUser = userRepo.findByEmail(request.getEmail());

        if(savedUser != null) throw new UserExistsException(request.getEmail() + " already exists!");

        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepo.save(user);

        return null;
    }

    @Override
    public CreateContactResponse createContact(CreateContactResponse request) {
        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepo.count();
    }
}
