package org.whole.lang.pojo.util;

import java.util.regex.Pattern;

public abstract class AbstractPojo2 extends AbstractPojo1 {
	public boolean	valid;
	
	public AbstractPojo2() {
	}

	public AbstractPojo2(Pattern pattern, boolean valid) {
		super(pattern);
		this.valid = valid;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (valid ? 1231 : 1237);
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
		final AbstractPojo2 other = (AbstractPojo2) obj;
		if (valid != other.valid)
			return false;
		return true;
	}
}
