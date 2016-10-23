package com.dena.service;

import java.util.List;

import com.dena.entities.Notification;

public interface INotificationService {
	public Notification save(Notification notification) ;
	public List<Notification> findAll() ;
	public Notification findById(long id) ;
	public void delete(long id) ;
	public Notification update(long id,Notification notification);
}
