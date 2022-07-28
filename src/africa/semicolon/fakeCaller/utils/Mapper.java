package africa.semicolon.fakeCaller.utils;

import africa.semicolon.fakeCaller.data.models.User;
import africa.semicolon.fakeCaller.dtos.Requests.RegisterUserRequest;

public class Mapper {
    public static void map(RegisterUserRequest req, User user) {
        user.setLastName(req.getLastName());
        user.setFirstName(req.getFirstName());
        user.setEmail(req.getEmail());
        user.setPhoneNumber(req.getPhoneNumber());
    }
}
