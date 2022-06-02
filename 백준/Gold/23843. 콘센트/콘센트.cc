#include <bits/stdc++.h>
using namespace std;
#define fast ios_base::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL)
#define ll long long

int N,M,ans=0,idx=0;
priority_queue<int,vector<int>,greater<int>> qq;

int main(void){
    fast;
    cin>>N>>M;
    vector<int> v(N);
    for(int i=0;i<N;++i) cin>>v[i];
    sort(v.begin(),v.end(), greater<int>());

    if(M==1){
        for(int i=0;i<N;++i){
            ans+=v[i];
        }
        cout<<ans; return 0;
    }
    
    if(N<M){
        int mv=0;
        for(int i=0;i<N;++i) mv=max(v[i],mv);
        cout<<mv; return 0;
    }

    for(int i=0;i<M;++i) qq.push(v[i]);
    idx+=M;

    while(idx<N){
        int ns=qq.top(); qq.pop();
        while(ns<=qq.top() and idx<N){
            ns+=v[idx]; idx++;
        }
        qq.push(ns);
    }
    for(int i=0;i<M-1;++i) qq.pop();
    cout<<qq.top();
}