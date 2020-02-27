/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ChooseByTypeURIEvaluator extends AbstractDelegatingNestedEvaluator {
	private Map<String, Integer> casesMap = new HashMap<>();

	public ChooseByTypeURIEvaluator(int casesSize) {
		super(casesSize+1);
		producers[producersSize()-1] = executableFactory().createEmpty();
	}

	public void setCase(String typeUri, IExecutable executable) {
		int producerIndex = casesMap.size();
		casesMap.put(typeUri, producerIndex);
		producers[producerIndex] = executable;
	}
	public void setDefaultCase(IExecutable executable) {
		producers[producersSize()-1] = executable;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		String typeUri = entity.wGetEntityDescriptor().getURI();
		producerIndex = casesMap.getOrDefault(typeUri, producersSize()-1);
	}

	public IEntity evaluateNext() {
		return lastEntity = getProducer().evaluateNext();
	}

	public IEntity evaluateRemaining() {
		return lastEntity = getProducer().evaluateRemaining();
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(toStringPrefix());

		for (Map.Entry<String, Integer> entry : casesMap.entrySet()) {
			sb.append(entry.getKey());
			sb.append(": ");
			producers[entry.getValue()].toString(sb);

			sb.append(toStringSeparator());
		}
		sb.append("...: ");
		producers[producersSize()-1].toString(sb);

    	sb.append(toStringSuffix());
    }
    @Override
	protected String toStringPrefix() {
		return "chooseByTypeUri(";
	}
    @Override
	protected String toStringSeparator() {
		return ",\n";
	}
}

