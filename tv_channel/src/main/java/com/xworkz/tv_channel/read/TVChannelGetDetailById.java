package com.xworkz.tv_channel.read;

import com.xworkz.tv_channel.entity.TVChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TVChannelGetDetailById {

	
	public void getDetails() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tv");
		EntityManager entityManager = factory.createEntityManager();
		TVChannel tvChannel= entityManager.find(TVChannel.class, 1);
		System.out.println(tvChannel.toString());
		
		//System.out.println("TV Channel Details : Name = "+tvChannel.getChannelName()+" Launguage : "+tvChannel.getLanguage()+" Price = "+tvChannel.getPrice() );
		
	}
	
}
