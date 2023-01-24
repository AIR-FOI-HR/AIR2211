package hr.foi.air.ednevnik.Requests;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PrijavaRequest {

    @NotNull
    private String email;

    @NotNull
    private String lozinka;

}
