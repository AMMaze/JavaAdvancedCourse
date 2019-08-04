package Lesson_8.Patients;

public class Patient {
    String firstName, lastName;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient))
            return false;
        Patient patient = (Patient) obj;
        return firstName.equals(patient.getFirstName()) && lastName.equals(patient.getLastName());
    }

    public void print() {
        System.out.println(firstName + " " + lastName);
    }
}
