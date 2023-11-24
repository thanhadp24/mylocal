#include "Patient.h"

// const int MAX = 10;
class Doctor : public Person
{
private:
    string id;
    string faculty;
    string workingTime;
    // Patient patients[MAX];

public:
    int size;
    Doctor(string = "0", string = "", string = "", int = 0, string = "", string = "", string = "", string = "", string = "");
    ~Doctor();
    void setId(string = "");
    string getId();
    
    void setFaculty(string = "");
    string getFaculty();

    void setWorkingTime(string = "");
    string getWorkingTime();

    void addPatient(Patient&);
    void removePatient(const int = 1);

    Patient* getPatients();
    friend ostream& operator<< (ostream& ,const Doctor&);
};
