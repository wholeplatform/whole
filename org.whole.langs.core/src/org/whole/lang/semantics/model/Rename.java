package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface Rename extends ISemanticsEntity {
	public LocalIdentifier getNewIdentifier();

	public void setNewIdentifier(LocalIdentifier newIdentifier);

	public LocalIdentifier getOldIdentifier();

	public void setOldIdentifier(LocalIdentifier oldIdentifier);
}
