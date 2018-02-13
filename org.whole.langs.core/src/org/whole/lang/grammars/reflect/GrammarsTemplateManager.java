package org.whole.lang.grammars.reflect;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.grammars.codebase.DtdGrammar;
import org.whole.lang.grammars.codebase.MediaWikiGrammar;
import org.whole.lang.grammars.codebase.ObjectiveCGrammar;
import org.whole.lang.grammars.codebase.QueriesGrammar;
import org.whole.lang.grammars.codebase.XmlGrammar;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class GrammarsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final GrammarsTemplateManager instance = new GrammarsTemplateManager();
	}

	public static GrammarsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private GrammarsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Grammar>() {
			public Grammar create() {
				return GenericEntityFactory.instance
						.create(GrammarsEntityDescriptorEnum.Grammar);
			}
		});
		put("XML grammar", new XmlGrammar());
		put("Queries grammar", new QueriesGrammar());
		put("DTD grammar", new DtdGrammar());
		put("Objective C grammar", new ObjectiveCGrammar());
		put("MediaWiki grammar", new MediaWikiGrammar());
	}
}
