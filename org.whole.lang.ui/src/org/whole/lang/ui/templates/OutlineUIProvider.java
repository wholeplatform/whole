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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.editor.IGEFEditorKit;

/**
 * @author Riccardo Solmi
 */
public class OutlineUIProvider implements IOutlineUIProvider {
	private static final OutlineUIProvider instance = new OutlineUIProvider();
	public static OutlineUIProvider instance() {
		return instance;
	}
	private OutlineUIProvider() {
	}

	protected Map<String, IOutlineUIProvider[]> idPartDataMap = new HashMap<String, IOutlineUIProvider[]>();

	public OutlineKinds getTemplateKind(IEntity entity) {
		return getPartDataProvider(entity).getTemplateKind(entity);
	}

	public boolean startOpened(IEntity entity) {
		return getPartDataProvider(entity).startOpened(entity);
	}

	public Image getImage(IEntity entity) {
		return getPartDataProvider(entity).getImage(entity);
	}

	public String getText(IEntity entity) {
		String text = getPartDataProvider(entity).getText(entity);
		if (text != null)
			return text;

		return DefaultOutlineUIProvider.instance.getText(entity);
	}

	public FeatureDescriptor[] getFeatures(IEntity entity) {
		return getPartDataProvider(entity).getFeatures(entity);
	}

	public IOutlineUIProvider getPartDataProvider(IEntity entity) {
		ILanguageKit languageKit = entity.wGetLanguageKit();
		IUITemplate pt = ((IGEFEditorKit) entity.wGetEditorKit()).getUITemplate(languageKit);
		String id = pt.getId();
		IOutlineUIProvider[] data = idPartDataMap.get(id);
		
		if (data == null) {
			EntityDescriptorEnum types = languageKit.getEntityDescriptorEnum();
			int size = types.size();
			idPartDataMap.put(id, data = new IOutlineUIProvider[size]);

			for (int i=0; i<data.length; i++)
				data[i] = DefaultOutlineUIProvider.instance;
			
			pt.applyOutline(createOutlineBuilder(data));
		}
		
		int entityOrd = entity.wGetEntityOrd();
		if (data.length <= entityOrd)
			return DefaultOutlineUIProvider.instance;

		return data[entityOrd];
	}
	protected static IOutlineBuilder createOutlineBuilder(final IOutlineUIProvider[] data) {
		return new IOutlineBuilder() {
			public void Template(EntityDescriptor<?> ed, String label, ImageDescriptor iconSmall,
					OutlineKinds kind, boolean startOpened, FeatureDescriptor... featureDescriptors) {
				
				data[ed.getOrdinal()] = new OutlinePartDataProvider(kind, startOpened, label,
						iconSmall == null ? null : iconSmall.createImage(), featureDescriptors);
			}
			public void Template(EntityDescriptor<?> ed, ImageDescriptor iconSmall,
					OutlineKinds kind, boolean startOpened, FeatureDescriptor... featureDescriptors) {
				
				Template(ed, null, iconSmall, kind, startOpened, featureDescriptors);
			}
		};
	}
}
