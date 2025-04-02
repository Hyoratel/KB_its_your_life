//홀수 짝수 구별하는 프로그램

let num = -21;

// if (num % 2 == 0) {
//   console.log('짝수입니다');
// }
// if (num % 2 == 1) {
//   console.log('홀수입니다');
// }

if (num % 2 == 0) {
  console.log('짝수입니다.');
} else {
  console.log('홀수입니다.');
}

// 논리합 구조로 인해 홀수입니다. 출력력
if (num % 2 == 0) {
  console.log('짝수입니다.');
} else if (num % 2 != 0) {
  console.log('홀수입니다.');
} else {
  console.log('양수만 입력가능합니다.');
}
// 논리곱 구조로 적용해서 올바른 답 도출
if (num % 2 == 0 && num > 0) {
  console.log('짝수입니다.');
} else if (num % 2 != 0 && num > 0) {
  console.log('홀수입니다.');
} else {
  console.log('양수만 입력가능합니다.');
}
