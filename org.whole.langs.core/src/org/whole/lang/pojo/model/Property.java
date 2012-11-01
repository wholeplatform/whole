package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface Property extends IPojoEntity {
	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);

	public Type getType();

	public void setType(Type type);

	public Name getName();

	public void setName(Name name);

	public Name getTemplate();

	public void setTemplate(Name template);
}
