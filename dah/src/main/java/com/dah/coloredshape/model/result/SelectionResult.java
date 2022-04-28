package com.dah.coloredshape.model.result;

import lombok.Value;

import com.dah.coloredshape.enums.Color;
import com.dah.coloredshape.enums.Shape;

@Value
public class SelectionResult {
	Color selectedColor;
	Shape selectedShape;
	ColoredShape coloredShape;
}
