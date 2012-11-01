package org.whole.lang.scripts.bindings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import javax.script.Bindings;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

public class BindingsAdapter implements Bindings {
	protected IBindingManager bm;
	protected boolean useAutoboxing = false;

	public BindingsAdapter(IBindingManager bm, boolean useAutoboxing) {
		this.bm = bm;
		this.useAutoboxing = useAutoboxing;
	}

	public void setAutoboxing(boolean enable) {
		useAutoboxing = enable;
	}

	public boolean isAutoboxing() {
		return useAutoboxing;
	}

	public boolean containsKey(Object key) {
		String name = check(key);
		return bm.wIsSet(name);
	}

	public Object get(Object key) {
		String name = check(key);
		if (bm.wIsSet(name))
			return unboxFilter(bm.wGet(name));
		else
			return null;
	}

	public Object put(String name, Object value) {
		Object oldValue = get(name);
		bm.wDef(name, boxFilter(value));
		return oldValue;
	}

	public void putAll(Map<? extends String, ? extends Object> toMerge) {
		for (Entry<? extends String, ? extends Object> entry :toMerge.entrySet())
			bm.wDef(entry.getKey(), boxFilter(entry.getValue()));
	}

	public Object remove(Object key) {
		String name = check(key);
		// only local remove allowed
		if (bm.wLocalNames().contains(name)) {
			Object oldValue = unboxFilter(bm.wGet(name));
			bm.wUnset(name);
			return oldValue;
		} else
			return null;
	}

	public void clear() {
		throw new UnsupportedOperationException("cannot clear bindings");
	}

	public boolean containsValue(Object value) {
		return entityValues().contains(value) || values().contains(value);
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		HashSet<Entry<String,Object>> hashSet = new HashSet<Entry<String,Object>>();
		for (String name : bm.wNames())
			hashSet.add(new SimpleEntry<String, Object>(name, unboxFilter(bm.wGet(name))));
		return hashSet;
	}

	public boolean isEmpty() {
		return bm.wNames().isEmpty();
	}

	public Set<String> keySet() {
		return bm.wNames();
	}

	public int size() {
		return bm.wNames().size();
	}

	@SuppressWarnings("unchecked")
	private <T> Collection<T> entityValues() {
		List<T> collection = new ArrayList<T>(size());
		for (String name : bm.wNames())
			collection.add((T) bm.wGet(name));
		return collection;
	}
	public Collection<Object> values() {
		if (!useAutoboxing)
			return entityValues();
		List<Object> collection = new ArrayList<Object>(size());
		for (IEntity entity : this.<IEntity>entityValues())
			collection.add(unboxFilter(entity));
		return collection;
	}

	private Object unboxFilter(IEntity value) {
		if (useAutoboxing  && EntityUtils.isData(value))
			return value.wGetValue();
		return value;
	}

	private IEntity boxFilter(Object value) {
		if (!(value instanceof IEntity))
			return BindingManagerFactory.instance.createSpecificValue(value);
		else
			return (IEntity) value;
	}

	private String check(Object key) {
		if (key == null)
			throw new NullPointerException("null key");
		else if (!(key instanceof String))
			throw new ClassCastException("not a String");
		else if (key.equals(""))
			throw new IllegalArgumentException("empty key");
		return (String) key;
	}
}
