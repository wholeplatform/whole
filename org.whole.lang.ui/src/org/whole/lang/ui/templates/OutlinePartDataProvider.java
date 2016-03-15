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
package org.whole.lang.ui.templates;

import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class OutlinePartDataProvider implements IOutlineUIProvider {
	private OutlineKinds kind;
	private boolean startOpened;
	private String text;
	private Image image;
	private FeatureDescriptor[] features;

	public OutlinePartDataProvider(OutlineKinds kind, boolean startOpened, String text, Image image, FeatureDescriptor... features) {
		this.kind = kind;
		this.startOpened = startOpened;
		this.text = text;
		this.image = image;
		this.features = features;
		
		if (kind != OutlineKinds.LEAF && features != null && features.length == 0)
			this.features = null;
	}

	public OutlineKinds getTemplateKind(IEntity entity) {
		return kind;
	}
	
	public boolean startOpened(IEntity entity) {
		return startOpened;
	}

	public FeatureDescriptor[] getFeatures(IEntity entity) {
		return features != null ? features : entity.wGetEntityDescriptor().getEntityFeatureDescriptors()
				.toArray(new FeatureDescriptor[0]);
	}

	public String getText(IEntity entity) {
		return text;
	}
	public Image getImage(IEntity entity) {
		return image;
	}
}