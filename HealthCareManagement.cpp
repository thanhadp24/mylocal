#include "HealthCareManagement.h"

HealthCareManagement::HealthCareManagement()
{
    this->doctorSize = 0;
    this->patientSize = 0;
}

HealthCareManagement::~HealthCareManagement() {}

void HealthCareManagement::init(const string &pathName)
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
        string id, fn, gender, age, phone, password, address, faculty, wt;

        // Đọc từng giá trị từ iss và gán cho các biến
        getline(iss, id, ',');
        getline(iss, fn, ',');
        getline(iss, gender, ',');
        getline(iss, age, ',');
        getline(iss, phone, ',');
        getline(iss, password, ',');
        getline(iss, address, ',');
        getline(iss, faculty, ',');
        getline(iss, wt, ',');

        id = trim(id);
        fn = trim(fn);
        gender = trim(gender);
        age = trim(age);
        phone = trim(phone);
        password = trim(password);
        address = trim(address);
        faculty = trim(faculty);
        wt = trim(wt);

        // Kiểm tra và tạo đối tượng Doctor nếu dữ liệu hợp lệ
        if (!id.empty() && !fn.empty() && !gender.empty() && !age.empty() && !phone.empty() && !password.empty() && !address.empty() && !faculty.empty() && !wt.empty())
        {
            Doctor doctor(id, fn, gender, stoi(age), phone, password, address, faculty, wt);
            addDoctor(doctor);
        }
    }
}

string HealthCareManagement::trim(string str)
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

void HealthCareManagement::addDoctor(Doctor &d)
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

void HealthCareManagement::sign_up()
{
    getUsernames();
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
    bool check = false;
    do
    {
        cout << "Tên đăng nhập: ";
        cin >> phone;
        check = !isValidUsername(phone);
        if (check)
        {
            cout << "Tài khoản đã tồn tại, vui lòng nhập tài khoản khác!\n";
        }
    } while (check);

    cout << "Mật khẩu: ";
    cin >> password;

    Patient p = Patient(fn, gender, age, phone, password, address);

    usernameStoring(p);
    cout << "Bạn đã đăng ký thành công\n";
}

bool HealthCareManagement::isValidUsername(string us)
{
    for (int i = 0; i < this->patientSize; i++)
    {
        Patient patient = this->patients[i];
        if (patient.getUsername().compare(us) == 0)
        {
            return false;
        }
    }
    return true;
}

void HealthCareManagement::showFaculty()
{
    cout << "--------------FACULTY--------------\n";
    cout << "1. Khoa nội" << endl;
    cout << "2. Khoa ngoại" << endl;
    cout << "3. Khoa da liễu" << endl;
    cout << "4. Khoa răng hàm mặt" << endl;
    cout << "5. Khoa tai mũi họng" << endl;
}

void HealthCareManagement::makeAnAppointment(const string &un, const string &pw)
{
    showFaculty();
    cout << "\nChọn khoa bạn muốn khám: ";
    int choose;
    cin >> choose;
    cout << "------------ Thông tin giờ khám -------------\n";
    switch (choose)
    {
    case 1:
        showFacultySchedule("khoa nội");
        chooseDoctor("khoa nội", un, pw);
        break;
    case 2:
        showFacultySchedule("khoa ngoại");
        chooseDoctor("khoa ngoại", un, pw);
        break;
    case 3:
        showFacultySchedule("khoa da liễu");
        chooseDoctor("khoa da liễu", un, pw);
        break;
    case 4:
        showFacultySchedule("khoa răng hàm mặt");
        chooseDoctor("khoa răng hàm mặt", un, pw);
        break;
    case 5:
        showFacultySchedule("khoa tai mũi họng");
        chooseDoctor("khoa tai mũi họng", un, pw);
        break;
    default:
        break;
    }
}

void HealthCareManagement::chooseDoctor(const string &faculty, const string &un, const string &pw)
{
    getUsernames();
    Patient p;
    for (int i = 0; i < this->patientSize; i++)
    {
        Patient patient = this->patients[i];

        if (patient.getUsername().compare(un) == 0 && patient.getPassword().compare(pw) == 0)
        {
            p = patient;
            break;
        }
    }

    string choose;
    cout << "\nChọn bác sĩ theo id: ";
    cin >> choose;
    string datetime;
    bool check = true;
    do
    {
        cout << "Chọn thời gian khám theo định dạng (dd/MM/yyyy hh): ";
        cin >> datetime;
        if (isValidDatetime(datetime, choose, faculty))
        {
            p.setDatetime(datetime);
            for (int i = 0; i < this->doctorSize; i++)
            {
                Doctor &doctor = this->doctors[i];
                if (doctor.getFaculty().compare(faculty) == 0 && doctor.getId().compare(choose) == 0)
                {
                    doctor.addPatient(p);
                    cout << "Bạn đặt lịch thành công";
                    check = false;
                    break;
                }
            }
        }
        else
        {
            cout << "Thời gian này đã có người đặt!\n";
        }
    } while (check);
}

