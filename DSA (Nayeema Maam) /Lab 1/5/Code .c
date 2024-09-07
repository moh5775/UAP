#include<stdio.h>
int main()
{
    int n,i,m;
    printf("1st Array size: ");
    scanf("%d",&m);
    printf("2nd Array size: ");
    scanf("%d",&n);
    int a[m],b[n],c[m+n];
    printf("Enter 1st Array elements: ");
    for(i=0; i<m; i++)
    {
        scanf("%d",&a[i]);
    }

    printf("Enter 2nd Array elements: ");
    for(i=0; i<n; i++)
    {
        scanf("%d",&b[i]);
    }

    for(i=0; i<(m+n); i++)
    {
        if(i<m)
        {
            c[i]=a[i];
        }
        else if(i>=m)
        {
            c[i]=b[i-m];
        }
    }
    printf("Merged Array: ");
    for(i=0; i<(m+n); i++)
    {
        printf("%d ",c[i]);
    }
}
