#include <stdio.h>
#include <stdbool.h>
#define N 10005

struct Road{
	int parent;
	int TrongSo;	
};

typedef struct Road road;

int dinh,canh;
int M[N][N];
bool marked[N];
road R[N];

void Nhap()
{
	printf("Nhap so dinh: ");
	scanf("%d",&dinh);
	printf("\nNhap so canh: ");
	scanf("%d",&canh);
	
	int i,j,m,n;
	for(i=1; i<=dinh; i++)
	{
		for(j=1; j<=dinh; j++)
		{
			M[i][j] = 0;
		}
	}
	
	printf("\nNhap trong so: \n");
	for(i=1;i<=canh;i++)
	{
		scanf("%d %d %d",&m,&n,&j);
		M[m][n]=j;
	}
	
	for(i=1;i<=dinh;i++)
	{
		marked[i] = false;
		R[i].parent = 0;
		R[i].TrongSo = N;
	}
}

int min(int a, int b)
{
	if(a<b) return a;
	else return b;
}

void DuongDi(int a, int b)
{
	int x = R[b].parent;
	if(x!=0)
	{
		DuongDi(a,x);
		printf("%d -> ",x);
	}
}
//do thi co huong
void dijkstra1(int n)
{
	R[n].TrongSo = 0;
	marked[n] = true;
	int i,j,k=1;
	while(k<dinh-1)
	{
		for(i=1;i<=dinh;i++)
		{
			if(marked[i])
			{
				for(j=1;j<=dinh;j++)
				{
					if(M[i][j] != 0)
					{	
						int z = R[j].TrongSo;
						R[j].TrongSo = min(R[j].TrongSo, R[i].TrongSo + M[i][j]);
						
						if(R[j].TrongSo != z)
							R[j].parent = i;
						marked[j] = true;
					}
				}
			}
		}
		k++;
	}
	
	for(i=1;i<=dinh;i++)
	{
		if(R[i].TrongSo == N)
			printf("\nKHONG CO DUONG DI TU %d->%d",n,i);
		else
		{
			printf("\nDuong di ngan nhat tu %d -> %d la: %d\t|| ",n,i,R[i].TrongSo);
			DuongDi(n,i);
			if(i!=n)
				printf("%d",i);
			else printf("DAY LA DINH MA BAN DA CHON!!!");
		}
	}
}

//do thi vo huong
void dijkstra2(int n)
{
	R[n].TrongSo = 0;
	marked[n] = true;
	int i,j,k=1;
	while(k<dinh-1)
	{
		for(i=1;i<=dinh;i++)
		{
			if(marked[i])
			{
				for(j=1;j<=dinh;j++)
				{
					if(M[i][j] != 0)
					{	
						int z = R[j].TrongSo;
						R[j].TrongSo = min(R[j].TrongSo, R[i].TrongSo + M[i][j]);
						
						if(R[j].TrongSo != z)
							R[j].parent = i;
						marked[j] = true;
					}
					
					if(M[j][i] != 0)
					{	
						int z = R[j].TrongSo;
						R[j].TrongSo = min(R[j].TrongSo, R[i].TrongSo + M[j][i]);
						
						if(R[j].TrongSo != z)
							R[j].parent = i;
						marked[j] = true;
					}
				}
			}
		}
		k++;
	}
	
	for(i=1;i<=dinh;i++)
	{
		if(R[i].TrongSo == N)
			printf("\nKHONG CO DUONG DI TU %d->%d",n,i);
		else
		{
			printf("\nDuong di ngan nhat tu %d -> %d la: %d\t|| ",n,i,R[i].TrongSo);
			DuongDi(n,i);
			if(i!=n)
				printf("%d",i);
			else printf("DAY LA DINH MA BAN DA CHON!!!");
		}
	}
}


int main()
{
	Nhap();
	int n;
	printf("\nNHAP DINH BAT DAU: ");
	scanf("%d",&n);
	printf("\n1. Do thi vo huong!!!");
	printf("\n2. Do thi co huong!!!");
	int m;
	printf("\nDo thi cua ban la loai do thi nao? : ");
	scanf("%d",&m);
	if(m==1)
	{
		printf("\n----------DO THI VO HUONG----------\n");
		dijkstra2(n);
	}else
	{
		printf("\n----------DO THI CO HUONG----------\n");	
		dijkstra1(n);
	}
	
	return 0;
}