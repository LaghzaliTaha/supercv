package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Notification;
import com.dena.service.INotificationService;


@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private INotificationService notificationService ;
	
	@RequestMapping(method=RequestMethod.POST)
	public Notification save(@RequestBody Notification notification) {
		return notificationService.save(notification);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Notification> findAll() {
		return notificationService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Notification findById(@PathVariable long id) {
		return notificationService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		notificationService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Notification update(@ PathVariable long id,@RequestBody Notification notification) {
		return notificationService.update(id,notification);
	}

	

}