bool HealthCareManagement::isValidDatetime(const string &datetime, const string &id, const string &faculty)
{
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];
        if (doctor.getFaculty().compare(faculty) == 0 && doctor.getId().compare(id) == 0)
        {
            Patient *ps = doctor.getPatients();
            for (int j = 0; j < doctor.size; j++)
            {
                if (ps[j].getDatetime().compare(datetime) == 0)
                {
                    return false;
                }
            }
        }
    }
    return true;
}

void HealthCareManagement::showFacultySchedule(const string &faculty)
{
    cout << "-------------- " << faculty << " ----------------\n";
    cout << "----------- Thời Gian Khám Bệnh -----------\n";
    workingTimeInWeek();
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

void HealthCareManagement::workingTimeInWeek()
{
    // Lấy thời gian hiện tại
    time_t now = time(0);
    tm *ltm = localtime(&now);

    time_t nextDay = now + 24 * 60 * 60;
    tm *next = localtime(&nextDay);
    // Tìm ngày hiện tại
    cout << "Từ: ";
    switch (ltm->tm_wday)
    {
    case 0:
        cout << "Ngày nghỉ, không làm việc ";
        break;
    case 1:
        cout << "Thứ hai ";
        break;
    case 2:
        cout << "Thứ ba ";
        break;
    case 3:
        cout << "Thứ tư ";
        break;
    case 4:
        cout << "Thứ năm ";
        break;
    case 5:
        cout << "Thứ sáu ";
        break;
    case 6:
        cout << "Thứ bảy ";
        break;
    }
    cout << ltm->tm_mday << "/" << 1 + ltm->tm_mon << "/" << 1900 + ltm->tm_year;

    // Tìm ngày thứ bảy trong tuần hiện tại
    int daysUntilSaturday = 6 - ltm->tm_wday;
    time_t nextSaturday = now + daysUntilSaturday * 24 * 60 * 60;
    tm *nextSat = localtime(&nextSaturday);

    cout << " đến thứ bảy: " << nextSat->tm_mday << "/" << 1 + nextSat->tm_mon << "/" << 1900 + nextSat->tm_year << endl;
}

void HealthCareManagement::showSchedule(const string &un, const string &pw)
{
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];
        if (doctor.getUsername().compare(un) == 0 && doctor.getPassword().compare(pw) == 0)
        {

            Patient* ps = doctor.getPatients();
            
            for (int j = 0; j < doctor.size; j++)
            {
                cout << ps[j];
            }
        }
    }
}

bool HealthCareManagement::sign_in_Patient(const string &username, const string &password)
{
    getUsernames();
    for (int i = 0; i < this->patientSize; i++)
    {
        Patient patient = this->patients[i];
        if (patient.getUsername().compare(username) == 0 && patient.getPassword().compare(password) == 0)
        {
            return true;
        }
    }
    return false;
}

bool HealthCareManagement::sign_in_Doctor(const string &username, const string &password)
{
    for (int i = 0; i < this->doctorSize; i++)
    {
        Doctor doctor = this->doctors[i];
        if (doctor.getUsername().compare(username) == 0 && doctor.getPassword().compare(password) == 0)
        {
            return true;
        }
    }
    return false;
}

void HealthCareManagement::menuForPatient()
{
    string pathName = "D://code at school//PBL2//DoctorsData";
    int choose1;
    string un, pw;
    do
    {
        system("cls");
        cout << "--------- MENU CHỨC NĂNG BỆNH NHÂN ---------\n";
        cout << "1. Đăng ký thông tin\n";
        cout << "2. Đăng nhập\n";
        cout << "3. Thoát\n";

        cout << "Vui lòng chọn chức năng bạn muốn sử dụng: ";
        cin >> choose1;
        switch (choose1)
        {
        case 1:
            system("cls");
            sign_up();
            break;
        case 2:
            system("cls");
            cout << "Nhập username: ";
            cin >> un;
            cout << "Nhập password: ";
            cin >> pw;
            if (sign_in_Patient(un, pw))
            {
                system("cls");
                int choose2;
                cout << "1. Đăng ký lịch khám bệnh\n";
                cout << "2. Thoát\n";
                cout << "Vui lòng chọn chức năng bạn muốn sử dụng:";
                cin >> choose2;
                if (choose2 == 1)
                {
                    system("cls");
                    this->init(pathName);
                    makeAnAppointment(un, pw);
                    break;
                }
                else
                    break;
            }
            break;
        }
    } while (choose1 != 3);
}

