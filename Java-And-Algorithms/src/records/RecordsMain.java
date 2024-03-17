package records;

public class RecordsMain {

    /* Records are useful for creating small immutable objects, so it contains final properties and no setters,
    No inheritance possible
      You can implement interfaces though
      you can override the constructor of records, for example with IllegalArgumentException
      */

    public static void recordsStart() {
        EmployeeClassWithoutRecordUsage employee = new EmployeeClassWithoutRecordUsage("Jerry", 12345);
        System.out.println(employee.toString());

        EmployeeRecord employeeRecord = new EmployeeRecord("Kramer", 54321);
        System.out.println(employeeRecord);
        System.out.println( employeeRecord.myNameWithExclamation());
    }

}
