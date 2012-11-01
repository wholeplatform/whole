package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Annotation extends IXsdEntity, SchemaDirective,
		SchemaComponent, RedefineComponent {
	public AnnotationList getList();

	public void setList(AnnotationList list);
}
