#include "Person.h"

using namespace std;

class Patient : public Person
{
private:
    string datetime;
public:
    Patient(string = "", string = "", int = 0, string = "", string = "", string = "", string = "");
    virtual ~Patient();

    friend ostream& operator<< (ostream&, const Patient&);
    
    void setDatetime(const string& = "");
    string getDatetime();
};