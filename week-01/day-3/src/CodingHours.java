public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52


       int codingHours = 6;
       int semester = 17;
       int workDays = 5;
       int workHoursWeekly = 52;
       double codingHoursSemester = 510;
       double codingHoursTotal = 884;


       System.out.println((semester*workDays)*6);
       System.out.print(((codingHoursSemester/codingHoursTotal) * 100));










    }
}