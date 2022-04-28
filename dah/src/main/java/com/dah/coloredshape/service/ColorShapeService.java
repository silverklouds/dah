package com.dah.coloredshape.service;

import com.dah.coloredshape.enums.Color;
import com.dah.coloredshape.enums.Shape;
import com.dah.coloredshape.model.result.SelectionResult;

public interface ColorShapeService {
	SelectionResult getResultOf(Color color, Shape shape);
}
