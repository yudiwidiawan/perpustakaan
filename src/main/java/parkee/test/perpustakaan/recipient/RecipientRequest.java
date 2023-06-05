package parkee.test.perpustakaan.recipient;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.domain.common.Gender;

@Getter
@Setter
@NoArgsConstructor
public class RecipientRequest {
    @Schema(name = "firstName", example = "Angelina", requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;
    @Schema(name = "middleName", example = "Jolie", requiredMode = Schema.RequiredMode.REQUIRED)
    private String middleName;
    @Schema(name = "lastName", example = "Voight", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;
    @Schema(name = "gender", example = "FEMALE", requiredMode = Schema.RequiredMode.REQUIRED)
    private Gender gender;
    @Schema(name = "birthdate", example = "1975-06-04", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date birthDate;
    @Schema(name = "homeNumber", example = "022123123123", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long homeNumber;
    @Schema(name = "phoneNumnber", example = "085123123123", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long phoneNumber;
    @Schema(name = "email", example = "angelinajolie@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(name = "street", example = "Jl Teuku Umar Bl FA-3/45, Dki Jakarta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String street;
    @Schema(name = "subDistrict", example = "-", requiredMode = Schema.RequiredMode.REQUIRED)
    private String subDistrict;
    @Schema(name = "district", example = "-", requiredMode = Schema.RequiredMode.REQUIRED)
    private String district;
    @Schema(name = "city", example = "Jakarta Selatan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;
    @Schema(name = "province", example = "DKI Jakarta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String province;
    @Schema(name = "country", example = "Indonesia", requiredMode = Schema.RequiredMode.REQUIRED)
    private String country;
}
