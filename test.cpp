#include "Utils.h"
using namespace std;

int main()
{
    string pathNameToReadFile = "D://code at school//PBL2//mockDoctor";
    string pathNameToWriteFile = "D://code at school//PBL2//output";
    Utils u;
    u.init(pathNameToReadFile);
    u.createPatient();
    u.showFaculty();
    u.chooseFaculty();
    u.show();
    u.writeDataToFile(pathNameToWriteFile);
    return 0;
}