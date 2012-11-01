package org.whole.lang.rdb.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.rdb.model.TypeEnum;
import org.whole.lang.rdb.model.IndexTypeEnum;
import org.whole.lang.rdb.model.OrderEnum;
import org.whole.lang.rdb.model.IdMethodEnum;
import org.whole.lang.rdb.model.ActionEnum;
import org.whole.lang.rdb.model.DeferrabilityEnum;

/** 
 * @generator Whole
 */
public interface IRDBBuilder extends IBuilder {
	public void visit();

	public void order();

	public void columnIndices();

	public void unique();

	public void qualifier();

	public void target();

	public void source();

	public void columnReferences();

	public void deferrability();

	public void deleteAction();

	public void updateAction();

	public void targetTable();

	public void columnNames();

	public void idMethod();

	public void defaultValue();

	public void nullable();

	public void decimals();

	public void size();

	public void type();

	public void featureType();

	public void featureName();

	public void remarks();

	public void indices();

	public void foreignKeys();

	public void primaryKey();

	public void columns();

	public void entityName();

	public void tables();

	public void modelName();

	public void name();

	public void schemas();

	public void namespace();

	public void uri();

	public void Database();

	public void Database_();

	public void _Database();

	public void Schemas();

	public void Schemas_();

	public void Schemas_(int initialCapacity);

	public void _Schemas();

	public void Schema();

	public void Schema_();

	public void _Schema();

	public void Tables();

	public void Tables_();

	public void Tables_(int initialCapacity);

	public void _Tables();

	public void Table();

	public void Table_();

	public void _Table();

	public void Columns();

	public void Columns_();

	public void Columns_(int initialCapacity);

	public void _Columns();

	public void Column();

	public void Column_();

	public void _Column();

	public void PrimaryKey();

	public void PrimaryKey_();

	public void _PrimaryKey();

	public void ColumnNames();

	public void ColumnNames_();

	public void ColumnNames_(int initialCapacity);

	public void _ColumnNames();

	public void ForeignKeys();

	public void ForeignKeys_();

	public void ForeignKeys_(int initialCapacity);

	public void _ForeignKeys();

	public void ForeignKey();

	public void ForeignKey_();

	public void _ForeignKey();

	public void ColumnReferences();

	public void ColumnReferences_();

	public void ColumnReferences_(int initialCapacity);

	public void _ColumnReferences();

	public void ColumnReference();

	public void ColumnReference_();

	public void _ColumnReference();

	public void Indices();

	public void Indices_();

	public void Indices_(int initialCapacity);

	public void _Indices();

	public void Index();

	public void Index_();

	public void _Index();

	public void ColumnIndices();

	public void ColumnIndices_();

	public void ColumnIndices_(int initialCapacity);

	public void _ColumnIndices();

	public void ColumnIndex();

	public void ColumnIndex_();

	public void _ColumnIndex();

	public void Type();

	public void Type(TypeEnum.Value value);

	public void Type(String value);

	public void IndexType();

	public void IndexType(IndexTypeEnum.Value value);

	public void IndexType(String value);

	public void Order();

	public void Order(OrderEnum.Value value);

	public void Order(String value);

	public void IdMethod();

	public void IdMethod(IdMethodEnum.Value value);

	public void IdMethod(String value);

	public void Action();

	public void Action(ActionEnum.Value value);

	public void Action(String value);

	public void Deferrability();

	public void Deferrability(DeferrabilityEnum.Value value);

	public void Deferrability(String value);

	public void URI();

	public void URI(String value);

	public void Namespace();

	public void Namespace(String value);

	public void Name();

	public void Name(String value);

	public void StringData();

	public void StringData(String value);

	public void IntData();

	public void IntData(int value);

	public void BooleanData();

	public void BooleanData(boolean value);
}
