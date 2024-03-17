package records;

public record EmployeeRecord ( String name, int employeeNumber) {
public String myNameWithExclamation() {
    return name + "!";
}
}
