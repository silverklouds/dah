package com.dah.coloredshape.model.selection;

import lombok.Getter;

import com.dah.coloredshape.model.result.ColoredShape;
import com.dah.coloredshape.model.result.PaleGreenEclipse;

@Getter
public class RedRectangle implements ColorShapeSelection {
	ColoredShape result = new PaleGreenEclipse();
}
