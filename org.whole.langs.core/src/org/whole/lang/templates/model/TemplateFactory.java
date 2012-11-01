package org.whole.lang.templates.model;

/** 
 * @generator Whole
 */
public interface TemplateFactory extends ITemplatesEntity {
	public SimpleName getName();

	public void setName(SimpleName name);

	public Names getForNames();

	public void setForNames(Names forNames);

	public Template getTemplate();

	public void setTemplate(Template template);
}
