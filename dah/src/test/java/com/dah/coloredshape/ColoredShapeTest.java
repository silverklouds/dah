package com.dah.coloredshape;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.dah.coloredshape.enums.Color;
import com.dah.coloredshape.enums.Shape;
import com.dah.coloredshape.model.result.ColoredShape;
import com.dah.coloredshape.model.result.SelectionResult;
import com.dah.coloredshape.model.result.YellowHorizontalRectangle;
import com.dah.coloredshape.model.result.YellowSquare;
import com.dah.coloredshape.service.ColorShapeServiceImpl;

@SpringBootTest
class ColoredShapeTest {
	@InjectMocks
	private ColorShapeServiceImpl colorShapeService;

	@Test
	void testUndefined() {
		SelectionResult result = colorShapeService.getResultOf(Color.BLUE, Shape.STAR);
		assertThat(result).isNotNull();
		assertThat(result.getColoredShape()).isNotNull();
		assertThat(result.getColoredShape().getName()).isEqualTo("Undefined");
	}

	@Test
	void testRedRectangle() {
		SelectionResult result = colorShapeService.getResultOf(Color.RED, Shape.RECTANGLE);
		assertThat(result.getSelectedColor()).isEqualTo(Color.RED);
		assertThat(result.getSelectedShape()).isEqualTo(Shape.RECTANGLE);
		ColoredShape coloredShape = result.getColoredShape();
		assertThat(coloredShape).isNotNull();
		assertThat(coloredShape.getName()).isEqualTo("PaleGreenEclipse");
	}

	@Test
	void testRedCircle() {
		SelectionResult result = colorShapeService.getResultOf(Color.RED, Shape.CIRCLE);
		ColoredShape coloredShape = result.getColoredShape();
		assertThat(coloredShape).isNotNull();
		assertThat(coloredShape).isInstanceOf(YellowSquare.class);
		assertThat(result.getSelectedColor()).isEqualTo(Color.RED);
		assertThat(result.getSelectedShape()).isEqualTo(Shape.CIRCLE);
	}

	@Test
	void testRedTriangle() {
		SelectionResult result = colorShapeService.getResultOf(Color.RED, Shape.TRIANGLE);
		ColoredShape coloredShape = result.getColoredShape();
		assertThat(coloredShape).isNotNull();
		assertThat(coloredShape).isInstanceOf(YellowHorizontalRectangle.class);
		assertThat(result.getSelectedColor()).isEqualTo(Color.RED);
		assertThat(result.getSelectedShape()).isEqualTo(Shape.TRIANGLE);
	}
}
