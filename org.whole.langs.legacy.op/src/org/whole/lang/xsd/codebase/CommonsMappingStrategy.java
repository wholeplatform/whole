package org.whole.lang.xsd.codebase;

import static org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser.parseEntityDescriptor;
import static org.whole.lang.commons.model.QuantifierEnum.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsd.parsers.SchemaEnumDataTypeParser;

/**
 *  @generator  Whole
 */
public class CommonsMappingStrategy extends AbstractMappingStrategy {
    private EntityDescriptor<?> mixedDataType;
    private Set<EntityDescriptor<?>> mixedTypes;
    private Map<EntityDescriptor<?>, Map<String, String>> fromEnumValues;
    private Map<EntityDescriptor<?>, Map<String, String>> toEnumValues;

    public CommonsMappingStrategy() {
        this.mixedDataType = null;
        this.mixedTypes = Collections.<EntityDescriptor<?>>emptySet();
        this.fromEnumValues = new HashMap<EntityDescriptor<?>, Map<String, String>>();
        this.toEnumValues = new HashMap<EntityDescriptor<?>, Map<String, String>>();
        EntityDescriptor<?> ed = CommonsEntityDescriptorEnum.Quantifier;
        Map<String, EnumValue> map = new HashMap<String, EnumValue>();
        map.put("OPTIONAL", OPTIONAL);
        map.put("MANDATORY", MANDATORY);
        map.put("ZERO_OR_MORE_GREEDY", ZERO_OR_MORE_GREEDY);
        map.put("ONE_OR_MORE_GREEDY", ONE_OR_MORE_GREEDY);
        map.put("ZERO_OR_MORE_RELUCTANT", ZERO_OR_MORE_RELUCTANT);
        map.put("ONE_OR_MORE_RELUCTANT", ONE_OR_MORE_RELUCTANT);
        map.put("ZERO_OR_MORE_POSSESSIVE", ZERO_OR_MORE_POSSESSIVE);
        map.put("ONE_OR_MORE_POSSESSIVE", ONE_OR_MORE_POSSESSIVE);
		parsers.put(ed, new SchemaEnumDataTypeParser(ed, map));
    }

    public String getNamespace() {
        return "http://lang.whole.org/Commons";
    }

    public String getSchemaLocation() {
        return "Commons.xsd";
    }

    public boolean isSynthesized() {
        return true;
    }

    public boolean isElementsFormQualified() {
        return true;
    }

    public boolean isAttributesFormQualified() {
        return false;
    }

    public EntityDescriptor<?> getMixedDataType() {
        return mixedDataType;
    }

    protected void setMixedDataType(String uri) {
        this.mixedDataType = parseEntityDescriptor(uri);
    }

    public boolean isMixedType(EntityDescriptor<?> ed) {
        return mixedTypes.contains(ed);
    }

    protected void setMixedTypes(String... uris) {
        mixedTypes = new HashSet<EntityDescriptor<?>>(uris.length);
        for (String uri : uris)
            mixedTypes.add(parseEntityDescriptor(uri));
    }

    protected Map<String, String> fromEnumValueMap(EntityDescriptor<?> context) {
        Map<String, String> map = fromEnumValues.get(context);
        if (map == null)
            fromEnumValues.put(context, map = new HashMap<String, String>());
        return map;
    }

    protected Map<String, String> toEnumValueMap(EntityDescriptor<?> context) {
        Map<String, String> map = toEnumValues.get(context);
        if (map == null)
            toEnumValues.put(context, map = new HashMap<String, String>());
        return map;
    }

    protected void addEnumValue(String uri, String value, String enumValue) {
        EntityDescriptor<?> context = parseEntityDescriptor(uri);
        fromEnumValueMap(context).put(enumValue, value);
        toEnumValueMap(context).put(value, enumValue);
    }

    // added after code generation
    public Collection<FeatureDescriptor> getElementFeatureMappings(EntityDescriptor<?> context, QName name) {
    	return EntityUtils.isFragment(context) ? 
    			Collections.singleton(CommonsFeatureDescriptorEnum.rootEntity) :
    				super.getElementFeatureMappings(context, name);
    }
    public EntityDescriptor<?> getElementEntityMapping(EntityDescriptor<?> context, QName name) {
    	return EntityUtils.isFragment(context) ? //TODO convert to RootFragment equality test ?
    			MappingStrategyUtils.getRootEntityMapping(name):
    				super.getElementEntityMapping(context, name);
    }
    public FeatureDescriptor getAttributeFeatureMapping(EntityDescriptor<?> context, QName name) {
    	return EntityUtils.isFragment(context) ? //TODO convert to RootFragment equality test ?
    			CommonsFeatureDescriptorEnum.rootEntity :
    				super.getAttributeFeatureMapping(context, name);
    }
    public String getElementNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
    	return EntityUtils.isFragment(context) &&
    		CommonsFeatureDescriptorEnum.rootEntity.equals(fd) ?
    			MappingStrategyUtils.getRootElementNCName(ed) :
    				super.getElementNCName(context, ed, fd);
    }
	public Collection<EntityDescriptor<?>> getUnionEntityMappings(EntityDescriptor<?> context) {
		return Collections.emptyList();
	}
	public EntityDescriptor<?> getRootEntityMapping(QName name) {
		return null;
	}
	public String getRootElementNCName(EntityDescriptor<?> ed) {
		return null;
	}
}
