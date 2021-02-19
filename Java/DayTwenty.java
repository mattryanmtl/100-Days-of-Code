public class Display {
    public static void main(String[] args) {
        Display pd = new Display();
            pd.setAssoc("5647");
    }

    public void setAssoc(String inputn) {

    String[][] nums = {
            { "+--+ ", "   + ", "+--+ ", "+--+ ", "+  + ", "+--+ ","+--+ ", "+--+ ", "+--+ ", "+--+ " },
            { "|  | ", "   | ", "   | ", "   | ", "|  | ", "|    ","   | ", "   | ", "|  | ", "|  | " },
            { "|  | ", "   | ", "   | ", "   | ", "|  | ", "|    ","   | ", "   | ", "|  | ", "|  | " },
            { "+  + ", "   + ", "+--+ ", "+--+ ", "+--+ ", "+--+ ","+--+ ", "   + ", "+--+ ", "+--+ " },
            { "|  | ", "   | ", "|    ", "   | ", "   | ", "   | ","|  | ", "   | ", "|  | ", "   | " },
            { "|  | ", "   | ", "|    ", "   | ", "   | ", "   | ","|  | ", "   | ", "|  | ", "   | " },
            { "+--+ ", "   + ", "+--+ ", "+--+ ", "   | ", "+--+ ","+--+ ", "   + ", "+--+ ", "+--+ " } };

              for (int i = 0; i < 7; i++) {
                  for (int j = 0; j < inputn.length(); j++) {
                           int index = inputn.charAt(j) - 48;
                           System.out.print(nums[i][index]);
                  }
               System.out.println();
              }
      }
}
