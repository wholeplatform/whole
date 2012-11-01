package org.whole.lang.artifacts.reflect;

import org.whole.lang.artifacts.codebase.JavaProject;
import org.whole.lang.artifacts.codebase.JavaProjectTemplate;
import org.whole.lang.artifacts.codebase.WorkspaceTemplate;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
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