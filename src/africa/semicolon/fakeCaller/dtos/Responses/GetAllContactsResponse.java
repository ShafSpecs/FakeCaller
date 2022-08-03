package africa.semicolon.fakeCaller.dtos.Responses;

import lombok.Data;

@Data
public class GetAllContactsResponse {
    private int id;
    private String firstName;
    private String lastName;
}
