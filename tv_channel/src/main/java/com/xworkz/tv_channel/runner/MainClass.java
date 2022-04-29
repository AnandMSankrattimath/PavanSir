package com.xworkz.tv_channel.runner;

import com.xworkz.tv_channel.dao.TVChannelDAOImpl;
import com.xworkz.tv_channel.dao.TvChannelDAO;
import com.xworkz.tv_channel.entity.TVChannel;

public class MainClass {

	public static void main(String[] args) {
		TVChannel tvChannel = new TVChannel();
		tvChannel.setChannelId(4);
		tvChannel.setChannelName("Pogo");
		tvChannel.setLanguage("Hindi");
		tvChannel.setFree(false);
		tvChannel.setPrice(119.22);

		TvChannelDAO tvChannelDAO = new TVChannelDAOImpl();
		// tvChannelDAO.saveTVChannel(tvChannel);
		// System.out.println("Saved successfully");

		// System.out.println(tvChannelDAO.getChannelByID(4));

		//tvChannelDAO.updateTVChannel(7.00, 4);
		//System.out.println(" Updated....!");
		
		tvChannelDAO.deleteTVChannel(4);

	}

}
