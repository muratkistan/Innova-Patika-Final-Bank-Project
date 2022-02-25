package com.muratkistan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-service")
public interface AccountServiceClient {
//    @PostMapping("add")
//    ResponseEntity<UserDto> addUserFeign( @RequestBody UserDto userdto);
}

