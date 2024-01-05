#include "Patient.h"

const int MAX = 100;
class Doctor : public Person
{
private:
    string id;
    string faculty;
    string workingTime;
    Patient patients[MAX];

public:
    int size;
    Doctor(string = "0", string = "", string = "", int = 0, string = "", string = "", string = "", string = "", string = "");
    virtual ~Doctor();
    void setId(string = "");
    string getId();
    
    void setFaculty(string = "");
    string getFaculty();

    void setWorkingTime(string = "");
    string getWorkingTime();

    void addPatient(Patient&);

    Patient* getPatients();
    friend ostream& operator<< (ostream& ,const Doctor&);
};
