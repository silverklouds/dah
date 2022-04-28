package com.dah.coloredshape.model.selection;

import lombok.Getter;

import com.dah.coloredshape.model.result.ColoredShape;
import com.dah.coloredshape.model.result.YellowSquare;

@Getter
public class RedCircle implements ColorShapeSelection {
	ColoredShape result = new YellowSquare();
}
