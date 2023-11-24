#include "Person.h"

Person::Person(string fn, string gender, int age, string username, string pw, string address)
    :fullname(fn), gender(gender), age(age), username(username), password(pw), address(address)
{

}

Person::~Person(){}

void Person::setFullName(string fn)
{
    this->fullname = fn;
}

string Person::getFullName()
{
    return this->fullname;
}

void Person::setGender(string gender)
{
    this->gender = gender;
}

string Person::getGender()
{
    return this->gender;
}

void Person::setAge(int age)
{
    this->age = age;
}

int Person::getAge()
{
    return this->age;
}

void Person::setAddress(string address)
{
    this->address = address;
}

string Person::getAddress()
{
    return this->address;
}

void Person::setUsername(string username)
{
    this->username = username;
}

string Person::getUsername()
{
    return this->username;
}

void Person::setPassword(string password)
{
    this->password = password;
}

string Person::getPassword()
{
    return this->password;
}
