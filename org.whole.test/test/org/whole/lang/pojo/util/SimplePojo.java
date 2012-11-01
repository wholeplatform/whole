package org.whole.lang.pojo.util;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;


public class SimplePojo {
	protected boolean 			fBoolean;
	protected byte				fByte;
	protected char				fChar;
	protected double			fDouble;
	protected float				fFloat;
	protected int				fInt;
	protected long				fLong;
	protected short				fShort;
	protected String			fString;
	protected SimplePojo		leftPojo;
	protected SimplePojo		rightPojo;
	protected Pattern			pattern;
	protected AbstractPojo1		abstractPojo;
	public    EnumPojo			enumPojo;
	public    Set<Pattern>[]	fSet;

	SimplePojo(boolean boolean1, byte byte1, char char1, double double1,
			float float1, int int1, long long1, short short1, String string,
			SimplePojo leftPojo, SimplePojo rightPojo, Pattern pattern,
			AbstractPojo1 abstractPojo, EnumPojo enumPojo, Set<Pattern>[] set) {
		super();
		fBoolean = boolean1;
		fByte = byte1;
		fChar = char1;
		fDouble = double1;
		fFloat = float1;
		fInt = int1;
		fLong = long1;
		fShort = short1;
		fString = string;
		this.leftPojo = leftPojo;
		this.rightPojo = rightPojo;
		this.pattern = pattern;
		this.abstractPojo = abstractPojo;
		this.enumPojo = enumPojo;
		fSet = set;
	}

	public SimplePojo(byte fByte, boolean fBoolean, double fDouble) {
		this.fByte = fByte;
		this.fBoolean = fBoolean;
		this.fDouble = fDouble;
	}

	public SimplePojo(byte fByte, boolean fBoolean) {
		this(fByte, fBoolean, 0.0);
	}

	public SimplePojo(boolean fBoolean) {
		this((byte) 0, fBoolean);
	}

	public SimplePojo() {
	}

	public boolean isFBoolean() {
		return fBoolean;
	}

	public byte getFByte() {
		return fByte;
	}

	public char getFChar() {
		return fChar;
	}

	public void setFChar(char char1) {
		fChar = char1;
	}

	public double getFDouble() {
		return fDouble;
	}

	public void setFDouble(double double1) {
		fDouble = double1;
	}

	public float getFFloat() {
		return fFloat;
	}

	public void setFFloat(float float1) {
		fFloat = float1;
	}

	public int getFInt() {
		return fInt;
	}

	public void setFInt(int int1) {
		fInt = int1;
	}

	public long getFLong() {
		return fLong;
	}

	public void setFLong(long long1) {
		fLong = long1;
	}

	public short getFShort() {
		return fShort;
	}

	public void setFShort(short short1) {
		fShort = short1;
	}

	public String getFString() {
		return fString;
	}

	public void setFString(String string) {
		fString = string;
	}

	public SimplePojo getLeftPojo() {
		return leftPojo;
	}

	public void setLeftPojo(SimplePojo leftPojo) {
		this.leftPojo = leftPojo;
	}

	public SimplePojo getRightPojo() {
		return rightPojo;
	}

	public void setRightPojo(SimplePojo rightPojo) {
		this.rightPojo = rightPojo;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public AbstractPojo1 getAbstractPojo() {
		return abstractPojo;
	}

	public void setAbstractPojo(AbstractPojo1 abstractPojo) {
		this.abstractPojo = abstractPojo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abstractPojo == null) ? 0 : abstractPojo.hashCode());
		result = prime * result
				+ ((enumPojo == null) ? 0 : enumPojo.hashCode());
		result = prime * result + (fBoolean ? 1231 : 1237);
		result = prime * result + fChar;
		long temp;
		temp = Double.doubleToLongBits(fDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(fFloat);
		result = prime * result + fInt;
		result = prime * result + (int) (fLong ^ (fLong >>> 32));
		result = prime * result + Arrays.hashCode(fSet);
		result = prime * result + fShort;
		result = prime * result + ((fString == null) ? 0 : fString.hashCode());
		result = prime * result
				+ ((leftPojo == null) ? 0 : leftPojo.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result
				+ ((rightPojo == null) ? 0 : rightPojo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SimplePojo other = (SimplePojo) obj;
		if (abstractPojo == null) {
			if (other.abstractPojo != null)
				return false;
		} else if (!abstractPojo.equals(other.abstractPojo))
			return false;
		if (enumPojo == null) {
			if (other.enumPojo != null)
				return false;
		} else if (!enumPojo.equals(other.enumPojo))
			return false;
		if (fBoolean != other.fBoolean)
			return false;
		if (fByte != other.fByte)
			return false;
		if (fChar != other.fChar)
			return false;
		if (Double.doubleToLongBits(fDouble) != Double
				.doubleToLongBits(other.fDouble))
			return false;
		if (Float.floatToIntBits(fFloat) != Float.floatToIntBits(other.fFloat))
			return false;
		if (fInt != other.fInt)
			return false;
		if (fLong != other.fLong)
			return false;
		if (!Arrays.equals(fSet, other.fSet))
			return false;
		if (fShort != other.fShort)
			return false;
		if (fString == null) {
			if (other.fString != null)
				return false;
		} else if (!fString.equals(other.fString))
			return false;
		if (leftPojo == null) {
			if (other.leftPojo != null)
				return false;
		} else if (!leftPojo.equals(other.leftPojo))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.pattern().equals(other.pattern.pattern()))
			return false;
		if (rightPojo == null) {
			if (other.rightPojo != null)
				return false;
		} else if (!rightPojo.equals(other.rightPojo))
			return false;
		return true;
	}
}
