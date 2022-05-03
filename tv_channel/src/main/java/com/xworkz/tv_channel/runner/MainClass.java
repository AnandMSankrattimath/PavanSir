package com.xworkz.tv_channel.runner;

import com.xworkz.tv_channel.dao.TVChannelDAOImpl;
import com.xworkz.tv_channel.dao.TvChannelDAO;
import com.xworkz.tv_channel.entity.TVChannel;

public class MainClass {

	public static void main(String[] args) {
		TVChannel tvChannel = new TVChannel();
		tvChannel.setChannelId(1);
		tvChannel.setChannelName("TV9");
		tvChannel.setLanguage("Hindi");
		tvChannel.setFree(false);
		tvChannel.setPrice(200.00);

		TvChannelDAO tvChannelDAO = new TVChannelDAOImpl();
		//tvChannelDAO.saveTVChannel(tvChannel);
		// System.out.println("Saved successfully");

		// System.out.println(tvChannelDAO.getChannelByID(4));

		//tvChannelDAO.updateTVChannel(7.00, 4);
		//System.out.println(" Updated....!");
		
		//tvChannelDAO.deleteTVChannel(4);
		
		//System.out.println(tvChannelDAO.getChannelNameByChannelId(2));
		
		//tvChannelDAO.updateChannelPriceByChannelId(1, 111.11);
		
		tvChannelDAO.deleteChannelById(2);
	}

}
