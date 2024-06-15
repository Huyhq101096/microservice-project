package com.base.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.base.dto.request.ProfileCreationRequest;

@FeignClient(name = "profile-service", url = "http://localhost:5001/profile/users")
public interface ProfileClient {

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    Object createProfile(@RequestBody ProfileCreationRequest request);
}
