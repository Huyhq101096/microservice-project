package com.base.dto.request;

import com.base.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationRequest {

    String lastName;

    String firstName;

    @DobConstraint(min = 16, message = "INVALID_DOB")
    LocalDate dob;

    String city;

}
