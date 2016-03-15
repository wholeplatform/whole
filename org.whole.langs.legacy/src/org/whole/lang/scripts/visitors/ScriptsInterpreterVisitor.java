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
package org.whole.lang.scripts.visitors;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.io.PrintWriter;
import java.io.Writer;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.scripts.bindings.BindingsAdapter;
import org.whole.lang.scripts.model.IScriptsEntity;
import org.whole.lang.scripts.model.LanguageName;
import org.whole.lang.scripts.model.Script;
import org.whole.lang.scripts.model.Source;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class ScriptsInterpreterVisitor extends ScriptsIdentityDefaultVisitor {

	protected InterpreterOperation op() {
		return (InterpreterOperation) getOperation();
	}

	@Override
	public void visit(IScriptsEntity entity) {
		Script s = Matcher.findAncestor(ScriptsEntityDescriptorEnum.Script, entity);
		if (s != null)
			visit(s);

		throw new VisitException();
	}

	@Override
	public void visit(Script entity) {
		Writer outputWriter = op().getWriter();
		IBindingManager bm = getBindings();
		BindingsAdapter bindingsAdapter = new BindingsAdapter(bm, true);

		LanguageName languageName = entity.getLanguageName();

		/*
		 * TODO
		 * if contains an upper level fragment fail
		 */

		Source source = entity.getSource();
		IEntity sourceRoot = EntityUtils.isFragment(source) ? source.wGetRoot() : source;
		IEntity result0 = bm.getResult();
		IVisitor ov = op().setVisitor(sourceRoot, 0, op().getVisitor(sourceRoot, 1));
		op().stagedVisit(source);
		
		IEntity sourceModel = bm.getResult();
		
		//workaround restore previous value (also for self and queryIterator?)
		bm.setResult(result0);
		
		op().setVisitor(sourceRoot, 0, ov);

		String sourceString = toPrettyPrintString(sourceModel);

		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(languageName.getValue());
		if (scriptEngine == null)
			throw new VisitException("Cannot find an interpreter for the language: "+languageName);

		scriptEngine.setBindings(bindingsAdapter, ScriptContext.ENGINE_SCOPE);
		PrintWriter printWriter = new PrintWriter(outputWriter);
		scriptEngine.getContext().setWriter(printWriter);
		scriptEngine.getContext().setErrorWriter(printWriter);

		Object result = null;
		bm.wEnterScope();
		do {
			try {
				result = scriptEngine.eval(sourceString);
				break;
			} catch (ScriptException e) {
				bm.wExitScope();
				if (!bindingsAdapter.isAutoboxing())
					throw new VisitException("Script Interpreter failure.", e);
				bindingsAdapter.setAutoboxing(false);
				bm.wEnterScope();
			}
		} while (true);
		bm.wExitScope(true);

		if (result instanceof IEntity)
			bm.setResult((IEntity) result);
		else if (result != null)
			bm.setResult(BindingManagerFactory.instance.createSpecificValue(result));
	}
}
