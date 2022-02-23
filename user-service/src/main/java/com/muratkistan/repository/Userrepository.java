package com.muratkistan.repository;

import com.muratkistan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User,Long> {

}
