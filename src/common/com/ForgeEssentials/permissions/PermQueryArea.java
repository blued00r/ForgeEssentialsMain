package com.ForgeEssentials.permissions;

import java.util.ArrayList;

import net.minecraft.src.EntityPlayer;
import net.minecraftforge.event.Event.HasResult;

import com.ForgeEssentials.util.AreaSelector.AreaBase;
import com.ForgeEssentials.util.AreaSelector.Point;
import com.ForgeEssentials.util.AreaSelector.Selection;

/**
 * Reuslts are: default, allow, deny.
 * @author AbrarSyed
 * 
 */
@HasResult
public class PermQueryArea extends PermQueryPlayer
{
	public ArrayList<AreaBase>	applicable;
	public final AreaBase				doneTo;
	public final boolean allOrNothing;

	public PermQueryArea(EntityPlayer player, String permission, AreaBase doneTo, boolean allOrNothing)
	{
		super(player, permission);
		applicable = new ArrayList<AreaBase>();
		this.doneTo = doneTo;
		this.allOrNothing = allOrNothing;
	}
	
	public PermQueryArea(EntityPlayer player, String permission, Point doneTo)
	{
		super(player, permission);
		applicable = new ArrayList<AreaBase>();
		this.doneTo = new Selection(doneTo, doneTo);
		allOrNothing = true;
	}

	/**
	 * @return DEFAULT if the applicable areas should be checked. ALLOW/DENY if permission is completely allowed or denied.
	 */
	@Override
	public Result getResult()
	{
		return super.getResult();
	}

	/**
	 * set DEFAULT if the applicable regions list is to be used.
	 * set DENY if the permissions is completely denied throughout the requested area.
	 * set ALLOW if the permission is compeltely allowed throughout the requested area.
	 * 
	 * @param value The new result
	 */
	@Override
	public void setResult(Result value)
	{
		switch (value)
			{
				case ALLOW:
					applicable.clear();
					applicable.add(doneTo);
					break;
				case DENY:
					applicable.clear();
				default:
					break;
			}
		super.setResult(value);
	}
}
