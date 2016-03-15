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
package org.whole.lang.environment.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.environment.model.Binding;
import org.whole.lang.environment.model.Bindings;
import org.whole.lang.environment.model.IEnvironmentEntity;
import org.whole.lang.environment.model.Value;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class EnvironmentInterpreterVisitor extends EnvironmentIdentityDefaultVisitor {
		@Override
		public void visit(IEnvironmentEntity entity) {
			setResult(EntityUtils.clone(entity));
		}

		@Override
		public void visit(Bindings entity) {
			IBindingManager bm = getBindings();
			IEntity selfEntity = bm.wGet("self");
			for (int i = 0; i < entity.wSize(); i++) {
				Binding binding = entity.get(i);
				binding.accept(this);
//							if (!binding.getName().getValue().equals("self")) {
					if (bm.wGet("self") != selfEntity)
						if (bm.wIsSet("self"))
							bm.wSet("self", selfEntity);
						else
							bm.wDef("self", selfEntity);	
//							}
			}
		}

		@Override
		public void visit(Binding entity) {
			entity.getName().accept(this);
			String name = getResult().wStringValue();
			//TODO test
			if (name.equals("self"))
				name = "self";
			
			entity.getValue().accept(this);
			
			IBindingManager bm = getBindings();
			bm.wDef(name, BehaviorUtils.evaluateResult(bm));
		}

		@Override
		public void visit(Value entity) {
			setResult(entity.getValue());
		}
	}