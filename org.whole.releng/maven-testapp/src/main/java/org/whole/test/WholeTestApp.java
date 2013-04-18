package org.whole.test;

import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.util.QueriesUtils;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.models.model.Model;

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
		
		IEntityIterator iterator = IteratorFactory.childIterator();
		iterator.reset(artifactsModel.getDeclarations());
		while (iterator.hasNext()) {
			IEntity entity = (IEntity) iterator.next();
			PrettyPrinterOperation.prettyPrint(entity);
		}
	}
}

