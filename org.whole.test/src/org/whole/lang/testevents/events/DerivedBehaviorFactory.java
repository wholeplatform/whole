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
package org.whole.lang.testevents.events;

import org.whole.lang.events.AbstractEntityDerivationRule;
import org.whole.lang.events.DerivationContext;
import org.whole.lang.events.RequestException;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testevents.factories.TestEventsEntityFactory;
import org.whole.lang.testevents.model.ITestEventsEntity;
import org.whole.lang.testevents.model.Labels;
import org.whole.lang.testevents.model.Rectangle;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class DerivedBehaviorFactory extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addReactionsHandler(TestEventsLanguageKit.URI, createDerivationContext());
	}

	public static void deploy(ITestEventsEntity entity) {
		DerivationContext dc = createDerivationContext();
		ICompoundModel model = entity.wGetModel().getCompoundModel();
		model.addRequestEventHandler(dc);
		model.addChangeEventHandler(dc);
	}

	public static DerivationContext createDerivationContext() {
		DerivationContext dc = new DerivationContext();

		dc.addDerivationRules(
				TestEventsEntityDescriptorEnum.Rectangle,
				new AbstractEntityDerivationRule<Rectangle>() {
					public IEntity derive(Rectangle entity, FeatureDescriptor fd, IEntity value) {
						switch (fd.getOrdinal()) {
						
						case TestEventsFeatureDescriptorEnum.base_ord:
							try {
								return TestEventsEntityFactory.instance.createVal(
										entity.getPerimeter().wIntValue() / 2 - entity.getHeight().wIntValue());
							} catch (Exception e) {
							}
							try {
								return TestEventsEntityFactory.instance.createVal(
										entity.getArea().wIntValue() / entity.getHeight().wIntValue());
							} catch (ArithmeticException e) {
								throw new RequestException();
							}

						case TestEventsFeatureDescriptorEnum.height_ord:
							try {
								return TestEventsEntityFactory.instance.createVal(
										entity.getPerimeter().wIntValue() / 2 - entity.getBase().wIntValue());
							} catch (Exception e) {
							}
							try {
								return TestEventsEntityFactory.instance.createVal(
										entity.getArea().wIntValue() / entity.getBase().wIntValue());
							} catch (ArithmeticException e) {
								throw new RequestException();
							}

						case TestEventsFeatureDescriptorEnum.area_ord:
							return TestEventsEntityFactory.instance.createVal(
									entity.getBase().wIntValue() * entity.getHeight().wIntValue());

						case TestEventsFeatureDescriptorEnum.perimeter_ord:
							return TestEventsEntityFactory.instance.createVal(
									(entity.getBase().wIntValue() + entity.getHeight().wIntValue()) * 2);
						
						default:
							return value;
						}
					}
					public void invalidate(Labels entity, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
//						switch (fd.getOrdinal()) {
//						
//						case TestEventsFeatureDescriptorEnum.base_ord:
//						case TestEventsFeatureDescriptorEnum.height_ord:
//							entity.wRemove(TestEventsFeatureDescriptorEnum.area);
//							entity.wRemove(TestEventsFeatureDescriptorEnum.perimeter);
//							break;
//						}
					}
				});
		dc.addDerivationRules(
				TestEventsEntityDescriptorEnum.Labels,
				new AbstractEntityDerivationRule<Labels>() {
					public IEntity derive(Labels entity, FeatureDescriptor fd, IEntity value) {
						switch (fd.getOrdinal()) {
						
						case TestEventsFeatureDescriptorEnum.simpleDerived_ord:
							return TestEventsEntityFactory.instance.createLabel(
									entity.getSimple().wStringValue()+".suffix");

						case TestEventsFeatureDescriptorEnum.simpleDerivedDerived_ord:
							return TestEventsEntityFactory.instance.createLabel(
									"prefix."+entity.getSimpleDerived().wStringValue());

						default:
							return value;
						}
					}
					public void invalidate(Labels entity, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
						switch (fd.getOrdinal()) {
						
						case TestEventsFeatureDescriptorEnum.simple_ord:
							//FIXME initialization rule remove only if derived
							entity.wRemove(TestEventsFeatureDescriptorEnum.simpleDerived);
							break;

						case TestEventsFeatureDescriptorEnum.simpleDerived_ord:
							entity.wRemove(TestEventsFeatureDescriptorEnum.simpleDerivedDerived);
							break;
						}
					}
				});

		return dc;
	}
}
