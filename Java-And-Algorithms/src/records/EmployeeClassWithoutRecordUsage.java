package records;

import java.util.Objects;

public class EmployeeClassWithoutRecordUsage {

    private final String name;
    private final int employeeNumber;

    public EmployeeClassWithoutRecordUsage(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }



    public int getEmployeeNumber() {
        return employeeNumber;
    }



    @Override
    public String toString() {
        return "EmployeeClass{" +
                "name='" + name + '\'' +
                ", employeeNumber=" + employeeNumber +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeClassWithoutRecordUsage that = (EmployeeClassWithoutRecordUsage) o;
        return employeeNumber == that.employeeNumber && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeeNumber);
    }

}
