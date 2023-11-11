#include "Utils.h"
#include <iostream>

using namespace std;

int main()
{
    string pathNameToReadFile = "D://code at school//PBL2//mockDoctor";
    string pathNameToWriteFile = "D://code at school//PBL2//output";
    string pathNameToStorePatient = "D://code at school//PBL2//patientTemp";
    Utils u;
    u.init(pathNameToReadFile);

    int choice;

    do
    {
        cout << "Menu:\n";
        cout << "1. Đăng ký tài khoản bệnh nhân\n";
        cout << "2. Chọn khoa và bác sĩ khám bênh\n";
        cout << "3. In ra danh sách bác sĩ và bệnh nhân họ khám\n";
        cout << "4. Thoát\n";
        cout << "Chọn: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            u.createPatient(pathNameToStorePatient);
            break;
        case 2:
            u.showFaculty();
            u.chooseFaculty();
            break;
        case 3:
            u.show();
            break;
        case 4:
            cout << "Chương trình kết thúc.\n";
            break;
        default:
            cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại.\n";
        }
    } while (choice != 4);

    u.writeDataToFile(pathNameToWriteFile);

    return 0;
}
