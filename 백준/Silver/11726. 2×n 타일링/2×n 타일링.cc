#include <iostream>

using namespace std;

int d[10001];

int main()
{
    int n;
    cin>>n;
    d[1]=1,d[0]=1;
    for(int i=2; i<=n;i++)
    {
        d[i]=d[i-1]+d[i-2];
        d[i]%=10007;
    }
    cout<< d[n]<<'\n';
    return 0;
}