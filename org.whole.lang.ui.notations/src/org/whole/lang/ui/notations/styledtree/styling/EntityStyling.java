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
package org.whole.lang.ui.notations.styledtree.styling;

import java.util.Optional;

import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityStyling implements IEntityStyling {
	private INotationStyling notationStyling;

	protected String typeIdentifier;
	protected EntityKinds kind;
	protected LayoutStyle layoutStyle;
	protected IFeatureStyling[] featuresStyling;
	private int embeddedFeaturesSize;

	public EntityStyling(String typeIdentifier, EntityKinds kind, IFeatureStyling... featuresStyling) {
		this(
				typeIdentifier, kind,
				kind.equals(EntityKinds.SIMPLE) ? LayoutStyle.TABLE : LayoutStyle.TREE,
				featuresStyling);
	}
	public EntityStyling(String typeIdentifier, EntityKinds kind, LayoutStyle layoutStyle, IFeatureStyling... featuresStyling) {
		this.typeIdentifier = typeIdentifier;
		this.kind = kind;
		this.layoutStyle = layoutStyle;
		this.featuresStyling = featuresStyling;
		for (IFeatureStyling fs : featuresStyling)
			if (fs.isEmbedded())
				embeddedFeaturesSize++;
	}

	public INotationStyling getNotationStyling() {
		return notationStyling;
	}
	public void setNotationStyling(INotationStyling notationStyling) {
		this.notationStyling = notationStyling;
	}

	public String getTypeIdentifier() {
		return typeIdentifier;
	}
	public String getTypeLabel() {
		return ResourceUtils.getFragmentPart(typeIdentifier);
	}

	public EntityKinds getKind() {
		return kind;
	}

	//for simple and composite entities
	public static enum LayoutStyle {
		TABLE, COLUMN, TREE
	}
	public LayoutStyle getLayoutStyle() {
		return layoutStyle;
	}

	public boolean embedChild(int index) {
		switch (getKind()) {
		case COMPOSITE:
			switch (layoutStyle) {
			case TABLE:
			case COLUMN:
				return true;
			case TREE:
				return false;
			}
		case SIMPLE:
			switch (layoutStyle) {
			case TABLE:
				return index > -1 && index < featuresStyling.length ? featuresStyling[index].isEmbedded() : false;
			case COLUMN:
				return true;
			case TREE:
				return false;
			}
		case DATA: default:
			return false;
		}
	}

	public int getEmbeddedFeaturesSize() {
		return embeddedFeaturesSize;
	}

	public IFeatureStyling[] getFeaturesStyling() {
		return featuresStyling;
	}

	public Optional<IFeatureStyling> getFeatureStyling(String name) {
		for (IFeatureStyling fs : getFeaturesStyling())
			if (fs.getName().equals(name))
				return Optional.of(fs);
		return Optional.empty();
	}
}
