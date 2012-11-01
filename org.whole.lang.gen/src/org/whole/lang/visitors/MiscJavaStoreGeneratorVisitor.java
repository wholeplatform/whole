package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.misc.model.IMiscEntity;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.misc.visitors.MiscIdentityVisitor;

/** 
 * @generator Whole
 */
public class MiscJavaStoreGeneratorVisitor extends MiscIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public MiscJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.misc.model.MiscLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(IMiscEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(Misc entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMisc");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(builder.newArrayCreation("Any", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IMiscEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Misc", callExp);
	}

}