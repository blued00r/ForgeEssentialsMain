package com.ForgeEssentials.commands;

import com.ForgeEssentials.core.PlayerInfo;
import com.ForgeEssentials.util.AreaSelector.Point;

import net.minecraft.src.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EventHandler
{

	@ForgeSubscribe
	public void onPlayerDeath(LivingDeathEvent e)
	{
		if (e.entity instanceof EntityPlayer)
			PlayerInfo.getPlayerInfo((EntityPlayer) e.entity).lastDeath = new Point((int) e.entity.posX, (int) e.entity.posY, (int) e.entity.posZ);
	}
}
