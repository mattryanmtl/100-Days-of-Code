public class PasswordGuessGame {

    private static final int DIFFICULTY_MULTIPLIER = 5;

    private static int guessesLeft = 4;

    private static boolean gameIsWon = false;

    private static char[] winningCombination;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Difficulty? (1-5)");
        int difficulty = in.nextInt();
        in.nextLine();
        List<String> wordHints = getWords(difficulty);

        Random rand = new Random();
        winningCombination = wordHints.get(rand.nextInt(wordHints.size())).toCharArray();

        while (notGameOver()) {
            for (String hint : wordHints) {
                System.out.println(hint);
            }
            System.out.println("Guess (" + guessesLeft + " left)?");
            String nextLine = in.nextLine();
            int result = compare(nextLine);
            final int wordLength = difficulty*2 + DIFFICULTY_MULTIPLIER;
            if (result == wordLength) {
                gameIsWon = true;
            } else {
                guessesLeft--;
                System.out.println(result+"/"+wordLength + " correct");
            }
        }
        printWinOrLose();
    }

    private static boolean notGameOver() {
        return guessesLeft != 0 && !gameIsWon;
    }

    private static void printWinOrLose() {
        if(gameIsWon) {
            System.out.println("You are victorious");
        } else if(guessesLeft == 0){
            System.out.println("You have ran out of guesses, try again");
        }
    }

    private static int compare(String input) {
        int totalCorrectCharacters = 0;
        char[] inputCharArray = input.toCharArray();
        if(input.length() != winningCombination.length) {
            System.out.println("Please input a string of the same size");
            return 0;
        }
        for (int i = 0; i < inputCharArray.length; i++) {
            if (inputCharArray[i] == winningCombination[i]) {
                totalCorrectCharacters++;
            }
        }
        return totalCorrectCharacters;
    }

    private static List<String> getWords(int difficulty) throws IOException {
        List<String> strings = readFile();
        List<String> sameLengthStrings = getSameLengthStrings(difficulty, strings);
        Set<String> randomWords = extractRandomStrings(sameLengthStrings);
        return new ArrayList<String>(randomWords);
    }

    private static List<String> readFile() throws IOException {
        List<String> strings = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/javadev/tools/eclipse-4.3/workspace/sandbox/src/main/java/fallout/enable1.txt"));
            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return strings;
    }

    private static Set<String> extractRandomStrings(List<String> sameLengthStrings) {
        Set<String> randomWords = new HashSet<String>();
        Random random = new Random();
        //Return between 5 and 15 words
        int setSize = random.nextInt(10) + 5;
        while (randomWords.size() != setSize) {
            randomWords.add(sameLengthStrings.get(random.nextInt(sameLengthStrings.size())));
        }
        return randomWords;
    }

    private static List<String> getSameLengthStrings(int difficulty, List<String> strings) {
        List<String> sameLengthStrings = new ArrayList<String>();
        for (String string : strings) {
            if (string != null && string.length() == difficulty*2 + DIFFICULTY_MULTIPLIER) {
                sameLengthStrings.add(string);
            }
        }
        return sameLengthStrings;
    }

}
