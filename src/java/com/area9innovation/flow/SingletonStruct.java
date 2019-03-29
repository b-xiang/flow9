package com.area9innovation.flow;

import java.util.Hashtable;

public final class SingletonStruct extends Struct {
	private final String name;
	private final String name_rep;

	private SingletonStruct(String name) {
		this.name = name;
		this.name_rep = name+"()";
	}

	private static final Hashtable<String,SingletonStruct> cache = new Hashtable<String,SingletonStruct>();

	public static SingletonStruct make(String name) {
		SingletonStruct item = cache.get(name);
		if (item == null)
			cache.put(name, item = new SingletonStruct(name));
		return item;
	}

	private static final String[] no_names = new String[] {};
	private static final RuntimeType[] no_types = new RuntimeType[] {};
	private static final Object[] no_fields = new Object[] {};

	public String getTypeName() {
		return name;
	}
	public String[] getFieldNames() {
		return no_names;
	}
	public RuntimeType[] getFieldTypes() {
		return no_types;
	}
	public Object[] getFields() {
		return no_fields;
	}
	public void setFields(Object[] data) {
		if (data.length != 0)
			throw new IndexOutOfBoundsException("No fields in "+name);
	}
	public Struct clone() {
		return this;
	}
	public String toString() {
		return name_rep;
	}
	public int compareTo(Struct other) {
		return name.compareTo(other.getTypeName());
	}
}
