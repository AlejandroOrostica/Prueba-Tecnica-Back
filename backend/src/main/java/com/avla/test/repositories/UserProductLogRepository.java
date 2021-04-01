package com.avla.test.repositories;

import com.avla.test.models.UserProductLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProductLogRepository extends JpaRepository<UserProductLog,Long> {

}
