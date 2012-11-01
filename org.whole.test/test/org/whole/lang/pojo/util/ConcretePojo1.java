package org.whole.lang.pojo.util;

import java.util.regex.Pattern;

public class ConcretePojo1 extends AbstractPojo1 {
	protected String name;

	public ConcretePojo1() {
	}

	public ConcretePojo1(Pattern pattern, String name) {
		super(pattern);
		this.name = name;
	}
	
	@Override
	public void doJob() {
		System.out.println(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ConcretePojo1 other = (ConcretePojo1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
