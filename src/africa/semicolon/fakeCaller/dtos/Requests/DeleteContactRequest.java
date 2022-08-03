package africa.semicolon.fakeCaller.dtos.Requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DeleteContactRequest {
    private String userEmail;
    private String contactNumber;
}
