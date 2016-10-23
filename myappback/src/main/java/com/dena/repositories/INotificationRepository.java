package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Long>{
	
}
