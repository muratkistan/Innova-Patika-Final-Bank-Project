package com.muratkistan.repository;

import com.muratkistan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByIdentityNumber(String identityNumber);
    User findByPhoneNumber(String phonenumber);


}
