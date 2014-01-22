import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {
	private static final int Size = 9;
	private int[][] Data = new int[Size][Size];

	public Sudoku() {
		for (int row = 0; row < Size; row++) {
			for (int col = 0; col < Size; col++) {
				Data[row][col] = 0;
			}
		}
	}

	public void readData() {

		Scanner keyboard = new Scanner(System.in);
		for (int row = 0; row < Size; row++) {
			for (int col = 0; col < Size; col++) {
				Data[row][col] = keyboard.nextInt();
			}
		}
		keyboard.close();
	}

	public void readData(String filename) {
		File inputFile = new File(filename);
		try {
			Scanner keyboard = new Scanner(inputFile);
			for (int row = 0; row < Size; row++) {
				for (int col = 0; col < Size; col++) {
					Data[row][col] = keyboard.nextInt();
				}
			}
			keyboard.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
	}

	public void printData() {
		for (int row = 0; row < Size; row++) {
			for (int col = 0; col < Size; col++) {
				System.out.print(Data[row][col] + " ");
			}
			System.out.println();
		}
	}

	private boolean checkRow(int currentRow, int Number) {
		for (int col = 0; col < Size; col++) {
			if (Data[currentRow][col] == Number) {
				return false;
			}
		}
		return true;
	}

	private boolean checkCol(int currentCol, int Number) {
		for (int row = 0; row < Size; row++) {
			if (Data[row][currentCol] == Number) {
				return false;
			}
		}
		return true;
	}

	private boolean checkBox(int currentRow, int currentCol, int Number) {
		int startRow = currentRow / 3;
		int startCol = currentCol / 3;

		startRow *= 3;
		startCol *= 3;

		for (int row = startRow; row < startRow + 3; row++) {
			for (int col = startCol; col < startCol + 3; col++) {
				if (Data[row][col] == Number) {
					return false;
				}
			}
		}
		return true;
	}

	public void Solve() {
		int Counter = 0;
		boolean Continue = true;
		while (Continue) {
			Continue = false;
			for (int row = 0; row < Size; row++) {
				for (int col = 0; col < Size; col++) {
					if (Data[row][col] == 0) {
						Counter = 0;
						for (int Number = 1; Number <= 9; Number++) {
							if (checkRow(row, Number) && checkCol(col, Number)
									&& checkBox(row, col, Number)) {
								Data[row][col] = Number;
								Counter++;
							}
						}
						if (Counter > 1) {
							Continue = false || Continue;
							Data[row][col] = 0;

						} else {
							Continue = true;
							// Data[row][col] = Number;
						}
					}
				}
			}
		}
	}
}