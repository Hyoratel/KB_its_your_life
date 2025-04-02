// 배열, 객체는 값이 아니라 레퍼런스(주소)를 가지고 있는 것이다! => 그림으로 이해하는게 편함.

let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1;
console.log(n, a, gender);
