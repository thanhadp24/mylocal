#include "Patient.h"

Patient::Patient(string fn, string gender, int age, string phone, string password, string address)
    :fullname(fn), gender(gender), age(age), phone(phone), password(password), address(address)
{}

Patient::~Patient() {}

void Patient::setFullName(string fn)
{
    this->fullname = fn;
}

string Patient::getFullName()
{
    return this->fullname;
}

void Patient::setGender(string gender)
{
    this->gender = gender;
}

string Patient::getGender()
{
    return this->gender;
}

void Patient::setAge(int age)
{
    this->age = age;
}

int Patient::getAge()
{
    return this->age;
}

void Patient::setAddress(string address)
{
    this->address = address;
}

string Patient::getAddress()
{
    return this->address;
}

void Patient::setPhone(string phone)
{
    this->phone = phone;
}

string Patient::getPhone()
{
    return this->phone;
}

void Patient::setPassword(string password)
{
    this->password = password;
}

string Patient::getPassword()
{
    return this->password;
}

ostream& operator<<(ostream& o, const Patient& p)
{
    o << "fullname: " << p.fullname << ", gender: " << p.gender 
    << ", age: " << p.age << ", address: " << p.address << endl;
    return o;
}
