#include<stdio.h>

void out(int a[],int k);
void Try(int a[],int n,int k,int i);
int d=0;
int main(){
	int n,k;
	scanf("%d %d",&n,&k);
	int a[10] = {0};
	Try(a,n,k,1);
	return 0;
}

void out(int a[],int k){
	printf("%d: ",++d);
	for(int i=1;i<=k;i++){
		printf("%d ",a[i]);
	}
	printf("\n");
}
void Try(int a[],int n,int k,int i){
	for(int j=a[i-1]+1;j<=n-k+i;j++){
		a[i]=j;
		if(i==k){
			out(a,k);
		}
		else Try(a,n,k,i+1);
	}
}
