package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface AddAction extends ISQLEntity, AlterAction {
	public DeclarationOrConstraint getDeclarationOrConstraint();

	public void setDeclarationOrConstraint(DeclarationOrConstraint declarationOrConstraint);
}
