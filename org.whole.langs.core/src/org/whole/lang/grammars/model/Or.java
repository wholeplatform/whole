package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Or extends IGrammarsEntity, Predicate {
	public Predicate getPredicate1();

	public void setPredicate1(Predicate predicate1);

	public Predicate getPredicate2();

	public void setPredicate2(Predicate predicate2);
}
