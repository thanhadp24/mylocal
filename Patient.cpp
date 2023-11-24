#include "Patient.h"

Patient::Patient(string fn, string gender, int age, string phone, string password, string address, string dt)
    :Person(fn, gender, age, phone, password, address)
{
    datetime = dt;
}

Patient::~Patient() {}


ostream& operator<<(ostream& o, const Patient& p)
{
    o << "fullname: " << p.fullname << ", gender: " << p.gender 
    << ", age: " << p.age << ", address: " << p.address << ", datetime: " << p.datetime << endl;
    return o;
}

void Patient::setDatetime(const string & dt)
{
    this->datetime = dt;
}

string Patient::getDatetime()
{
    return this->datetime;
}