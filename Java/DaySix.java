import java.util.Arrays;

public class DaySix
{
    public static void main(String[] args)
    {
        String input = "Dormitory ? Dirty room\n" +
                "Conversation ? Voices rant on\n" +
                "The eyes ? They see\n" +
                "Inch ? Chins\n" +
                "Fourth of July ? Joyful Fourth\n" +
                "Elbow ? Below\n" +
                "The Morse Code ? Here come the dots\n" +
                "Astronomer ? Moon starer\n" +
                "Vacation Time ? I'm Not as Active\n" +
                "Listen ? Silent\n" +
                "Eleven plus two ? Twelve plus one";

        String[] line = input.split("\n");
        String[][] wordSet = new String[line.length][2];

        for(int i = 0; i < line.length; i++)
            for (int j = 0; j < 2; j++)
                wordSet[i][j] = line[i].split("\\?")[j].trim();


        for(String[] cur: wordSet)
            System.out.println( "\"" + cur[0] + "\"" + (isAnagram(cur[0], cur[1]) ? " is an anagram of " : " is NOT an anagram of ") +  "\"" + cur[1] + "\"");


    }

    private static boolean isAnagram(String str1, String str2)
    {
        char[] charArr1;
        char[] charArr2;

        charArr1 = str1.toLowerCase()
                .replaceAll("'", "")
                .replaceAll("\\s", "")
                .toCharArray();
        charArr2 = str2.toLowerCase()
                .replaceAll("'", "")
                .replaceAll("\\s", "")
                .toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        return Arrays.equals(charArr1, charArr2);
    }
}
