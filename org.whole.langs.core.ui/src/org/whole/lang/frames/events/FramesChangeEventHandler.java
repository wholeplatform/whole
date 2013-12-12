/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.eclipse.swt.widgets.Display;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.frames.model.Frame;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class FramesChangeEventHandler extends IdentityChangeEventHandler {
	private static final long serialVersionUID = 1L;
	protected final IEntityPartViewer viewer;

	public FramesChangeEventHandler(IEntityPartViewer viewer) {
		this.viewer = viewer;
	}

	public void resfreshNotation(final IEntity source) {
		FramesUtils.updateSubset(source);

		//TODO test also enablers in VariationPoints

		if (isVariabilityDescendant(source)) {
			Display display = Display.getDefault();
			display.asyncExec(new Runnable() {
				public void run() {
					Frame frame = Matcher.findAncestor(FramesEntityDescriptorEnum.Frame, source);
					//GenericMatcherFactory mf = GenericMatcherFactory.instance;
					//FIXME VariationPoint not working due to Adapters
					Collection<IEntity> c = Matcher.findAll(
							//mf.assignable(FramesEntityDescriptorEnum.VariationPoint),
							new GenericIdentityVisitor() {
								public void visit(IEntity entity) {
									if (!FramesEntityDescriptorEnum.VariationPoint
											.isLanguageSupertypeOf(entity.wGetAdaptee(false).wGetEntityDescriptor()))
										throw new VisitException();
								}
							},
							frame.getContent(),
							new HashSet<IEntity>(), false);

					for (IEntity e : c)
						viewer.rebuildNotation(e);
				}
			});
		}
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
