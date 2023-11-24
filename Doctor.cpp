#include "Doctor.h"

Doctor::Doctor(string id, string fn, string gender, int age, string phone, string pw, string address, string faculty, string wt)
    : id(id), Person(fn, gender, age, phone, pw, address), faculty(faculty), workingTime(wt)
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

void Doctor::addPatient(Patient &p)
{
    string pathName = "D://code at school//PBL2//output";
    ofstream outputFile(pathName, ios_base::app);

    if (!outputFile.is_open())
    {
        cerr << "Error opening file for writing." << endl;
        return;
    }
    outputFile << this->id << "," << p.getFullName() << "," << p.getGender() << "," 
    << p.getAge() << "," << p.getAddress() << "," << p.getDatetime() << endl;
    this->size++;
    outputFile.close();
}

// void Doctor::removePatient(const int index)
// {
//     for (int i = index; i < this->size; i++)
//     {
//         this->patients[i - 1] = this->patients[i];
//     }
//     this->size--;
// }

ostream &operator<<(ostream &o, const Doctor &d)
{
    o << "id: " << d.id << " || name: " << d.fullname << " || gender: " << d.gender
      << " || working time: " << d.workingTime << endl;
    return o;
}

// bool Doctor::isEmpty()
// {
//     return (this->size == 0);
// }
Patient *Doctor::getPatients()
{
    Patient* res = new Patient[100];
    string pathName = "D://code at school//PBL2//output";
    ifstream file(pathName);
    string line;
    if (!file)
    {
        cout << "Error opening file!\n";
        return NULL;
    }
    int i = 0;
    while (getline(file, line))
    {
        istringstream iss(line);
        string idf, fn, gender, age, address, datetime;

        // Đọc từng giá trị từ iss và gán cho các biến
        getline(iss, idf, ',');
        getline(iss, fn, ',');
        getline(iss, gender, ',');
        getline(iss, age, ',');
        getline(iss, address, ',');
        getline(iss, datetime, ',');
           
        
        // Kiểm tra và tạo đối tượng Doctor nếu dữ liệu hợp lệ
        if (!idf.empty() && !fn.empty() && !gender.empty() && !age.empty() && !address.empty() && !datetime.empty())
        {
           if (idf.compare(this->id) == 0)
           {
                Patient p(fn, gender, stoi(age), "", "", address, datetime);
                res[i++] = p;
           }
        }
        this->size = i;
    }
    return res;
}