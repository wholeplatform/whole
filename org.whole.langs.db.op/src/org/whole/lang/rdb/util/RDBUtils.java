package org.whole.lang.rdb.util;

import java.sql.Connection;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.rdb.model.Table;
import org.whole.lang.reflect.FeatureDescriptor;

public class RDBUtils {

	public Table findTable(Database db, IEntity entityToBeSaved) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		bm.wSet("entity", entityToBeSaved);
		return null;//(Table) QueriesUtils.find((PathExpression) RDBUtilsTemplateManager.instance().create("tableByEntity"), db, bm);
	}

	public void update(Connection connection, Database db, IEntity entityToBeSaved) {
		Table table = findTable(db, entityToBeSaved);
	}
	public void insert(Connection connection, Database db, IEntity entityToBeSaved) {
	}

	public void save(Connection connection, Database db, IEntity entityToBeSaved) {
		try {
			update(connection, db, entityToBeSaved);
		} catch (Exception e) {
			insert(connection, db, entityToBeSaved);
		}
	}

	public IEntity load(Connection connection, Database db, IEntity entityKey) {
		return null;
	}

	public IEntity load(Connection connection, Database db, IEntity entityKey, FeatureDescriptor fd) { // risolve le foreignKey
		return null;
	}

	public IEntity load(Connection connection, Database db, IEntity entityKey, int index) { // come sopra
		return null;
	}

	public IEntity load(Connection connection, Database db, String tableName, Object... keyValues) {
		return null;
	}
}
