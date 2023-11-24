#include <bits/stdc++.h>
using namespace std;
class Person
{
protected:
    string fullname;
    string gender;
    int age;
    string username;
    string password;
    string address;

public:
    Person(string = "", string = "", int = 0, string = "", string = "", string = "");
    virtual ~Person();

    void setFullName(string = "");
    string getFullName();

    void setGender(string = "");
    string getGender();

    void setAge(int = 0);
    int getAge();

    void setUsername(string = "");
    string getUsername();

    void setPassword(string = "");
    string getPassword();

    void setAddress(string = "");
    string getAddress();
};
