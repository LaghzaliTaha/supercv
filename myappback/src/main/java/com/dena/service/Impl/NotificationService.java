package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Notification;
import com.dena.repositories.INotificationRepository;
import com.dena.service.INotificationService;


@Service
@Transactional
public class NotificationService implements INotificationService{

	@Autowired
	private INotificationRepository notificationRepository ;
	
	

	@Override
	public Notification save( Notification notification) {
		// TODO Auto-generated method stub
		return notificationRepository.save(notification);
	}

	@Override
	public List< Notification> findAll() {
		// TODO Auto-generated method stub
		return notificationRepository.findAll();
	}

	@Override
	public  Notification findById(long id) {
		// TODO Auto-generated method stub
		return notificationRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		notificationRepository.delete(id);
		
	}

	





	public INotificationRepository getNotificationRepository() {
		return notificationRepository;
	}

	public void setNotificationRepository(INotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@Override
	public  Notification update(long id, Notification notification) {
		 Notification x=notificationRepository.findOne(id);
		x.setContenuNotification(x.getContenuNotification());
		return notificationRepository.save(x);
	}
	
}
