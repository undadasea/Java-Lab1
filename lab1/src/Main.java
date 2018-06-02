import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static int getMonthNumber(String month, int day){
        int M;
        switch(month) {
            case "January":
            case "january":
                M = 0;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "February":
            case "february":
                M = 1;
                if(day > 29){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "March":
            case "march":
                M = 2;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "April":
            case "april":
                M = 3;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "May":
            case "may":
                M = 4;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "June":
            case "june":
                M = 5;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "July":
            case "july":
                M = 6;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "August":
            case "august":
                M = 7;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "September":
            case "september":
                M = 8;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "October":
            case "october":
                M = 9;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "November":
            case "november":
                M = 10;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "December":
            case "december":
                M = 11;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            default:
                System.out.println("Usage: <day>/int <month>/string <year>/int");
                throw new IllegalArgumentException();
        }
        return M;
    }

    public static String countYearsOld(int D, int M, int Y){
        //check february TODO
        final Calendar today = new GregorianCalendar();
        final Calendar BirthDate = new GregorianCalendar(Y, M, D);
        int years = 0;
        int months = 0;
        int days = 0;

        if(new Date().before(BirthDate.getTime())){
            System.out.println("Usage: <day>/int <month>/string <year>/int");
            throw new IllegalArgumentException("Usage: <day>/int <month>/string <year>/int");
        }

        if (today.get(Calendar.DAY_OF_YEAR) < BirthDate.get(Calendar.DAY_OF_YEAR)){
            years = today.get(Calendar.YEAR) - BirthDate.get(Calendar.YEAR) - 1;
            Calendar BirthDateCopy = BirthDate;
            while(BirthDateCopy.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)) {
                BirthDateCopy.add(Calendar.MONTH, 1);
                months++;
            }
            while(BirthDateCopy.get(Calendar.DAY_OF_YEAR) < today.get(Calendar.DAY_OF_YEAR)){
                BirthDateCopy.add(Calendar.MONTH, 1);
                months++;
            }
            if(BirthDateCopy.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)){
                months--;
                BirthDateCopy.add(Calendar.MONTH, -1);
                days = today.get(Calendar.DAY_OF_YEAR) - BirthDateCopy.get(Calendar.DAY_OF_YEAR);
            }
        } else {
            years = today.get(Calendar.YEAR) - BirthDate.get(Calendar.YEAR);
            Calendar BirthDateCopy = BirthDate;
            while(BirthDateCopy.get(Calendar.DAY_OF_YEAR) < today.get(Calendar.DAY_OF_YEAR)){
                BirthDateCopy.add(Calendar.MONTH, 1);
                months++;
            }
            if (BirthDateCopy.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)) {
                months--;
                days = BirthDateCopy.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR);
            }
        }
        return String.valueOf(years)+" years "+
                String.valueOf(months)+" months and "+
                String.valueOf(days)+" days old";
    }

    public static void main(String[] args) {
        if(args.length != 3){
            throw new IllegalArgumentException();
        }

        try{
            if((Integer.parseInt(args[0]) < 1) || (Integer.parseInt(args[0]) > 31)){
                System.out.println("First parameter should be a single number from 1 to 31");
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e){
            System.out.println("First parameter should be a single number from 1 to 31");
        }


        int month = getMonthNumber(args[1], Integer.parseInt(args[0]));
        System.out.println(countYearsOld((Integer.parseInt(args[0])), month, Integer.parseInt(args[2])));
    }
}
