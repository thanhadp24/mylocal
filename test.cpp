#include "Utils.h"
#include <iostream>

using namespace std;

int main() {
    string pathNameToReadFile = "D://code at school//PBL2//mockDoctor";
    string pathNameToWriteFile = "D://code at school//PBL2//output";
    string pathNameToStorePatient = "D://code at school//PBL2//mockPatient";
    Utils u;
    u.init(pathNameToReadFile);

    int choice;

    do {
        cout << "Menu:\n";
        cout << "1. Thêm bệnh nhân, chọn khoa và bác sĩ khám\n";
        cout << "2. In ra danh sách bác sĩ và bệnh nhân họ khám\n";
        cout << "3. Thoát\n";
        cout << "Chọn: ";
        cin >> choice;

        switch (choice) {
            case 1:
                u.createPatient(pathNameToStorePatient);
                u.showFaculty();
                u.chooseFaculty();
                break;
            case 2:
                u.show();
                break;
            case 3:
                cout << "Chương trình kết thúc.\n";
                break;
            default:
                cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại.\n";
        }
    } while (choice != 3);

    u.writeDataToFile(pathNameToWriteFile);

    return 0;
}

