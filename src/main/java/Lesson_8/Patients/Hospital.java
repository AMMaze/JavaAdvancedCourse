package Lesson_8.Patients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private List<Patient> patients = new LinkedList<>();

    Hospital(Patient... patients) {
        this.patients.addAll(Arrays.asList(patients));
    }

    public void admitPatient(Patient patient) {
        if (!patients.contains(patient))
            patients.add(patient);
    }

    public void dischargePatient(Patient patient) {
        patients.remove(patient);
    }

    public void dischargeInOrder() {
        if (patients.size() != 0)
            patients.remove(patients.get(0));
    }

    public void printPatients() {
        for(Patient it : patients) {
            it.print();
        }
    }
}
