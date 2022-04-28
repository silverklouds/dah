package com.dah.coloredshape.service;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dah.coloredshape.enums.Color;
import com.dah.coloredshape.enums.Shape;
import com.dah.coloredshape.model.result.SelectionResult;
import com.dah.coloredshape.model.result.UndefinedColoredShape;
import com.dah.coloredshape.model.selection.ColorShapeSelection;

@Slf4j
@Service
public class ColorShapeServiceImpl implements ColorShapeService {
	private static final String SELECTION_MODULE = "com.dah.coloredshape.model.selection.";

	@Override
	public SelectionResult getResultOf(Color color, Shape shape) {
		assert color != null;
		assert shape != null;
		try {
			String colorShapeStr = StringUtils.capitalize(color.name().toLowerCase()) + StringUtils.capitalize(shape.name().toLowerCase());
			Class<?> clazz = Class.forName(SELECTION_MODULE + colorShapeStr);
			ColorShapeSelection selection = (ColorShapeSelection) clazz.getConstructor().newInstance();
			return new SelectionResult(color, shape, selection.getResult());
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException notFoundException) {
			return new SelectionResult(color, shape, new UndefinedColoredShape());
		} catch (RuntimeException e) {
			log.error("An error occurred.", e);
			throw e;
		}
	}
}
