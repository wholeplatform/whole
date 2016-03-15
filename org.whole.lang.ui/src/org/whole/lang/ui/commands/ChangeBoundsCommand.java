/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.commands;

import org.eclipse.gef.commands.Command;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptorEnum;

/**
 * @author Enrico Persiani
 */
public class ChangeBoundsCommand extends Command implements ILegacyCommand {
	private IEntity entity;
	FeatureDescriptorEnum featureEnum;
	private int oldX;
	private int oldY;
	private int oldWidth;
	private int oldHeight;
	private int newX;
	private int newY;
	private int newWidth;
	private int newHeight;

	public void execute() {
		setBounds(newX, newY, newWidth, newHeight);
	}

	public void undo() {
		setBounds(oldX, oldY, oldWidth, oldHeight);
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
		featureEnum = entity.wGetEntityDescriptor().getFeatureDescriptorEnum();
		oldX = entity.wGet(featureEnum.valueOf("x")).wIntValue();
		oldY = entity.wGet(featureEnum.valueOf("y")).wIntValue();
		oldWidth = entity.wGet(featureEnum.valueOf("width")).wIntValue();
		oldHeight = entity.wGet(featureEnum.valueOf("height")).wIntValue();
	}
	
	public void setConstraint(int x, int y, int width, int height) {
		newX = x;
		newY = y;
		newWidth = width;
		newHeight = height;
	}

	protected void setBounds(int x, int y, int width, int height) {
		entity.wGet(featureEnum.valueOf("x")).wSetValue(x);
		entity.wGet(featureEnum.valueOf("y")).wSetValue(y);
		if (width > 0 && height > 0) {
			entity.wGet(featureEnum.valueOf("width")).wSetValue(width);
			entity.wGet(featureEnum.valueOf("height")).wSetValue(height);
		}
	}
}
