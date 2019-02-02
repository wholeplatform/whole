/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.artifacts.reflect;

import org.whole.lang.artifacts.codebase.JavaProject;
import org.whole.lang.artifacts.codebase.JavaProjectTemplate;
import org.whole.lang.artifacts.codebase.WorkspaceTemplate;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/**
 *  @generator Whole
 */
public class ArtifactsTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final ArtifactsTemplateManager instance = new ArtifactsTemplateManager();
    }

    public static ArtifactsTemplateManager instance() {
        return SingletonHolder.instance;
    }

	private ArtifactsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Workspace>() {
			public Workspace create() {
				return GenericEntityFactory.instance
						.create(ArtifactsEntityDescriptorEnum.Workspace);
			}
		});
		put("java project", new JavaProject());
		put("java project template", new JavaProjectTemplate());
		put("workspace template", new WorkspaceTemplate());
	}
}