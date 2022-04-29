package com.xworkz.tv_channel.dao;

import com.xworkz.tv_channel.entity.TVChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TVChannelDAOImpl implements TvChannelDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("tv");
	EntityManager entityManager = null;
	EntityTransaction tx = null;
	TVChannel tvChannel = null;

	@Override
	public void saveTVChannel(TVChannel tvChannel) {
		try {
			entityManager = factory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(tvChannel);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	@Override
	public TVChannel getChannelByID(Integer ChannelId) {
		try {
			entityManager = factory.createEntityManager();
			tvChannel = entityManager.find(TVChannel.class, ChannelId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return tvChannel;
	}

	@Override
	public void updateTVChannel(Double price, Integer ChannelId) {
		try {
			entityManager = factory.createEntityManager();
			tvChannel = entityManager.find(TVChannel.class, ChannelId);
			if (tvChannel != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				tvChannel.setPrice(price);
				entityManager.merge(tvChannel);
				tx.commit();
			} else {
				System.out.println("No Record Found....");
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void deleteTVChannel(Integer channelId) {
		try {
			entityManager = factory.createEntityManager();
			tvChannel = entityManager.find(TVChannel.class, channelId);
			if (tvChannel != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				entityManager.remove(tvChannel);
				tx.commit();
			} else {
				System.err.println("Record not Found...");
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

}
