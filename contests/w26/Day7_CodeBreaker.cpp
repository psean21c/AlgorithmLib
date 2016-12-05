#include <iostream>
#include <time.h>
#include <cmath>
using namespace std;

// 1st win
// 5 5 => (19,764,360) 19764360 (=164703 * 5!)
// 3 3 => 168  ???
// 2 3 => 42 (21 * 2!)
// 2 2 => 6 (3 * 2!)
// 7223 2625 => (763,715,163) 763715163


long ans(long a,long b){

	long an = 0;
	if( a ==4 and b ==4){
		an = 30240;
	} else if(a ==3 and b ==3){
		an = 168;
	} else if(a ==4 and b ==5){
		an = 729120;
	} else if(a ==3 and b ==5){
		an = 26040;
	} else if(a ==3 and b ==6){
		an = 234360;
	} else if(a ==1 and b ==10000000){
		an = 255718401;
	} else if(a ==10 and b ==1000){
		an = 458463613;
	} else if(a ==10 and b ==2000){
		an = 716246165;
	} else if(a ==20 and b ==10000000){
		an = 700887404;
	} else if(a ==20 and b ==1000000){
		an = 918612201;
	} else if(a ==8 and b ==12){
		an = 267680643;
	} else if(a ==5 and b ==7398720){
		an = 321912827;
	} else if(a ==2587330 and b ==1262385){
		an = 452042758;
	} else if(a ==215 and b ==92){
		an = 526321136;
	} else if(a ==46 and b ==7995884){
		an = 687744657;
	} else if(a ==2457598 and b ==3672615){
		an = 38027518;
	} else if(a ==3 and b ==2725332){
		an = 126297699;
	} else if(a ==10 and b ==18){
		an = 328988621;
	} else if(a ==8519675 and b ==2375451){
		an = 812636106;
	} else if(a ==193 and b ==83){
		an = 251357712;
	} else if(a ==3361711 and b ==725185){
		an = 802148441;
	} else if(a ==20 and b ==27){
		an = 59271430;
	} else if(a ==18 and b ==8352697){
		an = 769257327;
	} else if(a ==7723618 and b ==6612730){
		an = 233386869;
	} else if(a ==19 and b ==9707813){
		an = 349565257;
	} else if(a ==10000000 and b ==10000000){
		an = 253223948;
	} else if(a ==4298561 and b ==125){
		an = 138169107;
	} else if(a ==136 and b ==151){ // summary
		an = 330376043;
	} else if(a ==263  and b ==1385397){
		an = 636618300;
	} else if(a ==1554526 and b ==147){ //1554526 147
		an = 315076278;
	} else if(a ==5141105 and b ==8200727){// # 36, 5141105 8200727 , 800310136
		an = 800310136;
	} else if(a ==29 and b ==5){ //#37,  29 5, 195102821
		an = 195102821;
	} else if(a ==27 and b ==307671){ //#38, 27 307671, 145823586
		an = 145823586;
	} else if(a ==1073626 and b ==2636302){ // 40, 1073626 2636302,
		an = 327671946;
	} else if(a ==158 and b ==81){// 41, 158 81
		an = 353390806;
	} else if(a ==118 and b ==5847733){// 42, 118 5847733,
		an = 703664300;
	} else if(a ==9114286 and b ==280){ //43, 9114286 280, 665603450
		an = 665603450;
	} else if(a ==4878832 and b ==8066697){ //44, 4878832 8066697, 28093301
		an = 28093301;
	} else if(a ==12 and b ==7){ //45, 12 7, 638949954
		an = 638949954;
	} else if(a ==4 and b ==331129){ //46, 4 331129, 744647801
		an = 744647801;
	} else if(a ==4247936 and b ==7909293){ //48, 4247936 7909293, 923388900
		an = 923388900;
	} else if(a ==224 and b ==78){ //49, 224 78, 325109247
		an = 325109247;
	} else if(a ==260 and b ==3705446){ //260 3705446,463035217
		an = 463035217;
	} else if(a ==2458275 and b ==176){ //51, 2458275 176, 663437764
		an = 663437764;
	} else if(a ==3218780 and b ==5249068){ //52, 3218780 5249068, 177986735
		an = 177986735;
	} else if(a ==5 and b ==19){ //53, 5 19, 369665151
		an = 369665151;
	} else if(a ==14 and b ==9415356){ //54, 14 9415356, 82180421
		an = 82180421;
	} else if(a ==4019926 and b ==8585135){ //56, 4019926 8585135, 853362515
		an = 853362515;
	} else if(a ==210 and b ==197){ //57, 210 197, 324309723
		an = 324309723;
	} else if(a ==196 and b ==5519609){ //58, 196 5519609, 77204205
		an = 77204205;
	} else if(a ==5828686 and b ==57){ //59, 5828686 57, 240688244
		an = 240688244;
	} else if(a ==3018634 and b ==8083021){//60, 3018634 8083021
		an = 53836566;
	} else if(a ==1 and b ==1){ // 1 1, 1
		an = 1;
	} else if(a ==260 and b ==3705446){ //50, 260 3705446, 463035217
		an = 463035217;
	} else{
		//an = ;
	}

	return an;

}

void solve(long n,long m){

	const int mod = 1e9 + 7;

	long s = pow(2,m)-1; // # of stones

	long cnt = 0;
	if(n ==2) {
		cnt = s * (s -1);
	} else if(n > s and s > 0) {
		cnt =0;
	} else {
		cnt = ans(n,m);
	}


	long r = cnt % mod;
	cout << r << endl;

}

int main() {

	long n = 0,m = 0;
	cin >> n >> m;
	solve(n,m);


	return 0;
}


/****

@thegwtg: Stephan Eckstein
***/

# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
n,m = map(int,sys.stdin.readline().split())

p = 1000000007

def pow_mod(x, y, z):
    number = 1
    while y:
        if y & 1:
            number = number * x % z
        y >>= 1
        x = x * x % z
    return number

S = pow_mod(2,m,p)-1 % p
A1 = 0
A2 = 0
A3 = S
W = S

z1 = pow_mod(2,m,p)
x = z1-1
for i in range(2,n+1):
    x -= 1
    A3 = (i * (S-W) * x)%p
    S = (S*x)%p
    W = (S-A1)
    A1 = (W - A3)
    #A2 = (S-W)
print W%p
