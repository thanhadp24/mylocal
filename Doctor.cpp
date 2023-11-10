#include "Doctor.h"

Doctor::Doctor(string id, string fn, string faculty, string wt)
    : id(id), fullName(fn), faculty(faculty), workingTime(wt)
{
    this->size = 0;
}

Doctor::~Doctor()
{
}

void Doctor::setId(string id)
{
    this->id = id;
}

string Doctor::getId()
{
    return this->id;
}

void Doctor::setFullName(string fn)
{
    this->fullName = fn;
}

string Doctor::getFullName()
{
    return this->fullName;
}

void Doctor::setFaculty(string faculty)
{
    this->faculty = faculty;
}

string Doctor::getFaculty()
{
    return this->faculty;
}

void Doctor::setWorkingTime(string workingTime)
{
    this->workingTime = workingTime;
}

string Doctor::getWorkingTime()
{
    return this->workingTime;
}

void Doctor::addPatient(const Patient &p)
{
    if (size < MAX)
    this->patients[this->size++] = p;
    else 
    cout << "full patient\n";
}

void Doctor::removePatient(const int index)
{
    for (int i = index; i < this->size; i++)
    {
        this->patients[i - 1] = this->patients[i];
    }
    this->size--;
}

ostream& operator<< (ostream& o, const Doctor& d)
{
    o << "id: " << d.id << " || name: " << d.fullName << " || faculty: " << d.faculty << " || working time: " << d.workingTime << endl;
    return o;
}

bool Doctor::isEmpty()
{
    return (this->size == 0);
}