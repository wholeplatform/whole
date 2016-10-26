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
package org.whole.lang.java.codebase;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.AbstractGenericPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.java.util.JavaStoreProducerBuilder;
import org.whole.lang.java.util.JavaStoreProducerBuilderOperation;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.StringUtils;

import bsh.Interpreter;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class JavaBuilderPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final JavaBuilderPersistenceKit instance = new JavaBuilderPersistenceKit();
		private static Pattern pattern = Pattern.compile("public\\s+class\\s+([^\\s]+)\\s+extends\\s+AbstractTemplateFactory(<[^<>]+>)?");
	}
	public static JavaBuilderPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	protected JavaBuilderPersistenceKit() {
		super("Java (Whole Builder Persistence)", "java");
	}

	@SuppressWarnings("unchecked")
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		IBindingManager bm = pp.getBindings();
		if (bm.wIsSet("compilationUnitName")) {
			ClassLoader classLoader = ReflectionFactory.getClassLoader(bm);
			Class<?> codebaseClass = classLoader.loadClass(bm.wStringValue("compilationUnitName"));
			if (ITemplateFactory.class.isAssignableFrom(codebaseClass))
				return ((ITemplateFactory<IEntity>) codebaseClass.newInstance()).create();
		}

		byte[] buffer = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length*16);
		BufferedInputStream bis = new BufferedInputStream(pp.getInputStream(), buffer.length);
		int bytesRead;
		while ((bytesRead = bis.read(buffer, 0, buffer.length)) > 0)
			baos.write(buffer, 0, bytesRead);

		Interpreter javaInterpreter = new Interpreter();
		javaInterpreter.setClassLoader(ReflectionFactory.getPlatformClassLoader());

		Object result = javaInterpreter.eval(toBeanShellScript(baos.toString(pp.getEncoding())));
		if (!(result instanceof IEntity))
			throw new IllegalStateException("not a whole model");

		return (IEntity) result;
	}

	public static String toBeanShellScript(String classSource) {
		StringBuilder bshScript = new StringBuilder();
		Matcher matcher = SingletonHolder.pattern.matcher(classSource);
		if (matcher.find()) {
			if (matcher.groupCount() == 2) {
				bshScript.append(classSource.substring(0, matcher.start(2)));
				bshScript.append(classSource.substring(matcher.end(2)));
			} else
				bshScript.append(classSource);
			bshScript.append("new ");
			bshScript.append(matcher.group(1));
			bshScript.append("().create();");
		}
		return bshScript.toString();
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		IBindingManager bm = pp.getBindings();
		if (bm.wIsSet("file")) {
			Object file = bm.wGetValue("file");
			if (file instanceof File)
				bm.wDefValue("className",
						StringUtils.stripFileExtension(((File) file).getName()));
		}
		if (bm.wIsSet("fileName"))//TODO test was !bm.wIsSet("className") && 
			bm.wDefValue("className", bm.wStringValue("fileName"));

		IEntity packageNameEntity = bm.wGet("packageName");
		String packageName = packageNameEntity != null ? packageNameEntity.wStringValue() : null;
		IEntity classNameEntity = bm.wGet("className");
		String className = classNameEntity != null ? bm.wStringValue("className") : "AnonymousClass";

		ModelBuilderOperation op = new ModelBuilderOperation();
		JavaStoreProducerBuilderOperation javaOp = new JavaStoreProducerBuilderOperation(op);
		((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildStartCompilationUnit(
				packageName, className, model.wGetEntityDescriptor().getEntityType().getName());
		new ModelTemplate(model).apply(javaOp);
		((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildEndCompilationUnit();

		IEntity javaModel = op.wGetResult();
		PrettyPrinterOperation.prettyPrint(javaModel, pp.getOutputStream(), pp.getEncoding());
	}
}

