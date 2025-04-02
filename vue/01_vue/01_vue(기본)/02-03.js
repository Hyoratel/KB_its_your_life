const p1 = { name: 'john', age: 20 };
p1.age = 22;

console.log(p1);
// const는 상수를 선언하기 때문에 값 변경이 불가!
p1 = { name: 'Lee', age: 25 };
