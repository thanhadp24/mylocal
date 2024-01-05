#include <bits/stdc++.h>
using namespace std;

void workingTimeInWeek()
{
    // Lấy thời gian hiện tại
    time_t now = time(0);
    tm *ltm = localtime(&now);
    
    // Tìm ngày hiện tại
    string now1;
    cout << "Từ: ";
    switch (ltm->tm_wday)
    {
    case 0:
        cout << "Ngày nghỉ, không làm việc ";
        break;
    case 1:
        cout << "Thứ hai ";
        now1 = "Thứ hai";
        break;
    case 2:
        cout << "Thứ ba ";
        now1 = "Thứ ba";
        break;
    case 3:
        cout << "Thứ tư ";
        now1 = "Thứ tư";
        break;
    case 4:
        cout << "Thứ năm ";
        now1 = "Thứ năm";
        break;
    case 5:
        cout << "Thứ sáu ";
        now1 = "Thứ sáu";
        break;
    case 6:
        cout << "Thứ bảy ";
        now1 = "Thứ bảy";
        break;
    }
    cout << ltm->tm_mday << "/" << 1 + ltm->tm_mon << "/" << 1900 + ltm->tm_year;

    // Tìm ngày khám tuần sau
    int daysUntilSaturday = 6 - ltm->tm_wday;
    time_t nextSaturday = now + daysUntilSaturday * 24 * 60 * 60;
    tm *nextSat = localtime(&nextSaturday);

    cout << " đến " << now1 << " : " << ltm->tm_mday + 6 << "/" << 1 + ltm->tm_mon << "/" << 1900 + ltm->tm_year << endl;
}

int main()
{
    workingTimeInWeek();
};