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
package org.whole.lang.evaluators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class ChooseByTypeEvaluator extends AbstractDelegatingNestedEvaluator {
	private ILanguageKit languageKit;

	public ChooseByTypeEvaluator(ILanguageKit languageKit) {
		super(new IExecutable[languageKit.getEntityDescriptorEnum().size()+1]);
		this.languageKit = languageKit;

		for (int i = 0; i < producersSize()-1; i++) {
			producers[i] = executableFactory().createConstant(BindingManagerFactory.instance.createVoid(), true);
		}
		producers[producersSize()-1] = executableFactory().createEmpty();
	}

	public void setCase(EntityDescriptor<?> ed, IExecutable executable) {
		if (!ed.getLanguageKit().equals(languageKit))
			throw new IllegalArgumentException();

		producers[ed.getOrdinal()] = executable;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		producerIndex = entity.wGetLanguageKit().equals(languageKit) ? entity.wGetEntityOrd() : languageKit.getEntityDescriptorEnum().size();
	}

	public IEntity evaluateNext() {
		return lastEntity = getProducer().evaluateNext();
	}

	public IEntity evaluateRemaining() {
		return lastEntity = getProducer().evaluateRemaining();
	}

    @Override
	protected String toStringPrefix() {
		return "chooseByType(";
	}
    @Override
	protected String toStringSeparator() {
		return ",\n";
	}
}

