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
package org.whole.lang.workflows.factories;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class WorkflowsDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		WorkflowsEntityFactory ef = WorkflowsEntityFactory.instance(er);
		
		for (EntityDescriptor<?> ed : er.getEntityDescriptorEnum()) {
			IEntity prototype = er.get(ed);
			if (EntityUtils.isSimple(ed) && !ed.isAbstract()) {//WAS EntityUtils.isImpl(ed)) {
//				if (ed.has(WorkflowsFeatureDescriptorEnum.name)) {
//					Name entityName = ef.createName(ed.name);
//					prototype.wSet(WorkflowsFeatureDescriptorEnum.name, entityName);
//					DefaultValueFactory.setUniqueDefault(entityName);
//				}
				if (ed.has(WorkflowsFeatureDescriptorEnum.label)) {
					Label entityLabel = ef.createText(ed.getName().toLowerCase());
					prototype.wSet(WorkflowsFeatureDescriptorEnum.label, entityLabel);
				}
			}
		}
 	}
}
