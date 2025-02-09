package com.example.messagingstompwebsocket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications,String >{
    List<Notifications> findAllByFlagReadIsFalseAndUserToOrderBySentOnDesc(String userTo);
}
