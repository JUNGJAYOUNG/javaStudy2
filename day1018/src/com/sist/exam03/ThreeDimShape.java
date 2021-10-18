package com.sist.exam03;

public abstract class ThreeDimShape extends Shape {
	protected double volume;

	public ThreeDimShape(int x,int y) {
		super(x,y);
	}

	public ThreeDimShape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract double getVolume();
}
