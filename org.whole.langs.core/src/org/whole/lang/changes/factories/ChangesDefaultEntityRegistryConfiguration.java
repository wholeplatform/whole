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
package org.whole.lang.changes.factories;

import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;

/**
 * @author Riccardo Solmi
 */
public class ChangesDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration{
	public void apply(IEntityRegistry er) {
		super.apply(er);
		ChangesEntityFactory ef = ChangesEntityFactory.instance(er);

		er.put(ef.createRevisionChanges(0));
		er.put(ef.createChangeSides(0));
		er.put(ef.createChangeRevisions(0));
		er.put(ef.buildRevision().set(ChangesFeatureDescriptorEnum.changes, ef.createRevisionChanges(0)).getResult());		
		er.put(ef.createRevisionChange(ef.createChangeSides(0)));		
		er.put(ef.buildCut().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
		er.put(ef.buildCopy().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
		er.put(ef.buildPaste().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
		er.put(ef.buildInsert().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
		er.put(ef.buildDelete().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
		er.put(ef.buildReplace().set(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0)).getResult());
	}
}
