package org.whole.lang.firstorderlogic.reflect;

import org.whole.lang.firstorderlogic.codebase.RDFTheory;
import org.whole.lang.firstorderlogic.codebase.Rdf2TmTheory;
import org.whole.lang.firstorderlogic.codebase.TopicMapsTheory;
import org.whole.lang.firstorderlogic.model.Theory;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class FirstOrderLogicTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final FirstOrderLogicTemplateManager instance = new FirstOrderLogicTemplateManager();
	}

	public static FirstOrderLogicTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private FirstOrderLogicTemplateManager() {
		put("empty", new AbstractTemplateFactory<Theory>() {
			public Theory create() {
				return GenericEntityFactory.instance
						.create(FirstOrderLogicEntityDescriptorEnum.Theory);
			}
		});
		
		put("RDF theory", new RDFTheory());
		put("TopicMaps theory", new TopicMapsTheory());
		put("RDF 2 TopicMaps theory", new Rdf2TmTheory());
	}
}