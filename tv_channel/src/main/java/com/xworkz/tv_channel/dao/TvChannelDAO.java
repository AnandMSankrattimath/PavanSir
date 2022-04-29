package com.xworkz.tv_channel.dao;

import com.xworkz.tv_channel.entity.TVChannel;

public interface TvChannelDAO {
	void saveTVChannel(TVChannel tvChannel);

	public TVChannel getChannelByID(Integer ChannelId);

	public void updateTVChannel(Double price, Integer channelId);

	public void deleteTVChannel(Integer channelId);

}
