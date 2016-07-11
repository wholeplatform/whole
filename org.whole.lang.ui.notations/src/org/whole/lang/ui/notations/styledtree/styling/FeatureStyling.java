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

import org.whole.lang.ui.layout.Alignment;

/**
 * @author Riccardo Solmi
 */
public class FeatureStyling implements IFeatureStyling {
	protected String name;
	protected boolean embedded;
	protected boolean visible;
	protected Alignment alignment;

	public FeatureStyling(String name, boolean embedded, boolean visible) {
		this(name, embedded, visible, Alignment.LEADING);
	}
	public FeatureStyling(String name, boolean embedded, boolean visible, Alignment alignment) {
		this.name = name;
		this.embedded = embedded;
		this.visible = visible;
		this.alignment = alignment;
	}

	public String getName() {
		return name;
	}

	public boolean isEmbedded() {
		return embedded;
	}

	public boolean isVisible() {
		return visible;
	}

	public Alignment getAlignment() {
		return alignment;
	}
}
