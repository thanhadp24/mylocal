#include "Utils.h"

Utils::Utils(int sD, int sP)
    : doctorSize(sD), patientSize(sP)
{
}
Utils::~Utils() {}

void Utils::init(const string &pathName)
{
    ifstream file(pathName);
    string line;
    if (!file)
    {
        cout << "Error opening file!\n";
        return;
    }

    while (getline(file, line))
    {
        istringstream iss(line);
        string id, fn, faculty, wt;

        // Đọc từng giá trị từ iss và gán cho các biến
        getline(iss, id, ',');
        getline(iss, fn, ',');
        getline(iss, faculty, ',');
        getline(iss, wt, ',');

        // Loại bỏ khoảng trắng từ các giá trị
        id = trim(id);
        fn = trim(fn);
        faculty = trim(faculty);
        wt = trim(wt);

        // Kiểm tra và tạo đối tượng Doctor nếu dữ liệu hợp lệ
        if (!id.empty() && !fn.empty() && !faculty.empty() && !wt.empty())
        {
            Doctor doctor(id, fn, faculty, wt);
            addDoctor(doctor);
        }
    }
}

string Utils::trim(string str)
{
    // Loại bỏ khoảng trắng ở đầu chuỗi
    while (!str.empty() && isspace(str.front()))
    {
        str.erase(str.begin());
    }

    // Loại bỏ khoảng trắng ở cuối chuỗi
    while (!str.empty() && isspace(str.back()))
    {
        str.pop_back();
    }

    return str;
}

void Utils::addDoctor(Doctor &d)
{
    if (this->doctorSize < MAX_DOCTOR_SIZE)
    {
        this->doctors[doctorSize++] = d;
    }
    else
    {
        cout << "max doctors\n";
    }
}

// bool Utils::isExistDoctorId(Doctor &d)
// {
//     for (int i = 0; i < doctorSize; i++)
//     {
//         if (d.getId().compare(this->doctors[i].getId()) == 0)
//         {
//             return true;
//         }
//     }
//     return false;
// }

Doctor Utils::createDoctor()
{
    string id, fn, faculty, wt;
    cout << "Nhập id: ";
    cin >> id;
    cout << "Nhập họ tên: ";
    cin >> fn;
    cout << "Nhập khoa: ";
    cin >> faculty;
    cout << "Nhập thời gian làm việc: ";
    cin >> wt;

    return Doctor(id, fn, faculty, wt);
}

void Utils::createPatient(const string &pathName)
{
    string fn, gender, phone, password, address;
    int age;

    cout << "Nhập họ tên bệnh nhân: ";
    cin >> fn;
    cout << "Nhập giới tính: ";
    cin >> gender;
    cout << "Nhập tuổi: ";
    cin >> age;
    cin.ignore();
    cout << "Nhập địa chỉ: ";
    cin >> address;
    cout << "Tên đăng nhập(số điện thoại): ";
    cin >> phone;
    cout << "Mật khẩu: ";
    cin >> password;

    Patient p = Patient(fn, gender, age, phone, password, address);
    if (this->patientSize < MAX_PATIENT_SIZE)
        this->patients[this->patientSize++] = p;
}

void Utils::show()
{
    cout << "\n------------- Lịch khám bệnh ------------\n";
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];
        if (!doctor.isEmpty())
        {
            cout << "Bác sĩ thứ: " << (i + 1) << endl;
            cout << doctor;
            for (int j = 0; j < doctor.size; j++)
            {
                cout << "\nBệnh nhân:\n";
                Patient patient = doctor.patients[j];
                cout << patient;
            }
            cout << "\n==================================================================\n\n";
        }
    }
}

void Utils::showFaculty()
{
    cout << "--------------FACULTY--------------\n";
    cout << "1. Khoa nội" << endl;
    cout << "2. Khoa ngoại" << endl;
    cout << "3. Khoa da liễu" << endl;
    cout << "4. Khoa răng hàm mặt" << endl;
    cout << "5. Khoa tai mũi họng" << endl;
}

void Utils::chooseFaculty()
{
    cout << "\nChọn khoa bạn muốn khám: ";
    int choose;
    cin >> choose;
    cout << "------------ Thông tin giờ khám -------------\n";
    switch (choose)
    {
    case 1:
        showFacultySchedule("khoa nội");
        makeAnApointment("khoa nội");
        break;
    case 2:
        showFacultySchedule("khoa ngoại");
        makeAnApointment("khoa ngoại");
        break;
    case 3:
        showFacultySchedule("khoa da liễu");
        makeAnApointment("khoa da liễu");
        break;
    case 4:
        showFacultySchedule("khoa răng hàm mặt");
        makeAnApointment("khoa răng hàm mặt");
        break;
    case 5:
        showFacultySchedule("khoa tai mũi họng");
        makeAnApointment("khoa tai mũi họng");
        break;
    default:
        break;
    }
}

void Utils::makeAnApointment(const string &faculty)
{
    Patient p;
    bool check = true;
    cout << "\nĐăng nhập:\n";
    while (check)
    {
        string username, password;
        cout << "\nVui lòng nhập tài khoản: ";
        cin >> username;
        cout << "Vui lòng nhập mật khẩu: ";
        cin >> password;
        for (int i = 0; i < this->patientSize; i++)
        {
            Patient patient = this->patients[i];
            if (patient.getPhone().compare(username) == 0 && patient.getPassword().compare(password) == 0)
            {
                check = false;
                p = patient;
                break;
            }
        }
        if (check)
            cout << "\nBạn nhập sai tài khoản hoặc mật khẩu vui lòng nhập lại!!!\n";
    }
    string choose;
    cout << "\nChọn ca khám bạn mong muốn theo id bác sĩ: ";
    cin >> choose;
    
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor &doctor = this->doctors[i];
        if (doctor.getFaculty().compare(faculty) == 0 && doctor.getId().compare(choose) == 0) 
        {
            doctor.addPatient(p);
        }
    }
}

void Utils::showFacultySchedule(const string &faculty)
{
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];
        string facultyOfDoctor = doctor.getFaculty();
        if (facultyOfDoctor.compare(faculty) == 0)
        {
            cout << doctor;
        }
    }
}

void Utils::writeDataToFile(const string &pathName)
{

    ofstream outputFile(pathName, ios_base::app);

    if (!outputFile.is_open())
    {
        std::cerr << "Error opening file for writing." << std::endl;
        return;
    }

    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];

        if (!doctor.isEmpty())
        {
            outputFile << "Bác sĩ: " << doctor.getFullName() << ", id: " << doctor.getId() << ", khoa: "
                       << doctor.getFaculty() << ", thời gian làm việc: " << doctor.getWorkingTime() << "\n";

            outputFile << "Danh sách bệnh nhân đã khám:\n";

            for (int j = 0; j < doctor.size; j++)
            {
                Patient patient = doctor.patients[j];
                outputFile << "Bệnh nhân:\n";
                outputFile << (j + 1) << ". Họ tên: " << patient.getFullName() << ", giới tính: " << patient.getGender() << ", tuổi: "
                           << patient.getAge() << ", địa chỉ: " << patient.getAddress() << endl;
                outputFile << endl;
            }
        }
    }

    outputFile.close();
}
