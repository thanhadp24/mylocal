#include <stdio.h>
#define N 10005

int dinh,canh;
int M[N][N];
int A[N][N];

void Nhap()
{
	printf("Nhap so dinh: ");
	scanf("%d",&dinh);
	printf("\nNhap so canh: ");
	scanf("%d",&canh);
	int i,j,m,n;
	for(i=1;i<=dinh;i++)
	{
		for(j=1;j<=dinh;j++)
		{
			if(i==j)
			{
				M[i][j]=0;
				A[i][j]=0;
			}else
			{
				M[i][j]=N;
				A[i][j]=N;
			}
		}
	}
	printf("\nNhap trong so: \n");
	for(i=1;i<=canh;i++)
	{
		scanf("%d %d %d",&m,&n,&j);
		M[m][n]=j;
		A[m][n]=j;
	}
}

int min(int a,int b)
{
	if(a<b) return a;
	else return b;
}

void Floy_Warshall()
{
	int i,j,k;
	for(k=1;k<=dinh;k++)
	{
		for(i=1;i<=dinh;i++)
		{
			for(j=1;j<=dinh;j++)
			{
				if(k!=i && k!=j)
				{
					A[i][j] = min(A[i][j],A[i][k]+A[k][j]);
				}
			}
		}
	}
}

int main()
{
	Nhap();
	Floy_Warshall();
	int n,m;
	printf("\nNhap 2 dinh ma ban muon tim duong di!!!\n");
	scanf("%d %d",&n,&m);
	if(M[n][m]==N)
		printf("\nBan dau khong ton tai duong di tu %d -> %d",n,m);
	else printf("\nDuong di ban dau tu %d -> %d la: %d",n,m,M[n][m]);
	printf("\nDuong di ngan nhat tu %d -> %d la: %d",n,m,A[n][m]);

	return 0;
}