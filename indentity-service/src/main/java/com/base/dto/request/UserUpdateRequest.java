package com.base.dto.request;

import java.time.LocalDate;
import java.util.List;

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
public class UserUpdateRequest {

    private String password;

    private String lastName;

    private String firstName;

    @DobConstraint(min = 2, message = "INVALID_DOB")
    private LocalDate dob;

    List<String> roles;
}
