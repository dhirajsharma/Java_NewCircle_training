public class DaysInMonth {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: DaysInMonth <year> <month>");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int numDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                numDays =  ( ( (year % 4 == 0) && !(year % 100 == 0))
                            || (year % 400 == 0) )? 29 : 28;
                break;
            default:
                System.err.println("Invalid month " + month);
                return;
        }
        System.out.println("Number of Days = " + numDays);
    }
}

