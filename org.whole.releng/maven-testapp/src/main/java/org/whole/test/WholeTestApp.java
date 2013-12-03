package org.whole.test;

/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;

/**
 * @author Enrico Persiani
 */
public class WholeTestApp {
	public static void main( String[] args ) {
		// deploy the platform
		ReflectionFactory.deployWholePlatform();

		// map the artifacts model to a schema and pretty print it
		Model artifactsModel = (Model) new ArtifactsModel().create();
		PathExpression path = new ModelToXmlSchemaQuery().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		IEntity artifactsSchema = BehaviorUtils.evaluateFirstResult(path, artifactsModel, bm);
		PrettyPrinterOperation.prettyPrint(artifactsSchema);

		IEntityIterator<?> iterator = IteratorFactory.childIterator();
		iterator.reset(artifactsModel.getDeclarations());
		while (iterator.hasNext()) {
			IEntity entity = (IEntity) iterator.next();
			PrettyPrinterOperation.prettyPrint(entity);
		}
	}
}

