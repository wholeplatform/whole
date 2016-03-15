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
package org.whole.lang.changes.util;

import org.whole.lang.changes.factories.ChangesEntityFactory;
import org.whole.lang.changes.model.ChangeSide;
import org.whole.lang.changes.model.Revision;
import org.whole.lang.changes.model.RevisionChange;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ChangesUtils {
	public static void linkRevisionToChanges(RevisionChange revisionChange, ChangeSide leftSide, ChangeSide rightSide) {
		ChangesEntityFactory ef = ChangesEntityFactory.instance;
		revisionChange.setSides(ef.createChangeSides(0));
		leftSide.wSet(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0));
		rightSide.wSet(ChangesFeatureDescriptorEnum.revisions, ef.createChangeRevisions(0));

		revisionChange.getSides().add(leftSide);
		revisionChange.getSides().add(rightSide);
	}

	public static void linkRevisionToChanges(Revision revision, ChangeSide leftSide, ChangeSide rightSide) {
		ChangesEntityFactory ef = ChangesEntityFactory.instance;
		
		if (EntityUtils.isResolver(revision.getChanges()))
			revision.setChanges(ef.createRevisionChanges(0));
		if (EntityUtils.isResolver(leftSide.getRevisions()))
			leftSide.setRevisions(ef.createChangeRevisions(0));
		if (EntityUtils.isResolver(rightSide.getRevisions()))
			rightSide.setRevisions(ef.createChangeRevisions(0));

		RevisionChange revisionChange = ef.createRevisionChange(ef.createChangeSides(0));
		revision.getChanges().add(revisionChange);
		revisionChange.getSides().add(leftSide);
		revisionChange.getSides().add(rightSide);
	}
}
