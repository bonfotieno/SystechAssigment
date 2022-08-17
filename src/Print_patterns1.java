public class Print_patterns1 {
    public static void main(String[] args) {
        for (int row = 1; row <= 5; row++){
            for (int cols=1; cols <= row; cols++){
                System.out.print(row);
            }
            System.out.println();
        }

        for (int row = 5; row >= 1; row--){
            for (int cols=1; cols <=row; cols++){
                System.out.print(row);
            }
            System.out.println();
        }
    }
}
