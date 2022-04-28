package com.dah.coloredshape.model.result;

public interface ColoredShape {

	default String getName() {
		return this.getClass().getSimpleName();
	}
}
