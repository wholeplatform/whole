package org.whole.lang.versions.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class VersionsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int versions_ord = 0;
	public static final int history_ord = 1;
	public static final int rootVersion_ord = 2;
	public static final int versionLabel_ord = 3;
	public static final int predecessors_ord = 4;
	public static final int successors_ord = 5;
	public static final int versionable_ord = 6;
	public static final int baseVersion_ord = 7;
	public static final VersionsFeatureDescriptorEnum instance = new VersionsFeatureDescriptorEnum();
	public static final FeatureDescriptor versions = instance
			.valueOf(versions_ord);
	public static final FeatureDescriptor history = instance
			.valueOf(history_ord);
	public static final FeatureDescriptor rootVersion = instance
			.valueOf(rootVersion_ord);
	public static final FeatureDescriptor versionLabel = instance
			.valueOf(versionLabel_ord);
	public static final FeatureDescriptor predecessors = instance
			.valueOf(predecessors_ord);
	public static final FeatureDescriptor successors = instance
			.valueOf(successors_ord);
	public static final FeatureDescriptor versionable = instance
			.valueOf(versionable_ord);
	public static final FeatureDescriptor baseVersion = instance
			.valueOf(baseVersion_ord);

	private VersionsFeatureDescriptorEnum() {
		putFeatureDescriptor(versions_ord, "versions");
		putFeatureDescriptor(history_ord, "history");
		putFeatureDescriptor(rootVersion_ord, "rootVersion");
		putFeatureDescriptor(versionLabel_ord, "versionLabel");
		putFeatureDescriptor(predecessors_ord, "predecessors");
		putFeatureDescriptor(successors_ord, "successors");
		putFeatureDescriptor(versionable_ord, "versionable");
		putFeatureDescriptor(baseVersion_ord, "baseVersion");
	}

	private static final long serialVersionUID = 1;
}
