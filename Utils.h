#include "Doctor.h"
#include "iostream"
const int MAX_DOCTOR_SIZE = 20;
const int MAX_PATIENT_SIZE = 100;
class Utils
{
private:
    Doctor doctors[MAX_DOCTOR_SIZE];
    Patient patients[MAX_PATIENT_SIZE];
    int doctorSize;
    int patientSize;

public:
    Utils(int = 0, int = 0);
    ~Utils();

    string trim(string = "");
    void init(const string & = "");
    void addDoctor(Doctor &);
    void show();

    void createPatient(const string & = "");
    Doctor createDoctor();

    void makeAnApointment(const string &faculty);
    void showFacultySchedule(const string & = "");
    void showFaculty();
    void chooseFaculty();
    //bool isExistDoctorId(Doctor&);

    void writeDataToFile(const string & = "");
};
