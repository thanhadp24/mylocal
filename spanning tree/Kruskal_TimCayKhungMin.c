#include <stdio.h>
#include <stdbool.h>
#define N 10000

struct Canh{
	int dinh1,dinh2;
	int TrongSo;
};

typedef struct Canh C;

int M[N][N];
int canh,dinh;
int dM=0,MST=1;
int Parent[N],Hang[N];
C Sort_Canh[N];

void swap(C *a, C *b)
{
	C tmp = *a;
	*a = *b;
	*b = tmp;
}

void NhapMap()
{
	printf("Nhap so canh: ");
	scanf("%d",&canh);
	printf("\nNhap so dinh: ");
	scanf("%d",&dinh);
	
	int i,j,m,n;
	for(i=1;i<=dinh;i++)
	{
		for(j=1;j<=dinh;j++)
		{
			M[i][j]=0;
		}
	}
	
	printf("\nNhap trong so:\n");
	
	i=1;
	while(i<=canh)
	{
		scanf("%d %d %d",&m,&n,&j);
		M[m][n]=j;
		C a;
		a.dinh1 = m;
		a.dinh2 = n;
		a.TrongSo = j;
		Sort_Canh[i] = a;
		i++;
	}
	
	for(i=1;i<=dinh;i++)
	{
		Parent[i]=i;
		Hang[i]=0;
	}
		
	for(i=1;i<canh;i++)
	{
		int min = i;
		for(j=i+1;j<=canh;j++)
		{
			if(Sort_Canh[j].TrongSo < Sort_Canh[min].TrongSo)
				min = j;
		}
		swap(&Sort_Canh[i],&Sort_Canh[min]);
	}
	
	for(i=1;i<=canh;i++)
	{
		printf("\n%d %d %d",Sort_Canh[i].TrongSo,Sort_Canh[i].dinh1,Sort_Canh[i].dinh2);
	}
}

int find(int a)
{
	if(Parent[a]==a) return Parent[a];
	else return find(Parent[a]);
}

bool join(int a, int b)
{
	a = find(a);
	b = find(b);
	
	if(a==b) return false;
	
	if(Hang[a] == Hang[b]) Hang[a]++;
	
	if(Hang[a] > Hang[b]) Parent[b] = a;
	else Parent[a] = b;
	
	return true;
}

void Kruskal()
{
	int i;
	for(i=1;i<=canh;i++)
	{
		if(join(Sort_Canh[i].dinh1,Sort_Canh[i].dinh2))
		{
			dM += Sort_Canh[i].TrongSo;
			MST++;
		}
		if(MST==dinh) break;
	}
	
	printf("\nDo thi co cay khung nho nhat la: %d",dM);
}

int main(int argc, char* argv[])
{
	NhapMap();
	Kruskal();
	return 0;
}