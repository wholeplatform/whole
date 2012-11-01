package org.whole.lang.text.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.text.model.Document;
import org.whole.lang.text.factories.TextEntityFactory;

/** 
 * @generator Whole
 */
public class TextTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TextTemplateManager instance = new TextTemplateManager();
	}

	public static TextTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TextTemplateManager() {
		put("empty", new AbstractTemplateFactory<Document>() {
			public Document create() {
				return TextEntityFactory.instance.createDocument(
						TextEntityFactory.instance.createRow(
								TextEntityFactory.instance.createText("text")));
			}
		});
	}
}