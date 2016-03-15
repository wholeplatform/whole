/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.bindings;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;

public class SampleJavaBean {
	private IEntity id1 = null;
	private IEntity id2 = null;
	private IEntity id3 = null;
	private IEntity id4 = null;

	private boolean boolF;
	private byte byteF;
	private char charF;
	private double doubleF;
	private float floatF;
	private int intF;
	private long longF;
	private short shortF;
	private String stringF;
	private Date dateF;
	private EnumValue enumF;
	private Object objectF;

	private String a;
	private String b;
	private int c;
	private boolean d;

	protected int[] ints;
	protected List<Integer> intlist;
	protected Date[] dates;
	protected Set<SampleJavaBean> beanSet; 
	protected List<List<Boolean>> mylist;

	private List<Integer>[][] t1;
	private List<Integer[]>[] t2;
	private List<Set<Integer>> t3;
	private List[][] t4;
	private List[] t5;
	private Long t6;
	private int t7;
	protected Map<String, List<Date>>[] t8;

	
	public IEntity getId1() {
		return id1;
	}
	public void setId1(IEntity id1) {
		this.id1 = id1;
	}
	public IEntity getId2() {
		return id2;
	}
	public void setId2(IEntity id2) {
		this.id2 = id2;
	}
	public IEntity getId3() {
		return id3;
	}
	public void setId3(IEntity id3) {
		this.id3 = id3;
	}
	public IEntity getId4() {
		return id4;
	}
	public void setId4(IEntity id4) {
		this.id4 = id4;
	}
	public boolean isBoolF() {
		return boolF;
	}
	public void setBoolF(boolean boolF) {
		this.boolF = boolF;
	}
	public byte getByteF() {
		return byteF;
	}
	public void setByteF(byte byteF) {
		this.byteF = byteF;
	}
	public char getCharF() {
		return charF;
	}
	public void setCharF(char charF) {
		this.charF = charF;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public double getDoubleF() {
		return doubleF;
	}
	public void setDoubleF(double doubleF) {
		this.doubleF = doubleF;
	}
	public EnumValue getEnumF() {
		return enumF;
	}
	public void setEnumF(EnumValue enumF) {
		this.enumF = enumF;
	}
	public float getFloatF() {
		return floatF;
	}
	public void setFloatF(float floatF) {
		this.floatF = floatF;
	}
	public int getIntF() {
		return intF;
	}
	public void setIntF(int intF) {
		this.intF = intF;
	}
	public long getLongF() {
		return longF;
	}
	public void setLongF(long longF) {
		this.longF = longF;
	}
	public Object getObjectF() {
		return objectF;
	}
	public void setObjectF(Object objectF) {
		this.objectF = objectF;
	}
	public short getShortF() {
		return shortF;
	}
	public void setShortF(short shortF) {
		this.shortF = shortF;
	}
	public String getStringF() {
		return stringF;
	}
	public void setStringF(String stringF) {
		this.stringF = stringF;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	public int[] getInts() {
		return ints;
	}
	public void setInts(int[] ints) {
		this.ints = ints;
	}
	public int getInts(int index) {
		return ints[index];
	}
	public void setInts(int index, int ints) {
		this.ints[index] = ints;
	}
	public List<Integer> getIntlist() {
		return intlist;
	}
	public void setIntlist(List<Integer> intlist) {
		this.intlist = intlist;
	}
	public Date[] getDates() {
		return dates;
	}
	public void setDates(Date[] dates) {
		this.dates = dates;
	}
	public Date getDates(int index) {
		return dates[index];
	}
	public void setDates(int index, Date date) {
		this.dates[index] = date;
	}
	public Set<SampleJavaBean> getBeanSet() {
		return beanSet;
	}
	public void setBeanSet(Set<SampleJavaBean> beanSet) {
		this.beanSet = beanSet;
	}
}
