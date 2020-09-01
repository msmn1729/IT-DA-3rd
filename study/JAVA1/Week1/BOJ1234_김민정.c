//
//  main.c
//  ex1008
//
//  Created by 김민정 on 08/10/2019.
//  Copyright © 2019 김민정. All rights reserved.
//

#include <stdio.h>

struct info{
    char name[20];        // 이름
    double score;        // 평점 평균
    int credit;        // 취득 학점
};

int input_data(struct info students[], int n)
{
    int i;
    for(i=0; i<n; i++){
        printf("이름을 입력하세요 : \n");
        scanf("%s", students[i].name);
        printf("평점평균을 입력하세요 : \n");
        scanf("%lf", &students[i].score);
        printf("취득학점을 입력하세요 : \n");
        scanf("%d", &students[i].credit);
        printf("\n");
    }
    return 0;
}
int scholarship(struct info students[], int n)
{
    int i;
    for(i=0; i<n; i++)
        if(students[i].score>=4.3 && students[i].credit>=20)
            printf("%s는 장학생입니다.\n", students[i].name);
    return 0;
}
int main(void)
{
    struct info students[5];     // 5명의 학생
    input_data(students, 5);     // 이름, 평점평균, 취득학점을 입력받는 함수
    scholarship(students, 5);    // 장학생의 이름, 평점평균, 취득학점을 출력하는 함수
    return 0;
}

