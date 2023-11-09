#include <bits/stdc++.h>

using namespace std;

class Patient
{
private:
    string fullname;
    string gender;
    int age;
    string phone; // username
    string password;
    string address;
    

public:
    Patient(string = "", string = "", int = 0, string = "", string = "", string = "");
    virtual ~Patient();

    void setFullName(string = "");
    string getFullName();
    
    void setGender(string = "");
    string getGender();
    
    void setAge(int = 0);
    int getAge();
    
    void setPhone(string = "");
    string getPhone();

    void setPassword(string = "");
    string getPassword();

    void setAddress(string = "");
    string getAddress();
    
 
    friend ostream& operator<<(ostream&, const Patient&);
  
};