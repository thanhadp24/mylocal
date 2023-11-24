#include "Doctor.h"
#include "iostream"
const int MAX_DOCTOR_SIZE = 20;
const int MAX_PATIENT_SIZE = 100;
class HealthCareManagement
{
private:
    Doctor doctors[MAX_DOCTOR_SIZE];
    Patient patients[MAX_PATIENT_SIZE];
    int doctorSize;
    int patientSize;

public:
    HealthCareManagement();
    ~HealthCareManagement();

    string trim(string = "");
    void init(const string & = "");
    void addDoctor(Doctor &);

    void sign_up();
    bool isValidUsername(string = "");

    void chooseDoctor(const string &faculty, const string & = "", const string & = "");
    void showFacultySchedule(const string & = "");
    void showFaculty();
    void showSchedule(const string& = "", const string& = "");
    void workingTimeInWeek();

    void makeAnAppointment(const string & = "", const string & = "");

    void writeDataToFile(const string & = "");
    void usernameStoring(Patient&);
    void getUsernames();

    bool isValidDatetime(const string & = "", const string& = "", const string& = "");
    
    bool sign_in_Patient(const string & = "", const string & = "");
    bool sign_in_Doctor(const string & = "", const string & = "");

    void menu();
    void menuForPatient();
    void menuForDoctor();

    string getInputWithFormat();
};
