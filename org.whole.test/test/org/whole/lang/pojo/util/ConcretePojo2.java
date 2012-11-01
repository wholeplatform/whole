package org.whole.lang.pojo.util;

import java.util.regex.Pattern;

public class ConcretePojo2 extends AbstractPojo2 {
	public int number;

	public ConcretePojo2() {
	}

	public ConcretePojo2(Pattern pattern, boolean valid, int number) {
		super(pattern, valid);
		this.number = number;
	}

	@Override
	public void doJob() {
		System.out.println(number);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + number;
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
		final ConcretePojo2 other = (ConcretePojo2) obj;
		if (number != other.number)
			return false;
		return true;
	}
}
