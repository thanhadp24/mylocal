#include <stdio.h>
#include <stdbool.h>
#define N 10005

struct Canh{
	int dinh1,dinh2;
	int trongso;
};

typedef struct Canh C;

int canh,dinh;
int M[N][N];
bool used[N];
C parent[N], d[N];
C MST[N];
int dM=0;

void Nhap()
{
	printf("Nhap so canh: ");
	scanf("%d",&canh);
	printf("\nNhap so dinh: ");
	scanf("%d",&dinh);
	
	int i,j,x,y,w;
	for(i=1;i<=dinh;i++)
	{
		for(j=1;j<=dinh;j++)
			M[i][j]=0;
	}
	
	for(i=1;i<=canh;i++)
	{
		scanf("%d %d %d", &x,&y,&j);
		M[x][y]=j;
	}
	
	for(i=1;i<=dinh;i++)
		used[i] = false;
}


void Prime(int u)
{
	int k=1;
	parent[k].trongso = 0;
	parent[k].dinh2 = u;
	parent[k].dinh1 = u;
	
	int e = u;
	int i=1,j;
	while(i < dinh)
	{
		used[e] = true;
		for(j=1;j<=dinh;j++)
		{
			if(!used[j] && M[e][j]!=0)
			{
				++k;
				parent[k].trongso = M[e][j];
				parent[k].dinh1 = e;
				parent[k].dinh2 = j;
			}
			
			if(!used[j] && M[j][e]!=0)
			{
				++k;
				parent[k].trongso = M[j][e];
				parent[k].dinh1 = e;
				parent[k].dinh2 = j;
			}
		}
		
		int min_w = N;
		int Y,X;
		for(j=1;j<=k;j++)
		{
			if(!used[parent[j].dinh2] && parent[j].trongso<min_w)
			{
				min_w = parent[j].trongso;
				Y = parent[j].dinh2;
				X = parent[j].dinh1;
			}
		}
		
		MST[i].dinh1 = X;
		MST[i].dinh2 = Y;
		MST[i].trongso = min_w;
		
		e = Y;
		
		dM+=MST[i].trongso;
		i++;	
		}
	for(k=1;k<=i;k++)
		printf("\n %d %d %d",MST[k].dinh1,MST[k].dinh2,MST[k].trongso);
		
	printf("\nTONG TRONG SO CUA CAY KHUNG LA: %d",dM);
}
	


int main()
{
	Nhap();
	int u;
	printf("Nhap dinh bat dau: ");
	scanf("%d",&u);
	while(u>dinh)
	{
		printf("NHAP SAI!!! MOI NHAP LAI: ");
		scanf("%d",&u);
	}
	Prime(u);
	return 0;
}