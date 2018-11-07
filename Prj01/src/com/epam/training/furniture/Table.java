package com.epam.training.furniture;

import com.epam.training.Area;

public class Table extends Furniture {
	private TableType tableType;

	public Table(double area) {
		super(area);
	}

	public Table(double area, TableType tableType) {
		super(area);
		this.tableType = tableType;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

	@Override
	public String toString() {
		return "\n\t\tСтол типа " + getTableType() + " площадью  " + getArea() + " m2";
	}

}
