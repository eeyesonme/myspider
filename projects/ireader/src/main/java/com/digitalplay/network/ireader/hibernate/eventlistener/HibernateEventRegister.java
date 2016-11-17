package com.digitalplay.network.ireader.hibernate.eventlistener;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventRegister {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MyEventLoadListener loadEventListener; 
	
	@PostConstruct
	public void registerListeners() {
		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);
		registry.setListeners(EventType.LOAD, loadEventListener);
	}
}
