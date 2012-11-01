package org.whole.lang.unifiedlambdadelta.model;

/** 
 * @generator Whole
 */
public interface BinaryContextBinder extends IUnifiedLambdaDeltaEntity,
		BinaryItem, Context, Binder {
	public Context getBack();

	public void setBack(Context back);
}