void HealthCareManagement::menuForDoctor()
{
    string pathName = "D://code at school//PBL2//DoctorsData";
    int choose;
    int choose2;
    string un, pw;
    do
    {
        cout << "---------- MENU CHỨC NĂNG BÁC SĨ ----------\n";
        cout << "1. Đăng nhập\n";
        cout << "2. Thoát\n";

        cout << "Vui lòng chọn chức năng bạn muốn: ";
        cin >> choose;
        if (choose == 1)
        {
            system("cls");
            this->init(pathName);
            cout << "Nhập username: ";
            cin >> un;
            cout << "Nhập password: ";
            cin >> pw;
            if (sign_in_Doctor(un, pw))
            {
                system("cls");
                cout << "1. Lịch khám trong tuần\n";
                cout << "2. Thoát\n";
                cout << "Vui lòng chọn chức năng bạn muốn sử dụng:";
                cin.ignore();
                cin >> choose2;
                
                switch(choose2){
                    case 1: system("cls");
                            showSchedule(un, pw);
                            break;
                }
                
            }
            else
                cout << "Tài khoản mật khẩu không chính xác\n";
        }
        else if (choose == 2)
        {
            break;
        }
        else
        {
            cout << "Vui lòng chọn hợp lí\n";
        }
    } while (true);
}

void HealthCareManagement::menu()
{
    cout << "|------------------------------- PBL2 -------------------------------|\n";
    cout << "|-------------------- Quản Lý Đặt Lịch Khám Bệnh --------------------|\n";
    cout << "- Giáo Viên Hướng Dẫn : Trần Hồ Thủy Tiên. \n";
    cout << "Danh sách sinh viên thực hiên:\n";
    cout << "1. Trần Phước Thành\n";
    cout << "2. Huỳnh Vũ Huy\n";

    cout << "\n Nhấn phím bất kì để tiếp tục chương trình.\n";
    getchar();
    cout << endl;
    int choose;
    do
    {
        system("cls");
        cout << "----------- CHỨC NĂNG -----------\n";
        cout << "1. Bệnh nhân\n";
        cout << "2. Bác sĩ\n";
        cout << "3. Thoát\n";

        cout << "Vui lòng chọn chức năng bạn muốn sử dụng: ";
        cin >> choose;
        switch (choose)
        {
        case 1:
            system("cls");
            menuForPatient();
            break;
        case 2:
            system("cls");
            menuForDoctor();
            break;
        default:
            cout << "";
        }
    } while (choose != 3);
}

void HealthCareManagement::usernameStoring(Patient &p)
{
    string pathName = "D://code at school//PBL2//patientsData";
    ofstream outputFile(pathName, ios_base::app);

    if (!outputFile.is_open())
    {
        std::cerr << "Error opening file for writing." << std::endl;
        return;
    }

    outputFile << p.getFullName() << "," << p.getGender() << "," << p.getAge() << "," << p.getUsername() << "," << p.getPassword() << "," << p.getAddress() << endl;

    outputFile.close();
}

void HealthCareManagement::getUsernames()
{
    string pathName = "D://code at school//PBL2//patientsData";
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
        string fn, gender, age, us, password, address;

        // Đọc từng giá trị từ iss và gán cho các biến
        getline(iss, fn, ',');
        getline(iss, gender, ',');
        getline(iss, age, ',');
        getline(iss, us, ',');
        getline(iss, password, ',');
        getline(iss, address, ',');

        // Kiểm tra và tạo đối tượng Doctor nếu dữ liệu hợp lệ
        if (!fn.empty() && !gender.empty() && !age.empty() && !us.empty() && !password.empty() && !address.empty())
        {
            Patient p(fn, gender, stoi(age), us, password, address);
            if (this->patientSize < MAX_PATIENT_SIZE)
            {
                this->patients[this->patientSize++] = p;
            }
        }
    }
}