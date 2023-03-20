package studentCode;
import java.awt.Color;
import GridTools.MyGrid;

public class FlagMaker {
	
	
	public static void drawFlag(MyGrid grid, int countryCode) {
		final int HEIGHT = grid.getHt();
		final int WIDTH = grid.getWd();
		if(countryCode == 1 && HEIGHT % 2 == 0) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.red);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT/2, Color.white);
		}else if(countryCode == 2 && HEIGHT % 3 == 0) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.yellow);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT/3, Color.green);
			HorizontalFill(grid, HEIGHT, WIDTH, 2*HEIGHT/3, Color.red);
		}else if(countryCode == 3 && HEIGHT % 4 == 0) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.blue);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT/2, Color.yellow);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT - HEIGHT/4, Color.green);
		}else if(countryCode == 4 && WIDTH % 2 == 0) {
			VerticalFill(grid, HEIGHT, WIDTH, 0, Color.white);
			VerticalFill(grid, HEIGHT, WIDTH, WIDTH/2, Color.red);
		}else if(countryCode == 5 && (HEIGHT % 3) == 0) {
			VerticalFill(grid, HEIGHT, WIDTH, 0, Color.black);
			VerticalFill(grid, HEIGHT, WIDTH, WIDTH/3, Color.red);
			VerticalFill(grid, HEIGHT, WIDTH, 2*WIDTH/3, Color.green);
		}else if(countryCode == 6) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.green);
			HorizontalFill(grid, HEIGHT, WIDTH, (HEIGHT/2), Color.blue);

			if(HEIGHT % 2 == 0) {
				for(int y = 0; y < (HEIGHT/2); y++) {
					for(int x = 0; x < 4 * (y + 1) && x < WIDTH; x++) {
						grid.setColor(y, x, Color.red);
					}
				}
				int xLength = WIDTH;
				for(int y = (HEIGHT/2); y < HEIGHT; y++) {
					for(int x = 0; x < xLength && x < WIDTH; x++) {
						grid.setColor(y, x, Color.red);
					}
					xLength -= 4;
				}
				
			}
			if(HEIGHT % 2 != 0) {
				for(int y = 0; y < (HEIGHT/2) + 1; y++) {
					for(int x = 0; x < 4 * (y + 1) && x < WIDTH; x++) {
						grid.setColor(y, x, Color.red);
					}
				}
				int xLength = WIDTH;
				for(int y = (HEIGHT/2); y < HEIGHT; y++) {
					for(int x = 0; x < xLength + 2 && x < WIDTH; x++) {
						grid.setColor(y, x, Color.red);
					}
					xLength -= 4;
				}
			}
			
		}else if(countryCode == 7 && HEIGHT >= 8 && HEIGHT % 2 == 0) {
			
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.red);
			HorizontalFill(grid, (HEIGHT/2) + 2, WIDTH, (HEIGHT/2) - 2, Color.orange);
			VerticalFill(grid, HEIGHT, WIDTH, (WIDTH/2) + 4, Color.red);
			VerticalFill(grid, HEIGHT, (WIDTH/2) - 4, 0, Color.red);
			HorizontalFill(grid, (HEIGHT/2) + 1, WIDTH, (HEIGHT/2) - 1, Color.orange);
			VerticalFill(grid, HEIGHT, (WIDTH/2) + 1, (WIDTH/2) - 1, Color.orange);
			int xIndent = 0;
			for(int i = 0; i < HEIGHT; i++) {
				for(int q = 0; q < 2; q++) {
					grid.setColor(i, q + xIndent, Color.orange);
				}
				xIndent += 2;
			}
			int yIndent = 0;
			for(int i = HEIGHT - 1; i >= 0; i--) {
				for(int q = 0; q < 2; q++) {
					grid.setColor(i, q + yIndent, Color.orange);
				}
				yIndent += 2;
			}
			
		
		}else if(countryCode == 8 && HEIGHT % 3 == 0 && HEIGHT % 2 != 0) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.blue);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT/3, Color.yellow);
			HorizontalFill(grid, HEIGHT, WIDTH, 2*HEIGHT/3, Color.blue);
			for(int y = 0; y < (HEIGHT/2) + 1; y++) {
				for(int x = 0; x <= y; x++) {
					grid.setColor(y, x, Color.black);
				}
			}
			int xLength = HEIGHT/2 + 1;
			for(int y = (HEIGHT/2); y < HEIGHT; y++) {
				for(int x = 0; x < xLength; x++) {
					grid.setColor(y, x, Color.black);
				}
				xLength--;
			}
		}else if(countryCode == 9 && HEIGHT % 7 == 0) {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.green);
			HorizontalFill(grid, HEIGHT, WIDTH, HEIGHT/7, Color.yellow);
			HorizontalFill(grid, HEIGHT, WIDTH, 2*HEIGHT/7, Color.red);
			HorizontalFill(grid, HEIGHT, WIDTH, 3*HEIGHT/7, Color.black);
			HorizontalFill(grid, HEIGHT, WIDTH, 4*HEIGHT/7, Color.red);
			HorizontalFill(grid, HEIGHT, WIDTH, 5*HEIGHT/7, Color.yellow);
			HorizontalFill(grid, HEIGHT, WIDTH, 6*HEIGHT/7, Color.green);
			
			if(HEIGHT % 2 == 0) {
				int xLength = 1;
				for(int y = 0; y < (HEIGHT/2); y++) {
					for(int x = 0; x < xLength; x++) {
						grid.setColor(y, x, Color.white);
					}
					xLength++;
				}
				xLength--;
				for(int y = (HEIGHT/2); y < HEIGHT; y++) {
					for(int x = 0; x < xLength; x++) {
						grid.setColor(y, x, Color.white);
					}
					xLength--;
				}
				
			}
			if(HEIGHT % 2 != 0) {
				int xLength = 1;
				for(int y = 0; y < (HEIGHT/2); y++) {
					for(int x = 0; x < xLength; x++) {
						grid.setColor(y, x, Color.white);
					}
					xLength++;
				}
				
				for(int y = (HEIGHT/2); y < HEIGHT; y++) {
					for(int x = 0; x < xLength; x++) {
						grid.setColor(y, x, Color.white);
					}
					xLength--;
				}
			}
		}else {
			HorizontalFill(grid, HEIGHT, WIDTH, 0, Color.white);	
			grid.setColor(0, 0, Color.red);
			grid.setColor(Math.abs(HEIGHT) - 1, 0, Color.blue);
			grid.setColor(0, WIDTH - 1, Color.yellow);
			grid.setColor(Math.abs(HEIGHT) - 1, Math.abs(WIDTH) - 1, Color.green);
		}
	}
	public static void HorizontalFill(MyGrid grid, int row, int col, int horizontalStart, Color c) {
		for(int i = horizontalStart; i < row; i++) {
			for(int q = 0; q < col; q++) {
				grid.setColor(i, q, c);
			}
		}
	}
	public static void VerticalFill(MyGrid grid, int row, int col, int verticalStart, Color c) {
		for(int i = 0; i < row; i++) {
			for(int q = verticalStart; q < col; q++) {
				grid.setColor(i, q, c);
			}
		}
	}
}
