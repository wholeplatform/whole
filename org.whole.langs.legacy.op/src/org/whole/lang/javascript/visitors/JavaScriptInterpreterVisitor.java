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
package org.whole.lang.javascript.visitors;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.javascript.model.IJavaScriptEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class JavaScriptInterpreterVisitor extends JavaScriptIdentityDefaultVisitor {

	protected InterpreterOperation op() {
		return (InterpreterOperation) getOperation();
	}

	@Override
	public void visit(IJavaScriptEntity entity) {
		final IBindingManager bm = getBindings();
		
		IEntity sourceEntity = entity;
		String sourceString = PrettyPrinterOperation.toPrettyPrintString(sourceEntity);

		boolean useAutoboxing = true;
		do {
			Context context = Context.enter();
			context.setApplicationClassLoader(ReflectionFactory.getClassLoader(bm));
			Scriptable scope = context.initStandardObjects();
			
			try {
				for (String name : bm.wNames()) {
					IEntity valueEntity = bm.wGet(name);
					ScriptableObject.putProperty(scope, name, 
							Context.javaToJS(useAutoboxing && valueEntity != null && EntityUtils.isData(valueEntity) ?
									valueEntity.wGetValue() : valueEntity, scope));
				}
	
				Object result = context.evaluateString(scope, sourceString, "<fragment>", 1, null);

				if (result instanceof IEntity)
					bm.setResult((IEntity) result);
				else if (result != null)
					bm.setResult(BindingManagerFactory.instance.createSpecificValue(result));
				
				for (Object id : scope.getIds()) {
					if (!(id instanceof String))
						continue;
					String name = (String) id;
					Object value = ScriptableObject.getProperty(scope, name);
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
			} catch (Exception e) {
				if (!useAutoboxing)
					throw new VisitException("JavaScript Interpreter failure.", e);
				useAutoboxing = false;
			} finally {
				Context.exit();
			}
		} while (true);
	}
}
