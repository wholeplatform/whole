package org.whole.lang.editors.reflect;

import org.whole.lang.editors.codebase.FirstOrderLogicTextualEditor;
import org.whole.lang.editors.codebase.PojoTextualEditor;
import org.whole.lang.editors.codebase.PropertiesTextualEditor;
import org.whole.lang.editors.codebase.TemplatesTextualEditor;
import org.whole.lang.editors.codebase.TestsTextualEditor;
import org.whole.lang.editors.codebase.UnifiedLambdaDeltaTextualEditor;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class EditorsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final EditorsTemplateManager instance = new EditorsTemplateManager();
	}

	public static EditorsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private EditorsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Editor>() {
			public Editor create() {
				return GenericEntityFactory.instance
						.create(EditorsEntityDescriptorEnum.Editor);
			}
		});
		put("First Order Logic Textual Editor", new FirstOrderLogicTextualEditor());
		put("Templates Textual Editor", new TemplatesTextualEditor());
		put("Pojo Textual Editor", new PojoTextualEditor());
		put("Properties Textual Editor", new PropertiesTextualEditor());
		put("Unified Lambda Delta Text Editor", new UnifiedLambdaDeltaTextualEditor());
		put("Tests Text Editor", new TestsTextualEditor());
	}
}
