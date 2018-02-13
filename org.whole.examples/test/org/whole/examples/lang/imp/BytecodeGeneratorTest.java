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
package org.whole.examples.lang.imp;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.examples.lang.imp.builders.IImpBuilder;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.reflect.ImpLanguageDeployer;
import org.whole.examples.lang.imp.reflect.ImpLanguageKit;
import org.whole.examples.lang.imp.visitors.BytecodeGeneratorOperation;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @author Riccardo Solmi
 */
public class BytecodeGeneratorTest {
	@BeforeClass
	public static void init() {
		ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(ImpLanguageDeployer.class);
	}

	public void classtest() {
		System.out.println(3+5);
	}

	@Test
	public void testASM() throws ClassNotFoundException {
		IEntity program = new ExampleTest().create();
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		final byte[] code = BytecodeGeneratorOperation.compile(program, args);

		ReflectionFactory.setUserClassLoader(new ClassLoader() {
			@Override
			protected Class<?> findClass(String name) throws ClassNotFoundException {
				if ("Example".equals(name))
					return defineClass("Example", code, 0, code.length);

				throw new ClassNotFoundException("Unable to find class: "+name);
			}
		});
		Class<?> exampleClass = ReflectionFactory.getPlatformClassLoader().loadClass("Example");

		try {
			Method main = exampleClass.getMethod("test", new Class[0]);
			main.invoke(exampleClass.newInstance(), new Object[0]);
		} catch (Exception e) {
			fail();
		}

	}

	public static class ExampleTest extends AbstractTemplateFactory<FunctionDeclaration> {
		public void apply(IBuilderOperation op) {
			IImpBuilder b0 = (IImpBuilder) op.wGetBuilder(ImpLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
			b0.FunctionDeclaration_();
			b0.PrimitiveType("void");
			b0.Name("test");
			cb.Resolver();
			b0.BlockStatement_(1);
			b0.PrintlnStatement_();
			b0.Addition_();
			b0.IntLiteral(3);
			b0.IntLiteral(5);
			b0._Addition();
			b0._PrintlnStatement();
			b0._BlockStatement();
			b0._FunctionDeclaration();
		}
	}
}
