package org.whole.lang.rdb.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class RDBIdentitySwitchVisitor extends AbstractVisitor
		implements IRDBVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case RDBEntityDescriptorEnum.Database_ord:
			visit((Database) entity);
			break;
		case RDBEntityDescriptorEnum.Schemas_ord:
			visit((Schemas) entity);
			break;
		case RDBEntityDescriptorEnum.Schema_ord:
			visit((Schema) entity);
			break;
		case RDBEntityDescriptorEnum.Tables_ord:
			visit((Tables) entity);
			break;
		case RDBEntityDescriptorEnum.Table_ord:
			visit((Table) entity);
			break;
		case RDBEntityDescriptorEnum.Columns_ord:
			visit((Columns) entity);
			break;
		case RDBEntityDescriptorEnum.Column_ord:
			visit((Column) entity);
			break;
		case RDBEntityDescriptorEnum.PrimaryKey_ord:
			visit((PrimaryKey) entity);
			break;
		case RDBEntityDescriptorEnum.ColumnNames_ord:
			visit((ColumnNames) entity);
			break;
		case RDBEntityDescriptorEnum.ForeignKeys_ord:
			visit((ForeignKeys) entity);
			break;
		case RDBEntityDescriptorEnum.ForeignKey_ord:
			visit((ForeignKey) entity);
			break;
		case RDBEntityDescriptorEnum.ColumnReferences_ord:
			visit((ColumnReferences) entity);
			break;
		case RDBEntityDescriptorEnum.ColumnReference_ord:
			visit((ColumnReference) entity);
			break;
		case RDBEntityDescriptorEnum.Indices_ord:
			visit((Indices) entity);
			break;
		case RDBEntityDescriptorEnum.Index_ord:
			visit((Index) entity);
			break;
		case RDBEntityDescriptorEnum.ColumnIndices_ord:
			visit((ColumnIndices) entity);
			break;
		case RDBEntityDescriptorEnum.ColumnIndex_ord:
			visit((ColumnIndex) entity);
			break;
		case RDBEntityDescriptorEnum.Type_ord:
			visit((Type) entity);
			break;
		case RDBEntityDescriptorEnum.IndexType_ord:
			visit((IndexType) entity);
			break;
		case RDBEntityDescriptorEnum.Order_ord:
			visit((Order) entity);
			break;
		case RDBEntityDescriptorEnum.IdMethod_ord:
			visit((IdMethod) entity);
			break;
		case RDBEntityDescriptorEnum.Action_ord:
			visit((Action) entity);
			break;
		case RDBEntityDescriptorEnum.Deferrability_ord:
			visit((Deferrability) entity);
			break;
		case RDBEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		case RDBEntityDescriptorEnum.Namespace_ord:
			visit((Namespace) entity);
			break;
		case RDBEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case RDBEntityDescriptorEnum.StringData_ord:
			visit((StringData) entity);
			break;
		case RDBEntityDescriptorEnum.IntData_ord:
			visit((IntData) entity);
			break;
		case RDBEntityDescriptorEnum.BooleanData_ord:
			visit((BooleanData) entity);
			break;
		}
	}
}
