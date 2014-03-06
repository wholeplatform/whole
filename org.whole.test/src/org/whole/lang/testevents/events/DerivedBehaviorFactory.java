/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.testevents.events;

import org.whole.lang.events.AbstractDerivationRule;
import org.whole.lang.events.AbstractValidationRule;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.model.ITestEventsEntity;
import org.whole.lang.testevents.model.Labels;
import org.whole.lang.testevents.model.Rectangle;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.testevents.visitors.TestEventsTraverseAllVisitor;

/**
 * @author Riccardo Solmi
 */
public class DerivedBehaviorFactory extends TestEventsTraverseAllVisitor {
	public static final DerivedBehaviorFactory instance = new DerivedBehaviorFactory();
	private DerivedBehaviorFactory() {
	}

	public static void deploy(ITestEventsEntity entity) {
		entity.accept(instance);
	}

	public void visit(Labels entity) {
		entity.wAddRequestEventHandler(new AbstractDerivationRule<Labels>(
				TestEventsFeatureDescriptorEnum.simpleDerived) {
			protected String deriveRequested(Labels entity, String value) {
				return entity.getSimple().wStringValue()+".suffix";
			}
		});
		AbstractValidationRule<Labels> ceh = new AbstractValidationRule<Labels>(
				TestEventsFeatureDescriptorEnum.simple) {
			protected void validateChanged(Labels entity, IEntity newValue) {
				entity.wUnset(TestEventsFeatureDescriptorEnum.simpleDerived);
			}
		};
		entity.wAddChangeEventHandler(ceh);
		entity.getSimple().wAddChangeEventHandler(ceh);

		entity.wAddRequestEventHandler(new AbstractDerivationRule<Labels>(
				TestEventsFeatureDescriptorEnum.simpleDerivedDerived) {
			protected String deriveRequested(Labels entity, String value) {
				return "prefix."+entity.getSimpleDerived().wStringValue();
			}
		});
		entity.wAddChangeEventHandler(new AbstractValidationRule<Labels>(
				TestEventsFeatureDescriptorEnum.simpleDerived) {
			protected void validateChanged(Labels entity, IEntity newValue) {
				entity.wUnset(TestEventsFeatureDescriptorEnum.simpleDerivedDerived);
			}
		});
	}
	
	public void visit(Rectangle entity) {
		entity.wAddRequestEventHandler(new AbstractDerivationRule<Rectangle>(
				TestEventsFeatureDescriptorEnum.area) {
			public int deriveRequested(Rectangle entity, int value) {
				return entity.getBase().wIntValue() * entity.getHeight().wIntValue();
			}
		});

		entity.wAddRequestEventHandler(new AbstractDerivationRule<Rectangle>(
				TestEventsFeatureDescriptorEnum.perimeter) {
			public int deriveRequested(Rectangle entity, int value) {
				return (entity.getBase().wIntValue() + entity.getHeight().wIntValue()) * 2;
			}
		});
	}
}
