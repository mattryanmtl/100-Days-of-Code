public class SudokuGenerator {
    public SudokuGenerator(int dim) {
        int[] topSeed = new int[dim];
        int[] sideSeed = new int[dim - 1];
        
        for (int i = 0; i < topSeed.length; i++) {
            topSeed[i] = i + 1;
        }
        
        shuffle(topSeed);
        
        for (int i = 0; i < sideSeed.length; i++) {
            int seedVal = i + 1;
            if (seedVal == topSeed[0]) sideSeed[i] = dim;
            else sideSeed[i] = i + 1;
        }
        
        shuffle(sideSeed);
        
        int[][] puzzleBuilder = new int[dim][dim];
        
        for (int i = 0; i < topSeed.length; i++) {
            puzzleBuilder[0][i] = topSeed[i];
        }
        
        for (int i = 0; i < sideSeed.length; i++) {
            puzzleBuilder[i + 1][0] = sideSeed[i];
        }
        
        SudokuPuzzle newPuzzle = new SudokuPuzzle(puzzleBuilder);
        
        System.out.println("Seed Puzzle:");
        System.out.println(newPuzzle + "\n");
        
        SudokuSolver ss = new SudokuSolver(newPuzzle);
        
        System.out.println("Generated Puzzle:");
        System.out.println(ss.results());
        
    }
    
    
    
	private int[] shuffle(int[] input) {
        
        int N = input.length;
        
        for (int i = 0; i < (N - 2); i++) {
            int swapIndex = (int) (Math.random() * (N - i)) + i;
            int temp = input[i];
            input[i] = input[swapIndex];
            input[swapIndex] = temp;
        }
        return input;
    }
    
    public static void main(String[] args) {
        int N = 9;        
        SudokuGenerator sg = new SudokuGenerator(N);
        
    }
}
