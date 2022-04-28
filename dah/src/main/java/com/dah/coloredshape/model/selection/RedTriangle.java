package com.dah.coloredshape.model.selection;

import lombok.Getter;

import com.dah.coloredshape.model.result.ColoredShape;
import com.dah.coloredshape.model.result.YellowHorizontalRectangle;

@Getter
public class RedTriangle implements ColorShapeSelection {
	ColoredShape result = new YellowHorizontalRectangle();
}
