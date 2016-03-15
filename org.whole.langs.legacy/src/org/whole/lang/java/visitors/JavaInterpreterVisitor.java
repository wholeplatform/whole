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
package org.whole.lang.java.visitors;

import java.io.PrintStream;
import java.io.Reader;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.java.model.IJavaEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WriterOutputStream;
import org.whole.lang.visitors.VisitException;

import bsh.ConsoleInterface;
import bsh.EvalError;
import bsh.Interpreter;

/**
 * @author Riccardo Solmi
 */
public class JavaInterpreterVisitor extends JavaIdentityDefaultVisitor implements ConsoleInterface {
	protected final InterpreterOperation op() {
		return (InterpreterOperation) getOperation();
	}

	@Override
	public void visit(IJavaEntity entity) {
		final IBindingManager bm = getBindings();

		/*
		 * TODO
		 * for each nested lower level fragment:
		 *   evaluate and replace the fragment with the result
		 * for each nested upper level fragment:
		 *   build the template and bind it to a fresh name
		 *   replace the fragment with the name
		 */
		IEntity sourceEntity = entity;

		String sourceString = PrettyPrinterOperation.toPrettyPrintString(sourceEntity);

		Interpreter javaInterpreter = new Interpreter();
		javaInterpreter.setClassLoader(ReflectionFactory.getClassLoader(bm));
		javaInterpreter.setConsole(this);

		boolean useAutoboxing = true;
		do {
			try {
				for (String name : bm.wNames()) {
					IEntity valueEntity = bm.wGet(name);
					if (useAutoboxing && valueEntity != null && EntityUtils.isData(valueEntity))
						javaInterpreter.set(name, valueEntity.wGetValue());
					else
						javaInterpreter.set(name, valueEntity);
				}

				Object result = javaInterpreter.eval(sourceString);

				if (result instanceof IEntity)
					bm.setResult((IEntity) result);
				else if (result != null)
					bm.setResult(BindingManagerFactory.instance.createSpecificValue(result));

				for (String name : javaInterpreter.getNameSpace().getVariableNames()) {
					if ("bsh".equals(name))
						continue;
					Object value = javaInterpreter.get(name);
					if (bm.wIsSet(name)) {
						IEntity valueEntity = bm.wGet(name);
						if (useAutoboxing && valueEntity != null && EntityUtils.isData(valueEntity))
							valueEntity.wSetValue(value);
						else if (value != valueEntity)
							bm.wSet(name, (IEntity) value);
					} else if (value instanceof IEntity)
						bm.wDef(name, (IEntity) value);
					else
						bm.wDef(name, BindingManagerFactory.instance.createSpecificValue(value));
				}
				return;
			} catch (EvalError e) {
				if (!useAutoboxing)
					throw new VisitException("Java Interpreter failure.", e);
				useAutoboxing = false;
			}
		} while (true);
	}

	public Reader getIn() {
		return op().getReader();
	}
	public PrintStream getOut() {
		return getPrintStream();
	}
	public PrintStream getErr() {
		return getPrintStream();
	}
	public void print(Object o) {
		getOut().print(o);
	}
	public void println(Object o) {
		getOut().println(o);
	}
	public void error(Object o) {
		getErr().print(o);
	}

	private PrintStream out;
	private PrintStream getPrintStream() {
		if (out == null)
			out = new PrintStream(new WriterOutputStream(op().getPrintWriter()));
		return out;
	}
}
