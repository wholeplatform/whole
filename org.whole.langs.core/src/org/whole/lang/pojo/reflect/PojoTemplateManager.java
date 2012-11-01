package org.whole.lang.pojo.reflect;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.codebase.DefinedAnnotationTypes;
import org.whole.lang.pojo.codebase.ECorePojo;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class PojoTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final PojoTemplateManager instance = new PojoTemplateManager();
	}

	public static PojoTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private PojoTemplateManager() {
		put("empty", new AbstractTemplateFactory<Library>() {
			public Library create() {
				return GenericEntityFactory.instance
						.create(PojoEntityDescriptorEnum.Library);
			}
		});
//		put("SampleJavaBean pojo (reveng)", new PojoRevEngTemplateFactory(
//				"SampleJavaBean",
//				"org.whole.lang.processes",
//				ReflectiveUtils.getClass("org.whole.lang.processes.SampleJavaBean"),
//				""
//				));
//		put("BPEL pojo (reveng)", new PojoRevEngTemplateFactory(
//				"BPEL",
//				"org.eclipse.bpel.model",
//				ReflectiveUtils.getClasses(
//						"C:/Java/eclipse-workspace-rc7/org.eclipse.bpel.model/src/org/eclipse/bpel/model",
//						"org.eclipse.bpel.model",
//						"BPELFactory,BPELPackage,BPELPlugin,ElementType"),
//				"EObject"
//				));
//		put("ECore pojo (reveng)", new PojoRevEngTemplateFactory(
//				"ECore",
//				"org.eclipse.emf.ecore",
//				ReflectiveUtils.getClasses(
//						"C:/Java/eclipse-workspace-rc7/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore",
//						"org.eclipse.emf.ecore",
//						""),
//				""
//				));
		put("ECore pojo", new ECorePojo());

		put("Defined Annotation Types", new DefinedAnnotationTypes());
	}
}