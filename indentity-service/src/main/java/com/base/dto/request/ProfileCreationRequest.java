package com.base.dto.request;

import java.time.LocalDate;

import com.base.validator.DobConstraint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationRequest {

    String userId;

    String lastName;

    String firstName;

    @DobConstraint(min = 16, message = "INVALID_DOB")
    LocalDate dob;

    String city;
}
