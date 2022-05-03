package com.xworkz.tv_channel.dao;

import com.xworkz.tv_channel.entity.TVChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

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

	@Override
	public String getChannelNameByChannelId(Integer channelId) {
		String channelNameString = null;

		try {
			entityManager = factory.createEntityManager();

			Query query = entityManager.createQuery("SELECT channelName FROM TVChannel WHERE channelId = :id");
			query.setParameter("id", channelId);
			channelNameString = (String) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No data Found...!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return channelNameString;
	}

	@Override
	public void updateChannelPriceByChannelId(Integer id, Double price) {
		try {
			entityManager = factory.createEntityManager();
			//tx.begin();
			Query query = entityManager.createQuery("UPDATE TVChannel SET price = :price WHERE channelId = :id");
			query.setParameter("price", price);
			query.setParameter("id", id);
			entityManager.getTransaction().begin();
			query.executeUpdate();
			entityManager.getTransaction().commit();
			System.out.println("Update Successfully...");
		} catch (NoResultException e) {
			System.out.println("No records found...");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void deleteChannelById(Integer id) {
		entityManager=factory.createEntityManager();
		Query query= entityManager.createQuery("DELETE FROM TVChannel WHERE channelId=:id");
		query.setParameter("id", id);
		entityManager.getTransaction().begin();
		query.executeUpdate();
		entityManager.getTransaction().commit();
		System.out.println("Deleted Successfully...");
	}

}
