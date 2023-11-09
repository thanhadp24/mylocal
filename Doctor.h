#include "Patient.h"
const int MAX = 10;
class Doctor
{
private:
    string id;
    string fullName;
    string faculty;
    string workingTime;

public:
    Patient patients[MAX];
    int size;
    Doctor(string = "", string = "", string = "", string = "");
    ~Doctor();
    void setId(string = "");
    string getId();
    
    void setFullName(string = "");
    string getFullName();

    void setFaculty(string = "");
    string getFaculty();

    void setWorkingTime(string = "");
    string getWorkingTime();

    void addPatient(const Patient&);
    void removePatient(const int = 1);
    bool isEmpty();
    
    friend ostream& operator<< (ostream& , const Doctor&);
};
