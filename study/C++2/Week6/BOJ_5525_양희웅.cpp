#include <cstdio>

int main(void)
{
    int N, M;
    char S[1000000];
    char* ptr;
    int ans = 0;

    scanf("%d", &N);
    scanf("%d", &M);
    scanf("%s", S);

    ptr = S;
    for (int i = 0; i < M; i++) {
        if (i + 2 * N == M) {
            break;
        }
        if (*ptr == 'I') { 
            int cnt = 0;
            ptr++;
            if (*ptr == '\0') { // 문장의 끝
                break;
            }
            for (int j = 0; j < 2 * N; j += 2) {
                if (*(ptr + j) == '\0' || *(ptr + j + 1) == '\0') {
                    break;
                }
                if (*(ptr + j) == 'O' && *(ptr + j + 1) == 'I') { // OI 패턴 발견
                    cnt++;
                }
                if (cnt == N) { // OI 가 N번 반복되면 됨
                    ans++;
                    break;
                }
            }
            continue;
        }
        ptr++;
    }
    printf("%d\n", ans);

    return 0;
}