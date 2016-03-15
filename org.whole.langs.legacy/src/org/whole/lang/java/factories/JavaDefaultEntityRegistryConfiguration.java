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
package org.whole.lang.java.factories;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.java.model.EnumConstantDeclaration;
import org.whole.lang.java.model.ForStatement;
import org.whole.lang.java.model.NormalAnnotation;
import org.whole.lang.java.model.SwitchStatement;

public class JavaDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		JavaEntityFactory ef = JavaEntityFactory.instance(er);

		EnumConstantDeclaration enumConstantDeclaration = ef.createEnumConstantDeclaration();
		enumConstantDeclaration.setArguments(ef.createArguments(0));
		er.put(enumConstantDeclaration);

		NormalAnnotation normalAnnotation = ef.createNormalAnnotation();
		normalAnnotation.setValues(ef.createMemberValuePairs(0));
		er.put(normalAnnotation);

		SwitchStatement switchStatement = ef.createSwitchStatement();
		switchStatement.setStatements(ef.createStatements(0));
		er.put(switchStatement);

		ForStatement forStatement = ef.createForStatement();
		forStatement.setInitializers(ef.createExpressions(0));
		forStatement.setUpdaters(ef.createExpressions(0));
		er.put(forStatement);
	}
}
