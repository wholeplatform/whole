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
package org.whole.lang.frames.events;

import java.util.Date;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Riccardo Solmi
 */
public class FramesChangeEventHandler extends IdentityChangeEventHandler {
	private static final long serialVersionUID = 1L;
	protected final IEclipseContext context;
	

	public FramesChangeEventHandler(IEclipseContext context) {
		this.context = context;
	}

	public void resfreshNotation(final IEntity source) {
		EntityEditDomain editDomain = context.get(IEntityPartViewer.class).getEditDomain();
		if (editDomain.isDisabled() || !isVariabilityDescendant(source))
			return;

		UISynchronize uiSynchronize = context.get(UISynchronize.class);
		uiSynchronize.syncExec(() -> editDomain.setDisabled(true));
		FramesUtils.updateSubset(source);
		uiSynchronize.asyncExec(() -> editDomain.setDisabled(false));
	}

	public boolean isVariabilityDescendant(IEntity source) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return Matcher.findAncestor(
				mf.atFeatureMatcher(FramesFeatureDescriptorEnum.variability), source) != null;
	}

    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
    	resfreshNotation(source);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
    	resfreshNotation(source);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
    	resfreshNotation(source);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
    	resfreshNotation(source);
    }
}
