package africa.semicolon.fakeCaller.dtos.Requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EditContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userEmail;
}
