package matrices;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.ThreadPool;

public class ClassMain {
	public static void main(String[] args) {
		int numberOfThreads = 0;
		int numberOfMatrices = 0;
		int matrixDimension = 0;
		Vector<SquareMatrix> matrices = new Vector<SquareMatrix>();
		Scanner s = new Scanner(System.in);
		while (true) {

			do {

				System.out.print("Enter desired number of threads: ");

				while (!s.hasNextInt()) {
					System.out.println("Letters are not allowed!");
					System.out.print("Enter desired number of threads: ");
					System.out.println("");
					s.next();
				}

				numberOfThreads = s.nextInt();

				if (numberOfThreads < 2 || numberOfThreads > 20) {
					System.out.println("Number of threads should be between 2 and 20!");
				}

			} while (numberOfThreads < 2 || numberOfThreads > 20);

			do {
				System.out.print("Enter desired number of matrices: ");

				while (!s.hasNextInt()) {
					System.out.println("Letters are not allowed!");
					System.out.print("Enter desired number of matrices: ");
					System.out.println("");
					s.next();
				}

				numberOfMatrices = s.nextInt();

				if (numberOfMatrices < 2) {
					System.out.println("You should enter at least 2!");
				}

			} while (numberOfMatrices < 2);

			do {

				System.out.print("Enter desired matrix dimension: ");

				while (!s.hasNextInt()) {
					System.out.println("Letters are not allowed!");
					System.out.print("Enter desired matrix dimension: ");
					System.out.println("");
					s.next();
				}

				matrixDimension = s.nextInt();

				if (matrixDimension < 2) {
					System.out.println("You should enter at least 2!");
				}

			} while (matrixDimension < 2);

			for (int i = 0; i < numberOfMatrices; i++) {
				matrices.add(new SquareMatrix(matrixDimension));
				matrices.get(i).populateMatrix();
			}

			ThreadPool threadPool = new ThreadPool(numberOfThreads);
			for (int i = 0; i < numberOfMatrices - 1; i++) {
				try {
					threadPool.execute(matrices.set(i + 1, matrices.get(i).multiply(matrices.get(i + 1))));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			threadPool.shutdown();

			matrices.lastElement().print();

			matrices.clear();
			
			String quit;
			do {

				System.out.println("Continue (Y/N)?: ");
				
				
				quit = s.nextLine();

			} while (!quit.equals("y") && !quit.equals("Y") && !quit.equals("n") && !quit.equals("N"));

			if (quit.equals("n")) {

				break;
			}
		}
		System.out.println("Exiting...");
		s.close();
	}
}
