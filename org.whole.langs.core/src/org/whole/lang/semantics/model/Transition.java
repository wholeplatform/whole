package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface Transition extends ISemanticsEntity, Premise,
		ConfigurationOrTransition {
	public Configuration getSourceConfiguration();

	public void setSourceConfiguration(Configuration sourceConfiguration);

	public ConfigurationOrTransition getTargetConfiguration();

	public void setTargetConfiguration(
			ConfigurationOrTransition targetConfiguration);
}
